package com.example.gestionMagasin.Services.service_Imp;

import com.example.gestionMagasin.Dtos.ClientDto;
import com.example.gestionMagasin.Entities.Client;
import com.example.gestionMagasin.Mappers.ClientMapper;
import com.example.gestionMagasin.Repository.ClientRepository;
import com.example.gestionMagasin.Services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientDto getClientById(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(()->new RuntimeException("client not found"));

        return ClientMapper.mapper.clientToClientDto(client);
    }

    @Override
    public List<ClientDto> getAllClient() {

        List<Client> clients=clientRepository.findAll();
        return ClientMapper.mapper.clientsToclientDtos(clients);
    }

    @Override
    public ClientDto addClient(ClientDto clientDto) {
        Client newClient = ClientMapper.mapper.clientDtoToClient(clientDto);
        Client clientAdded =clientRepository.save(newClient);
        return ClientMapper.mapper.clientToClientDto(clientAdded);
    }

    @Override
    public ClientDto updateClient(Long id, ClientDto clientDto) {

        Client clientToUpadate = clientRepository.findById(id).orElseThrow(()->new RuntimeException("client not found with id: " +id));
        clientToUpadate.setName(clientDto.getName());
        clientToUpadate.setPrenom(clientDto.getPrenom());
        clientToUpadate.setAdresse(clientDto.getAdresse());
        clientToUpadate.setEmail(clientDto.getEmail());
        clientToUpadate.setNumero(clientDto.getNumero());

        Client clientUpdated = clientRepository.save(clientToUpadate);

        return ClientMapper.mapper.clientToClientDto(clientUpdated);
    }

    @Override
    public String deeletClient(Long id) {
        Client clientToDelete = clientRepository.findById(id).orElseThrow(()->new RuntimeException("client not found with id: " +id));
        clientRepository.delete(clientToDelete);

        return "Client removed";
    }
}
