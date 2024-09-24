package com.example.gestionMagasin.Dtos;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


public class ProduitDto {

    private Long idProduit;
    private String nom;
    private String Category;
    private double prix;
    private int quantite;

    private List<AchatProduitDto> achatProduitDtoList=new ArrayList<>();

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

    public List<AchatProduitDto> getAchatProduitDtoList() {
        return achatProduitDtoList;
    }

    public void setAchatProduitDtoList(List<AchatProduitDto> achatProduitDtoList) {
        this.achatProduitDtoList = achatProduitDtoList;
    }
}


