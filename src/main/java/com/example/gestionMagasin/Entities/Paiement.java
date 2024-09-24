package com.example.gestionMagasin.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="paiement")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Paiement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaiement;
    private double montant;

    @ManyToOne
    @JoinColumn(
            name = "achat_id_paiement",
            referencedColumnName = "idAchat",
            foreignKey = @ForeignKey(
                    name = "achat_id_paiement_FK"
            )
    )
    private Achat achat;

    public Long getIdPaiement() {
        return idPaiement;
    }

    public void setIdPaiement(Long idPaiement) {
        this.idPaiement = idPaiement;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Achat getAchat() {
        return achat;
    }

    public void setAchat(Achat achat) {
        this.achat = achat;
    }
}
