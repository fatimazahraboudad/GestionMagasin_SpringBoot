package com.example.gestionMagasin.Services;

import com.example.gestionMagasin.Dtos.AchatDto;
import com.example.gestionMagasin.Dtos.ProduitDto;

import java.util.List;

public interface AchatService {

    AchatDto getAchatById (Long id);
    List<AchatDto> getAllAchat();
    AchatDto addAchat(AchatDto achatDto);
    AchatDto updateAchat(Long id, AchatDto achatDto);
    String deleteAchat(Long id);

    void updatePrixRestant(Long id, double prix);

}
