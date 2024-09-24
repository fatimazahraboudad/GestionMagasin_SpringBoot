package com.example.gestionMagasin.Dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AchatDto {

    private Long id;

    private double prix_total;

    private double prix_payee;

    private double prix_restant;

    private List<AchatProQuati> commande;

    private Long idClient;

    private List<PaiementDto> paiementDtoList =new ArrayList<>();




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrix_total() {
        return prix_total;
    }

    public void setPrix_total(double prix_total) {
        this.prix_total = prix_total;
    }

    public double getPrix_payee() {
        return prix_payee;
    }

    public void setPrix_payee(double prix_payee) {
        this.prix_payee = prix_payee;
    }

    public double getPrix_restant() {
        return prix_restant;
    }

    public void setPrix_restant(double prix_restant) {
        this.prix_restant = prix_restant;
    }

    public List<AchatProQuati> getCommande() {
        return commande;
    }

    public void setCommande(List<AchatProQuati> commande) {
        this.commande = commande;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public List<PaiementDto> getPaiementDtoList() {
        return paiementDtoList;
    }

    public void setPaiementDtoList(List<PaiementDto> paiementDtoList) {
        this.paiementDtoList = paiementDtoList;
    }
}
