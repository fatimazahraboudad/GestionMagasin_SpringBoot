package com.example.gestionMagasin.Services;

import com.example.gestionMagasin.Dtos.ClientDto;

import java.util.List;

public interface ClientService {

    ClientDto getClientById(Long id);
    List<ClientDto> getAllClient();
    ClientDto addClient(ClientDto clientDto);
    ClientDto updateClient(Long id ,ClientDto clientDto);
    String deeletClient(Long id);

}
