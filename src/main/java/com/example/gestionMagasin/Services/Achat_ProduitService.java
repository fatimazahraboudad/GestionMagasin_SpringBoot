package com.example.gestionMagasin.Services;

import com.example.gestionMagasin.Dtos.AchatProduitDto;
import com.example.gestionMagasin.Entities.Achat_Produit;

import java.util.List;

public interface Achat_ProduitService {

    AchatProduitDto getAchatProduitById (Long id);
    List<AchatProduitDto> getAllAchatProduit();
    AchatProduitDto addAchatProduit(Achat_Produit achatProduit);
    AchatProduitDto updateAchatProduit(Long id, AchatProduitDto achatProduitDto);
    String deleteAchatProduit(Long id);

}
