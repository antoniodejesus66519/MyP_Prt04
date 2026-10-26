package rockBuster;

import excepciones.SinProductoExcepcion;

/**
 * Representa una pelicula individual dentro del catalogo de RockBuster
 * 
 * Actua como un nodo hoja dentro del patrón Composite
 * representando un producto elemental que no contiene otros componentes hijos
 */

public class Pelicula implements Producto {

    private String nombre;
    private String director;
    private int duracion;
    private String genero;
    private String sipnosis;
    private double renta;
    private int disponibilidad;

    /**
     * COntructor de una Pelicula con sus atributos
     * 
     * @param nombre Titulo de la película
     * @param director Director de la obra
     * @param duracion Duración en minutos
     * @param genero Genero cinematográfico
     * @param sipnosis Resumen o sinopsis del argumento
     * @param renta Costo de renta
     * @param disponibilidad Cantidad de copias iniciales
     */
    public Pelicula(String nombre, String director, int duracion, String genero, String sipnosis, double renta, int disponibilidad) {
        this.nombre = nombre;
        this.director = director;
        this.duracion = duracion;
        this.genero = genero;
        this.sipnosis = sipnosis;
        this.renta = renta;
        this.disponibilidad = disponibilidad;
    }

    @Override
    public String nombre() {
        return this.nombre;
    }

    @Override
    public String director() {
        return this.director;
    }

    @Override
    public int duracion() {
        return this.duracion;
    }

    @Override
    public String genero() {
        return this.genero;
    }

    @Override
    public String sipnosis() {
        return this.sipnosis;
    }

    @Override
    public double precio() {
        return this.renta;
    }

    @Override
    public String presentacion() {
        return "=== Película: " + this.nombre + " ===" +
               "\nDirector: " + this.director +
               "\nGenero: " + this.genero +
               "\nDuración: " + this.duracion + " min" +
               "\nPrecio de renta: $" + this.renta +
               "\nDisponibles: " + this.disponibilidad +
               "\nSinopsis: " + this.sipnosis;
    }

    @Override
    public void rentar() throws SinProductoExcepcion {
        if (!hayDisponibles()) {
            throw new SinProductoExcepcion("No hay copias disponibles de la pelicula: " + this.nombre);
        }
        this.disponibilidad--;
    }

    @Override
    public boolean hayDisponibles() {
        if (this.disponibilidad > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void devolucion() {
        this.disponibilidad++;
    }

    @Override
    public int disponibles() {
        return this.disponibilidad;
    }
}