package com.example.demo.controller;

import com.example.demo.dto.PrestamoCreateDTO;
import com.example.demo.dto.PrestamoDTO;
import com.example.demo.service.PrestamoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/prestamos")
public class PrestamoController {

  private final PrestamoService service;

  public PrestamoController(PrestamoService service) {
    this.service = service;
  }

  // CREATE: POST /prestamos
  @PostMapping
  public ResponseEntity<PrestamoDTO> crear(@Valid @RequestBody PrestamoCreateDTO dto) {
    PrestamoDTO creado = service.createPrestamo(dto);
    // Devuelve 201 Created con Location: /prestamos/{id}
    return ResponseEntity
            .created(URI.create("/prestamos/" + creado.getId()))
            .body(creado);
  }

  // READ (uno): GET /prestamos/{id}
  @GetMapping("/{id}")
  public ResponseEntity<PrestamoDTO> obtenerPorId(@PathVariable Long id) {
    PrestamoDTO dto = service.getPrestamoById(id);
    return ResponseEntity.ok(dto);
  }

  // READ (lista): GET /prestamos
  @GetMapping
  public ResponseEntity<List<PrestamoDTO>> listar() {
    List<PrestamoDTO> lista = service.getAllPrestamos();
    return ResponseEntity.ok(lista);
  }

  // UPDATE: PUT /prestamos/{id}
  @PutMapping("/{id}")
  public ResponseEntity<PrestamoDTO> actualizar(
          @PathVariable Long id,
          @Valid @RequestBody PrestamoDTO dto) {
    PrestamoDTO actualizado = service.updatePrestamo(id, dto);
    return ResponseEntity.ok(actualizado);
  }

  // DELETE: DELETE /prestamos/{id}
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> eliminar(@PathVariable Long id) {
    service.deletePrestamo(id);
    return ResponseEntity.noContent().build(); // 204 No Content
  }

}
