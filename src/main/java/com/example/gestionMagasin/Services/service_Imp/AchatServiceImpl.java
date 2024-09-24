package com.example.gestionMagasin.Services.service_Imp;

import com.example.gestionMagasin.Dtos.AchatDto;
import com.example.gestionMagasin.Dtos.ProduitDto;
import com.example.gestionMagasin.Entities.Achat;
import com.example.gestionMagasin.Entities.Achat_Produit;
import com.example.gestionMagasin.Entities.Achat_Produit_Id;
import com.example.gestionMagasin.Entities.Produit;
import com.example.gestionMagasin.Mappers.AchatMapper;
import com.example.gestionMagasin.Mappers.ClientMapper;
import com.example.gestionMagasin.Mappers.ProduitMapper;
import com.example.gestionMagasin.Repository.AchatProductRepository;
import com.example.gestionMagasin.Repository.AchatRepository;
import com.example.gestionMagasin.Services.AchatService;
import com.example.gestionMagasin.Services.Achat_ProduitService;
import com.example.gestionMagasin.Services.ClientService;
import com.example.gestionMagasin.Services.ProduitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AchatServiceImpl implements AchatService {

    private final AchatRepository achatRepository;
    private final ProduitService produitService;
    private final Achat_ProduitService achatProductService;
    private final ClientService clientService;



    @Override
    public AchatDto getAchatById(Long id) {
        Achat achat = achatRepository.findById(id).orElseThrow(()->new RuntimeException("Achat not found with "+id));

        return AchatMapper.mapper.achatToAchatDto(achat);
    }

    @Override
    public List<AchatDto>  getAllAchat() {
        List<Achat> achatList =achatRepository.findAll();
        return AchatMapper.mapper.achatsToAchatDtos(achatList);
    }

    @Override
    public AchatDto addAchat(AchatDto achatDto) {
        Achat newAchat =new Achat();
        newAchat.setIdAchat(achatDto.getId());
        newAchat.setPrix_payee(achatDto.getPrix_payee());
        newAchat.setPrix_total(achatDto.getPrix_total());
        newAchat.setPrix_restant(newAchat.getPrix_total()- newAchat.getPrix_payee());
        newAchat.setClient(ClientMapper.mapper.clientDtoToClient(clientService.getClientById(achatDto.getIdClient())));
        Achat achatAdded = achatRepository.save(newAchat);

        achatDto.getCommande().stream().forEach( (commande) ->{
            Produit produit = produitService.getProduitByIdHelper(commande.getProduitDto().getIdProduit());
                if (produit == null) {
                    throw new RuntimeException("Produit non trouvé: " + commande.getProduitDto().getNom());
                }
            Achat_Produit_Id  achatProdId=new Achat_Produit_Id(achatAdded.getIdAchat(),produit.getIdProduit() );
                Achat_Produit achatProduit=new Achat_Produit(
                achatProdId,
                achatAdded,
                produit,
                commande.getQuantite());

            achatProductService.addAchatProduit(achatProduit);

            produitService.updateProduitQuantite(produit.getIdProduit(), commande.getQuantite());
        } );



        return AchatMapper.mapper.achatToAchatDto(achatAdded);
    }


    @Override
    public AchatDto updateAchat(Long id, AchatDto achatDto) {
        Achat achatToUpdate = achatRepository.findById(id).orElseThrow(()->new RuntimeException("Achat not found with "+id));
        achatToUpdate.setPrix_total(achatDto.getPrix_total());
        achatToUpdate.setPrix_payee(achatDto.getPrix_payee());
        achatToUpdate.setPrix_restant(achatDto.getPrix_restant());

        Achat achatUpdated = achatRepository.save(achatToUpdate);
        return AchatMapper.mapper.achatToAchatDto(achatUpdated);
    }

    @Override
    public String deleteAchat(Long id) {
        Achat achatToRemove = achatRepository.findById(id).orElseThrow(()->new RuntimeException("Achat not found with "+id));
        achatRepository.delete(achatToRemove);
        return "achat removed ";
    }

    @Override
    public void updatePrixRestant(Long id, double prix) {
        Achat achatToUpdatePrix = achatRepository.findById(id).orElseThrow(()->new RuntimeException("Achat not found with "+id));
        achatToUpdatePrix.setPrix_restant(achatToUpdatePrix.getPrix_restant()-prix);
        achatRepository.save(achatToUpdatePrix);
    }
}
