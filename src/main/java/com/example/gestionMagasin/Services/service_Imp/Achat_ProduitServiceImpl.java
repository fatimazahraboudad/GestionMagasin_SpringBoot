package com.example.gestionMagasin.Services.service_Imp;

import com.example.gestionMagasin.Dtos.AchatProduitDto;
import com.example.gestionMagasin.Entities.Achat_Produit;
import com.example.gestionMagasin.Mappers.AchatProduitMapper;
import com.example.gestionMagasin.Repository.AchatProductRepository;
import com.example.gestionMagasin.Services.Achat_ProduitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Achat_ProduitServiceImpl implements Achat_ProduitService {


    private final AchatProductRepository achatProductRepository;

    public Achat_ProduitServiceImpl(AchatProductRepository achatProductRepository) {
        this.achatProductRepository = achatProductRepository;
    }

    @Override
    public AchatProduitDto getAchatProduitById(Long id) {

        return null;
    }

    @Override
    public List<AchatProduitDto> getAllAchatProduit() {
        return null;
    }

    @Override
    public AchatProduitDto addAchatProduit(Achat_Produit achatProduit) {

        Achat_Produit achatProduit1= achatProductRepository.save(achatProduit);

        return AchatProduitMapper.mapper.achatproduitTOachatproduitDTO(achatProduit1);
    }

    @Override
    public AchatProduitDto updateAchatProduit(Long id, AchatProduitDto achatProduitDto) {
        return null;
    }

    @Override
    public String deleteAchatProduit(Long id) {
        return null;
    }
}
