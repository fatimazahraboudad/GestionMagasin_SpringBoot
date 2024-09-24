package com.example.gestionMagasin.Services;
import com.example.gestionMagasin.Dtos.ProduitDto;
import com.example.gestionMagasin.Entities.Produit;

import java.util.List;

public interface ProduitService {

    ProduitDto getProduitById (Long id);
    Produit getProduitByIdHelper (Long id);

    List<ProduitDto> getAllProduit();
    ProduitDto addProduit(ProduitDto produitDto);
    ProduitDto updateProduit(Long id, ProduitDto produitDto);
    String deleteProduit(Long id);
    ProduitDto updateProduitQuantite(Long id, int quantite);

}
