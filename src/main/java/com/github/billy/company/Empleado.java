package com.github.billy.company;

import java.util.Objects;

public class Empleado {

  public static final int MARGEN_INFERIOR = 1_000_000;
  public static final int SUBSIDIO_TRANSPORTE = 65_000;
  public static final int CERO = 0;
  public static final int MARGEN_SUPERIOR = 7_000_000;
  public static final double PORCENTAJE_RETENCION = 0.05;
  private final static int HORAS_LABORALES_POR_MES = 160;
  private String nombreCompleto;
  private double salario;
  private double horasTrabajadas;

  public Empleado(String nombreCompleto, double salario, double horasTrabajadas) {
    validarEntradas(nombreCompleto, salario, horasTrabajadas);
    this.nombreCompleto = nombreCompleto;
    this.salario = salario;
    this.horasTrabajadas = horasTrabajadas;
  }

  private void validarEntradas(String nombreCompleto, double salario, double horasTrabajadas) {
    Objects.requireNonNull(nombreCompleto, "nombreCompleto no puede ser null");
    if (salario <= 0) {
      throw new RuntimeException("salario debe ser mayor a cero");
    }
    if (horasTrabajadas <= 0) {
      throw new RuntimeException("horasTrabajadas debe ser mayor a cero");
    }
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();

    builder.append("DESPRENDIBLE DE PAGO\n");
    builder.append("_____________________\n");
    builder.append("Nombre: ").append(nombreCompleto).append("\n");
    builder.append("Salario: ").append(salario).append("\n");
    builder.append("Horas trabajadas: ").append(horasTrabajadas).append("\n");
    builder.append("Valor hora: ").append(calcularValorHora()).append("\n");
    builder.append("Auxilio de transporte: ").append(calcularAuxilioTransporte()).append("\n");
    builder.append("Retención: ").append(calcularRetencion()).append("\n");
    builder.append("Total a pagar: ").append(calcularTotalSalario()).append("\n");

    return builder.toString();
  }

  private double calcularValorHora() {
    return salario / HORAS_LABORALES_POR_MES;
  }

  private double calcularAuxilioTransporte() {
    return salario <= MARGEN_INFERIOR ? SUBSIDIO_TRANSPORTE : CERO;
  }

  private double calcularRetencion() {
    return salario > MARGEN_SUPERIOR ? (calcularValorHora() * horasTrabajadas * PORCENTAJE_RETENCION) : CERO;
  }

  private double calcularTotalSalario() {
    return calcularSalarioNeto() + calcularAuxilioTransporte() - calcularRetencion();
  }

  private double calcularSalarioNeto() {
    return calcularValorHora() * horasTrabajadas;
  }
}
