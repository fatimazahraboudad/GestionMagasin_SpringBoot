package com.example.gestionMagasin.Mappers;

import com.example.gestionMagasin.Dtos.PaiementDto;
import com.example.gestionMagasin.Dtos.ProduitDto;
import com.example.gestionMagasin.Entities.Paiement;
import com.example.gestionMagasin.Entities.Produit;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PaiementMapper {

    PaiementMapper mapper= Mappers.getMapper(PaiementMapper.class);
    Paiement paiementDtoToPaiement(PaiementDto paiementDto);
    PaiementDto paiementToPaimentDto(Paiement paiement);

    List<Paiement> paiementsDtosTopaiements(List<PaiementDto> paiementDtoList);
    List<PaiementDto> paiementsTopaiementDtos(List<Paiement> paiementlist);
}
