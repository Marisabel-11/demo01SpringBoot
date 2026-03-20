package com.example.demo.service;

import com.example.demo.dto.PrestamoCreateDTO;
import com.example.demo.dto.PrestamoDTO;
import com.example.demo.model.Prestamo;

import java.util.List;

public interface PrestamoService {
  public PrestamoDTO createPrestamo(PrestamoCreateDTO dto);
  public PrestamoDTO getPrestamoById(Long id);
  public List<PrestamoDTO> getAllPrestamos();

  //Necesito la ID para editar
  public PrestamoDTO updatePrestamo(Long id, PrestamoDTO dto);
  public void deletePrestamo(Long id);
}
