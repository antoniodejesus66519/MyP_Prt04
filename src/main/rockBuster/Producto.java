package rockBuster;

import excepciones.SinProductoExcepcion;

/**
 * Interfaz que define el contrato comun para todos los elementos del catalogo de la tienda RockBuster
 * 
 *Parte del patron Composite que implementan Producto y Saga 
 *
 */
public interface Producto {
    /**
     * Obtiene el nombre del producto
     * 
     * @return Cadena de texto con el nombre del producto
     */
    String nombre();

    /**
     * Obtiene el nombre del director del producto
     * 
     * @return Cadena de texto con el nombre del director 
     */
    String director();

    /**
     *  Obtiene la duracion del producto
     * 
     * @return Entero que representa la duracion total
     */
    public int duracion();

    /**
     * Obtiene el genero del producto
     * 
     * @return Cadena de texto con el genero
     */
    public String genero();

    /**
     * Obtiene una sinopsis de la historia del producto
     * 
     * @return Cadena de texto con la sinopsis
     */
    public String sipnosis();

    /**
     * Obtiene el precio del producto
     * 
     * @return Valor numerico de punto flotante que representa el precio de renta o venta
     */
    public double precio();

    /**
     * Genera una descripcion del producto
     * 
     * @return Cadena de texto con la ficha completa del producto
     */
    public String presentacion();

    /**
     * Procesa la renta de una copia del producto, actualizar su inventario disponible
     * 
     * @throws SinProductoExcepcion Si no hay unidades disponibles en existencia para rentar
     */
    public void rentar() throws SinProductoExcepcion;

    /**
     * Determina si el producto cuenta con unidades disponibles para renta o consulta
     * 
     * @return true si hay al menos una unidad disponible; false en caso contrario
     */
    public boolean hayDisponibles();

    /**
     * Registra la devolucion de una copia rentada, incrementando el inventario disponible
     */
    public void devolucion();

    /**
     * Consulta la cantidad actual de unidades disponibles en inventario
     * 
     * @return Entero con el numero de copias disponibles
     */
    public int disponibles();
}