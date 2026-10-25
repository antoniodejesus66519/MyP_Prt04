package rockBuster;

import excepciones.SinProductoExcepcion;

public class Pelicula implements Producto {

    private String nombre;
    private String director;
    private int duracion;
    private String genero;
    private String sipnosis;
    private double renta;
    private int disponibilidad;

    public Pelicula(String nombre, String director, int duracion, String genero, String sipnosis, double renta, int disponibilidad) {
        this.nombre = nombre;
        this.director = director;
        this.duracion = duracion;
        this.genero = genero;
        this.sipnosis = sipnosis;
        this.renta = renta;
        this.disponibilidad = disponibilidad;
    }

    
    public String nombre() {
        return this.nombre;
    }

    
    public String director() {
        return this.director;
    }

    
    public int duracion() {
        return this.duracion;
    }

    
    public String genero() {
        return this.genero;
    }

    
    public String sipnosis() {
        return this.sipnosis;
    }

    
    public double precio() {
        return this.renta;
    }

    
    public String presentacion() {
        return "=== Película: " + this.nombre + " ===" +
               "\nDirector: " + this.director +
               "\nGénero: " + this.genero +
               "\nDuración: " + this.duracion + " min" +
               "\nPrecio de renta: $" + this.renta +
               "\nDisponibles: " + this.disponibilidad +
               "\nSinopsis: " + this.sipnosis;
    }

    
    public void rentar() throws SinProductoExcepcion {
        if (!hayDisponibles()) {
            throw new SinProductoExcepcion("No hay copias disponibles de la película: " + this.nombre);
        }
        this.disponibilidad--;
    }

    
    public boolean hayDisponibles() {
        if (this.disponibilidad > 0) {
            return true;
        } else {
            return false;
        }
    }

    
    public void devolucion() {
        this.disponibilidad++;
    }

    
    public int disponibles() {
        return this.disponibilidad;
    }
}