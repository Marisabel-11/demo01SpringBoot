package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class PrestamoCreateDTO {
  private String nombre;
  private String dni;
  private BigDecimal monto;
  private Integer numeroDeCuotas;
  private BigDecimal tasaDeInteres;
  private String tipoDeAmortizacion;
}
