package rockBuster;

import excepciones.SinProductoExcepcion;

public interface Producto {
    String nombre();
    String director();
    /**
     * Duracion de la pelicula o saga
     */
    int duracion();
    String genero();
    String sipnosis();
    double precio();
    String presentacion();
    void rentar() throws SinProductoExcepcion;
    boolean hayDisponibles();
    void devolucion();
    int disponibles();
}