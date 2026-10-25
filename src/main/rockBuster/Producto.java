package main.rockBuster;

public interface Producto {
    //NOmbre de la saga o pelicula
    String nombre();
    //DIrector a cargo
    String director();
    //Duracion de la pelicula o saga
    int duracion();
    //Genero de la pelicula o saga
    String genero();
    //Sipnosos de la pelicula o saga
    String sipnosis();
    //Precio de la pelicula o saga
    double precio();
    //Presentacion de la pelicula o saga (creo)
    String presentacion();
    //Rentar la pelicula o saga
    void rentar();
    //Si esta disponible para rentar
    boolean hayDisponibles();
    //Devolver lo rentado
    void devolucion();
    //Num de unidades para rentar disponibles
    int disponibles();
    //NUm identificador
    int obtenerId();
}