package com.example.gestionMagasin.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="achat")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Achat {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long idAchat;

     @Column(name="prix_total")
     private double prix_total;

     @Column(name="prix_payee")
     private double prix_payee;

     @Column(name="prix_restant")
     private double prix_restant;

     @ManyToOne
     @JoinColumn(
             name = "client_id_achat",
             referencedColumnName = "idClient",
             foreignKey = @ForeignKey(
                     name = "client_id_achat_FK"
             )
     )
     private Client Client;


     @OneToMany(
             mappedBy = "achat",
             cascade = CascadeType.PERSIST
     )
     List<Paiement> listOfPaiement=new ArrayList<>();



     @OneToMany(
             mappedBy = "achat",
             cascade = CascadeType.PERSIST
     )
     List<Achat_Produit> AchatProduit=new ArrayList<>();

     public Long getIdAchat() {
          return idAchat;
     }

     public void setIdAchat(Long idAchat) {
          this.idAchat = idAchat;
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

     public com.example.gestionMagasin.Entities.Client getClient() {
          return Client;
     }

     public void setClient(com.example.gestionMagasin.Entities.Client client) {
          Client = client;
     }

     public List<Paiement> getListOfPaiement() {
          return listOfPaiement;
     }

     public void setListOfPaiement(List<Paiement> listOfPaiement) {
          this.listOfPaiement = listOfPaiement;
     }

     public List<Achat_Produit> getAchatProduit() {
          return AchatProduit;
     }

     public void setAchatProduit(List<Achat_Produit> achatProduit) {
          AchatProduit = achatProduit;
     }
}
