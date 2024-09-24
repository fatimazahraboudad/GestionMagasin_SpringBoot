package com.example.gestionMagasin.Mappers;

import com.example.gestionMagasin.Dtos.AchatDto;
import com.example.gestionMagasin.Dtos.ClientDto;
import com.example.gestionMagasin.Entities.Achat;
import com.example.gestionMagasin.Entities.Client;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ClientMapper {

    ClientMapper mapper= Mappers.getMapper(ClientMapper.class);
    Client clientDtoToClient(ClientDto clientDto);
    ClientDto clientToClientDto(Client client);

    List<Client> clientDtosToclients(List<ClientDto> clientDtoList);
    List<ClientDto> clientsToclientDtos(List<Client> clientlist);

}
