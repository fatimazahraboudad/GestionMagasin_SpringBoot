package com.example.gestionMagasin.Repository;

import com.example.gestionMagasin.Entities.Achat_Produit;
import com.example.gestionMagasin.Entities.Achat_Produit_Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AchatProductRepository extends JpaRepository<Achat_Produit, Achat_Produit_Id> {
}
