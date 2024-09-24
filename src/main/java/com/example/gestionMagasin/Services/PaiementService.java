package com.example.gestionMagasin.Services;

import com.example.gestionMagasin.Dtos.PaiementDto;
import java.util.List;

public interface PaiementService {

    PaiementDto getPaiementById (Long id);
    List<PaiementDto> getAllPaiement();
    PaiementDto addPaiement(PaiementDto paiementDto);
    PaiementDto updatePaiement(Long id, PaiementDto paiementDto);
    String deletePaiement(Long id);
}
