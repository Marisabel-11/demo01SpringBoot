package com.example.demo.mapper;

import com.example.demo.dto.PrestamoCreateDTO;
import com.example.demo.dto.PrestamoDTO;
import com.example.demo.model.Prestamo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PrestamoMapper {
  //Entity -> DTO
  PrestamoDTO toDto(Prestamo entity);

  // DTO -> Entity

    @Mapping(target = "id", ignore = true)
    Prestamo toEntity(PrestamoCreateDTO dto);

  List<PrestamoDTO> toDtoList(List<Prestamo> entities);
}
