package com.example.gestionMagasin.Dtos;

import com.example.gestionMagasin.Entities.Achat_Produit_Id;
import com.example.gestionMagasin.Entities.Produit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AchatProduitDto {

    private Achat_Produit_Id id;
    private int quantite;

    public Achat_Produit_Id getId() {
        return id;
    }

    public void setId(Achat_Produit_Id id) {
        this.id = id;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
