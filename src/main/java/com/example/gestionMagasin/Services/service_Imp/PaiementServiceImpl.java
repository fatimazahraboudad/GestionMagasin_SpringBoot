package com.example.gestionMagasin.Services.service_Imp;

import com.example.gestionMagasin.Dtos.PaiementDto;
import com.example.gestionMagasin.Entities.Paiement;
import com.example.gestionMagasin.Mappers.PaiementMapper;
import com.example.gestionMagasin.Repository.PaiementRepository;
import com.example.gestionMagasin.Services.AchatService;
import com.example.gestionMagasin.Services.PaiementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaiementServiceImpl implements PaiementService {

    private final PaiementRepository paiementRepository;
    private final AchatService achatService;

    public PaiementServiceImpl(PaiementRepository paiementRepository, AchatService achatService) {
        this.paiementRepository = paiementRepository;
        this.achatService = achatService;
    }

    @Override
    public PaiementDto getPaiementById(Long id) {
        Paiement paiement = paiementRepository.findById(id).orElseThrow(()->new RuntimeException("paiement not found with id :"+id));

        return PaiementMapper.mapper.paiementToPaimentDto(paiement);
    }

    @Override
    public List<PaiementDto> getAllPaiement() {
        List<Paiement> paiementList = paiementRepository.findAll();
        return PaiementMapper.mapper.paiementsTopaiementDtos(paiementList);
    }

    @Override
    public PaiementDto addPaiement(PaiementDto paiementDto) {
        Paiement newPaiement= PaiementMapper.mapper.paiementDtoToPaiement(paiementDto);
        if(newPaiement.getAchat().getPrix_restant()!=0){
            achatService.updatePrixRestant(newPaiement.getAchat().getIdAchat(),paiementDto.getMontant());
        }
        Paiement paiementAdded = paiementRepository.save(newPaiement);
        return PaiementMapper.mapper.paiementToPaimentDto(paiementAdded);
    }

    @Override
    public PaiementDto updatePaiement(Long id, PaiementDto paiementDto) {
        Paiement paiementToUpdate = paiementRepository.findById(id).orElseThrow(()->new RuntimeException("paiement not found with id :"+id));
        paiementToUpdate.setMontant(paiementDto.getMontant());


        Paiement paiementUpdated= paiementRepository.save(paiementToUpdate);
        return PaiementMapper.mapper.paiementToPaimentDto(paiementUpdated);
    }

    @Override
    public String deletePaiement(Long id) {
        Paiement paiementToRemove = paiementRepository.findById(id).orElseThrow(()->new RuntimeException("paiement not found with id :"+id));
        paiementRepository.delete(paiementToRemove);
        return "paiement removed";
    }
}
