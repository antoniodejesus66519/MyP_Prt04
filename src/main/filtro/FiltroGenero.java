package filtro;

import rockBuster.Producto;

/**
 * Criterios de filtrado concretos que selecciona productos segun su genero
 */
public class FiltroGenero implements FiltroProducto {

    private String genero;

    /**
     * Construye un filtro de genero con un criterio inicial
     * 
     * @param genero Cadena de texto con el genero a buscar
     */
    public FiltroGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public boolean cumpleCriterio(Producto producto) {
        if (producto == null || this.genero == null) {
            return false;
        }
        return producto.genero().equalsIgnoreCase(this.genero);
    }

    /**
     * Actualiza el genero objetivo del filtro
     * 
     * @param genero Nuevo genero a establecer para las comparaciones
     */
    public void fijarGenero(String genero) {
        this.genero = genero;
    }
}