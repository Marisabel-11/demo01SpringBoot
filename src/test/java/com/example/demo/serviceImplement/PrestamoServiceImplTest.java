package com.example.demo.serviceImplement;

import com.example.demo.dto.PrestamoCreateDTO;
import com.example.demo.dto.PrestamoDTO;
import com.example.demo.mapper.PrestamoMapper;
import com.example.demo.model.Prestamo;
import com.example.demo.repository.PrestamoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PrestamoServiceImplTest {
  @Mock
  PrestamoRepository repository;

  @Mock
  PrestamoMapper mapper;

  @InjectMocks
  PrestamoServiceImpl service;

  @Test
  void createPrestamo() {
// Arrange
    PrestamoCreateDTO in = new PrestamoCreateDTO();
    in.setNombre("Mary");
    in.setDni("77226078");
    in.setMonto(new BigDecimal("2000"));
    in.setNumeroCuotas(6);
    in.setTasaInteres(new BigDecimal("0.05"));
    in.setTipoAmortizacion("FRANCESA");

    Prestamo entity = new Prestamo();
    Prestamo saved = new Prestamo();
    saved.setId(1);
    saved.setNombre("Mary");

    PrestamoDTO out = new PrestamoDTO();
    out.setId(1);
    out.setNombre("Mary");

    when(mapper.toEntity(in)).thenReturn(entity);
    when(repository.save(entity)).thenReturn(saved);
    when(mapper.toDto(saved)).thenReturn(out);

    // Act
    PrestamoDTO result = service.createPrestamo(in);

    // Assert
    assertThat(result.getId()).isEqualTo(1L);
    assertThat(result.getNombre()).isEqualTo("Mary");

    verify(repository).save(entity);

  }

  @Test
  void getPrestamoById() {
  }

  @Test
  void getAllPrestamos() {
  }

  @Test
  void updatePrestamo() {
  }

  @Test
  void deletePrestamo() {
  }
}