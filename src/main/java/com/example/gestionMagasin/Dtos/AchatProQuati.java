package com.example.gestionMagasin.Dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AchatProQuati {

    private Long id;
    private ProduitDto produitDto;
    private int quantite;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProduitDto getProduitDto() {
        return produitDto;
    }

    public void setProduitDto(ProduitDto produitDto) {
        this.produitDto = produitDto;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
