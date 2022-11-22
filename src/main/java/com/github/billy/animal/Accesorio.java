package com.github.billy.animal;

public class Accesorio extends Object {
  private String nombre;

  public Accesorio(String nombre) {
    this.nombre = nombre;
  }

  public String getNombre() {
    return nombre;
  }

  @Override
  public String toString() {
    return nombre;
  }
}
