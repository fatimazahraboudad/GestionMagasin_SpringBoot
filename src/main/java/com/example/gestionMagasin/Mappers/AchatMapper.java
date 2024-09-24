package com.example.gestionMagasin.Mappers;

import com.example.gestionMagasin.Dtos.AchatDto;
import com.example.gestionMagasin.Entities.Achat;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AchatMapper {

    AchatMapper mapper= Mappers.getMapper(AchatMapper.class);
    List<Achat> achatDtosToAchats(List<AchatDto> achatDtoList);
    List<AchatDto> achatsToAchatDtos(List<Achat> achatlist);

    Achat achatDtoToAchat(AchatDto achatDto);
    AchatDto  achatToAchatDto(Achat achat);

}
