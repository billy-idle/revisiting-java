package com.github.billy;

import com.github.billy.company.Empleado;

public class Main {

  public static void main(String[] args) {
    Empleado empleado = new Empleado("John Doe", 8_000_000, 160);
    System.out.println(empleado);
  }
}