package com.example.gestionMagasin.Mappers;

import com.example.gestionMagasin.Dtos.AchatProduitDto;
import com.example.gestionMagasin.Entities.Achat_Produit;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AchatProduitMapper {

    AchatProduitMapper mapper= Mappers.getMapper(AchatProduitMapper.class);

    AchatProduitDto achatproduitTOachatproduitDTO(Achat_Produit achatProduit);
    Achat_Produit achatproduitDtoToachatproduit(AchatProduitDto achatProduitDto);
}
