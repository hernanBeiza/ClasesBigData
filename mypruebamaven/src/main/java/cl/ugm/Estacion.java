package cl.ugm;

import org.apache.hadoop.io.DoubleWritable;

/**
 * Created by hernanBeiza on 6/12/17.
 */
public class Estacion {
    private String nombre;
    private Double temperatura;

    public Estacion(String nombre, Double temperatura) {
        this.nombre = nombre;
        this.temperatura = temperatura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    @Override
    public String toString() {
        return "Estacion{" +
                "nombre='" + nombre + '\'' +
                ", temperatura=" + temperatura +
                '}';
    }
}
