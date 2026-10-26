package filtro;

import rockBuster.Producto;
/**
 * Interfaz que define los criterios para evaluar y filtrar elementos del catálogo
 */
public interface FiltroProducto {
    /**
     * Evalúa si un producto determinado cumple con la condición de búsqueda.
     * 
     * @param producto Instancia de Producto a evaluar.
     * 
     */
     public boolean cumpleCriterio(Producto producto);
    
}