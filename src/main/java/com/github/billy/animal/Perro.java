package com.github.billy.animal;

public class Perro extends Mascota implements Animal {

  public Perro(String nombre, String edad) {
    super(nombre, edad);
  }

  @Override
  public String haceSonido() {
    return "Guau Guau";
  }
}
