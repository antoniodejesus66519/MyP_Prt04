package filtro;

import rockBuster.Producto;

/**
 * Criterios de filtrado concretos que selecciona productos cuyo precio sea menor al limite solicitado
 */
public class FiltroPrecioMaximo implements FiltroProducto {

    private double precio;

    /**
     * Construye un filtro de precio máximo con un límite numérico
     * 
     * @param precio Costo máximo permitido
     */
    public FiltroPrecioMaximo(double precio) {
        this.precio = precio;
    }

    @Override
    public boolean cumpleCriterio(Producto producto) {
        if (producto == null) {
            return false;
        }
        return producto.precio() <= this.precio;
    }

    /**
     * Establece o actualiza el límite de precio máximo mediante un valor entero
     * 
     * @param precio Nuevo límite monetario en forma de entero
     */
    public void fijarPrecio(int precio) {
        this.precio = precio;
    }

    /**
     * Establece o actualiza el límite de precio máximo mediante un valor de punto flotante
     * 
     * @param precio Nuevo límite monetario en forma de double
     */
    public void fijarPrecio(double precio) {
        this.precio = precio;
    }
}