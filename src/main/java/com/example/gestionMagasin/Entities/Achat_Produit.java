package com.example.gestionMagasin.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Entity
public class Achat_Produit {

    @EmbeddedId
    private Achat_Produit_Id id;


    @ManyToOne
    @MapsId("idAchat")
    @JoinColumn(
            name="achatId_produit",
            referencedColumnName = "idAchat",
            foreignKey = @ForeignKey(
                    name = "achatId_produit_quan_fk"
            )
    )
    private Achat achat;

    @ManyToOne
    @MapsId("idProduit")
    @JoinColumn(
            name="produitId_achat",
            referencedColumnName = "idProduit",
            foreignKey = @ForeignKey(
                    name = "produitId_achat_quan_fk"
            )
    )
    private Produit produit;

    private int quantite;

    public Achat_Produit_Id getId() {
        return id;
    }

    public void setId(Achat_Produit_Id id) {
        this.id = id;
    }

    public Achat getAchat() {
        return achat;
    }

    public void setAchat(Achat achat) {
        this.achat = achat;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }


    public Achat_Produit(Achat_Produit_Id id, Achat achat, Produit produit, int quantite) {
        this.id = id;
        this.achat = achat;
        this.produit = produit;
        this.quantite = quantite;
    }

    public Achat_Produit() {
    }
}
