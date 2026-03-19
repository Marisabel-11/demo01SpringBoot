package com.example.demo.mapper;

import com.example.demo.dto.PrestamoCreateDTO;
import com.example.demo.dto.PrestamoDTO;
import com.example.demo.model.Prestamo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PrestamoMapper {
  //Entity -> DTO
  PrestamoDTO toDto(Prestamo entity);

  // DTO -> Entity
  Prestamo toEntity(PrestamoCreateDTO dto);

  List<PrestamoDTO> toDtoList(List<Prestamo> entities);
}
