package com.github.billy.animal;

import java.util.ArrayList;
import java.util.List;

public abstract class Mascota {

  private final String nombre;
  private final String edad;
  private final List<Accesorio> accesorios;

  public Mascota(String nombre, String edad) {
    this.nombre = nombre;
    this.edad = edad;
    this.accesorios = new ArrayList<>();
  }

  public String getNombre() {
    return nombre;
  }

  public String getEdad() {
    return edad;
  }

  public void agregarAccesorio(Accesorio accesorio) {
    accesorios.add(accesorio);
  }

  @Override
  public String toString() {
    StringBuilder output = new StringBuilder();
    output.append("Especie: " + this.getClass().getSimpleName() + "\n").append("Nombre: " + nombre + "\n").append("Edad: " + edad + "\n");

    if (!accesorios.isEmpty()) {
      output.append("Accesorios: {" + "\n");
      for (Accesorio accesorio : accesorios) {
        output.append("\t").append(accesorio.toString()).append("\n");
      }
      output.append("}");
    }

    return output.toString();
  }
}
