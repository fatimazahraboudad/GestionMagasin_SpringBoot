package com.example.gestionMagasin.Mappers;

import com.example.gestionMagasin.Dtos.ClientDto;
import com.example.gestionMagasin.Dtos.ProduitDto;
import com.example.gestionMagasin.Entities.Client;
import com.example.gestionMagasin.Entities.Produit;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProduitMapper {

    ProduitMapper mapper= Mappers.getMapper(ProduitMapper.class);
    Produit produitDtoToProduit(ProduitDto produitDto);
    ProduitDto produitToProduitDto(Produit produit);

    List<Produit> produitsDtosToproduits(List<ProduitDto> produitDtoList);
    List<ProduitDto> produitsToproduitDtos(List<Produit> produitlist);
}
