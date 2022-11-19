package com.github.billy.company;

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
    this.nombreCompleto = nombreCompleto;
    this.salario = salario;
    this.horasTrabajadas = horasTrabajadas;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();

    builder.append("DESPRENDIBLE DE PAGO\n");
    builder.append("_____________________\n");
    builder.append("Nombre: ").append(this.nombreCompleto).append("\n");
    builder.append("Salario: ").append(this.salario).append("\n");
    builder.append("Horas trabajadas: ").append(this.horasTrabajadas).append("\n");
    builder.append("Valor hora: ").append(this.calcularValorHora()).append("\n");
    builder.append("Auxilio de transporte: ").append(this.calcularAuxilioTransporte()).append("\n");
    builder.append("Retención: ").append(this.calcularRetencion()).append("\n");
    builder.append("Total a pagar: ").append(this.calcularTotalSalario()).append("\n");

    return builder.toString();
  }

  private double calcularValorHora() {
    return this.salario / HORAS_LABORALES_POR_MES;
  }

  private double calcularAuxilioTransporte() {
    return this.salario <= MARGEN_INFERIOR ? SUBSIDIO_TRANSPORTE : CERO;
  }

  private double calcularRetencion() {
    return this.salario > MARGEN_SUPERIOR ? this.salario * PORCENTAJE_RETENCION : CERO;
  }

  private double calcularTotalSalario() {
    return this.calcularSalarioNeto() + this.calcularAuxilioTransporte() - this.calcularRetencion();
  }

  private double calcularSalarioNeto() {
    return calcularValorHora() * this.horasTrabajadas;
  }
}
