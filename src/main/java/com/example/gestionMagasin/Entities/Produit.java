package com.example.gestionMagasin.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="produit")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduit;

    @Column(name="nom")
    private String nom;

    @Column(name="category")
    private String Category;

    @Column(name="prix")
    private double prix;

    @Column(name="quantite")
    private int quantite;


    @OneToMany(
            mappedBy = "produit",
            cascade = CascadeType.PERSIST
    )
    List<Achat_Produit> AchatProduit=new ArrayList<>();

    public Long getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Long idProduit) {
        this.idProduit = idProduit;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public List<Achat_Produit> getAchatProduit() {
        return AchatProduit;
    }

    public void setAchatProduit(List<Achat_Produit> achatProduit) {
        AchatProduit = achatProduit;
    }
}
