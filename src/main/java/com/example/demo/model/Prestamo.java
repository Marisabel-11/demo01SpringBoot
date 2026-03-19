package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@Entity
@Table(name = "prestamos")
public class Prestamo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column(name = "nombre",length = 50, nullable = false)
  private String nombre;
  @Column(name = "dni",length = 8, nullable = false)
  private String dni;
  @Column(name = "monto", nullable = false)
  private BigDecimal monto;
  @Column(name = "numeroDeCuotas", nullable = false)
  private Integer numeroDeCuotas;
  @Column(name = "tasaDeInteres", nullable = false, precision = 5,scale = 2)
  private BigDecimal tasaDeInteres;
  @Enumerated(EnumType.STRING)
  @Column(name = "tipoDeAmortizacion",length = 20, nullable = false)
  private String tipoDeAmortizacion;

  public Prestamo() {
  }

  public Prestamo(Integer id, String nombre, String dni, BigDecimal monto, Integer numeroDeCuotas, BigDecimal tasaDeInteres, String tipoDeAmortizacion) {
    this.id = id;
    this.nombre = nombre;
    this.dni = dni;
    this.monto = monto;
    this.numeroDeCuotas = numeroDeCuotas;
    this.tasaDeInteres = tasaDeInteres;
    this.tipoDeAmortizacion = tipoDeAmortizacion;
  }
}
