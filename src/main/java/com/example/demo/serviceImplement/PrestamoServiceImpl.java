package com.example.demo.serviceImplement;

import com.example.demo.dto.PrestamoCreateDTO;
import com.example.demo.dto.PrestamoDTO;
import com.example.demo.mapper.PrestamoMapper;
import com.example.demo.model.Prestamo;
import com.example.demo.repository.PrestamoRepository;
import com.example.demo.service.PrestamoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrestamoServiceImpl implements PrestamoService {
  private final PrestamoRepository repository;
  private final PrestamoMapper mapper;

  public PrestamoServiceImpl(PrestamoRepository repository, PrestamoMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  @Override
  public PrestamoDTO createPrestamo(PrestamoCreateDTO dto) {
    Prestamo entity = mapper.toEntity(dto);
    Prestamo saved = repository.save(entity);
    return mapper.toDto(saved);
  }

  @Override
  public PrestamoDTO getPrestamoById(Long id) {
    Prestamo entity = repository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Préstamo no encontrado: " + id));
    return mapper.toDto(entity);

  }

  @Override
  public List<PrestamoDTO> getAllPrestamos() {
    List<Prestamo> entities = repository.findAll();
    return mapper.toDtoList(entities);
  }

  @Override
  public PrestamoDTO updatePrestamo(Long id, PrestamoDTO dto) {

    // Buscar la entidad existente
    Prestamo entity = repository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Préstamo no encontrado: " + id));

    // Ignorar dto.getId() y aplicar cambios
    entity.setNombre(dto.getNombre());
    entity.setDni(dto.getDni());
    entity.setMonto(dto.getMonto());
    entity.setNumeroDeCuotas(dto.getNumeroDeCuotas());
    entity.setTasaDeInteres(dto.getTasaDeInteres());
    entity.setTipoDeAmortizacion(dto.getTipoDeAmortizacion());

    // Guardar y devolver como DTO
    Prestamo updated = repository.save(entity);
    return mapper.toDto(updated);
  }

  @Override
  public void deletePrestamo(Long id) {
    if (!repository.existsById(id)) {
      throw new EntityNotFoundException("Préstamo no encontrado: " + id);
    }
    repository.deleteById(id);
  }

}
