package com.example.gestionMagasin.Entities;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@EqualsAndHashCode
@Embeddable
@Getter
@Setter

public class Achat_Produit_Id implements Serializable {


    private Long idProduit;
    private Long idAchat;

    public Achat_Produit_Id(Long idProduit, Long idAchat) {
        this.idProduit = idProduit;
        this.idAchat = idAchat;
    }

    public Achat_Produit_Id() {
    }

    public Long getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Long idProduit) {
        this.idProduit = idProduit;
    }

    public Long getIdAchat() {
        return idAchat;
    }

    public void setIdAchat(Long idAchat) {
        this.idAchat = idAchat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Achat_Produit_Id that = (Achat_Produit_Id) o;
        return Objects.equals(idProduit, that.idProduit) && Objects.equals(idAchat, that.idAchat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduit, idAchat);
    }
}
