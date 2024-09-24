package com.example.gestionMagasin.Repository;

import com.example.gestionMagasin.Entities.Achat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AchatRepository extends JpaRepository<Achat, Long> {
}
