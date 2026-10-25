package main.rockBuster;

import java.util.ArrayList;

/**
 * Clase Catalogo que representa un catálogo de productos en la tienda rockBuster.
 * Catalogo es una clase que permite agregar, eliminar y buscar productos en el catálogo, 
 * así como filtrar productos según ciertos criterios. La clase utiliza una lista de objetos
 * que implementan la interfaz {@link Producto} para almacenar los productos disponibles en la tienda.
 * La clase también utiliza la interfaz {@link FiltroProducto} para filtrar los productos según ciertos 
 * criterios definidos por el usuario.
 */
public class Catalogo {

    private ArrayList<Producto> productos;

    /**
     * Constructor de la clase Catalogo que solo inicializa la lista
     * de productos.
     */
    public Catalogo() {
        this.productos = new ArrayList<>();
    }

    /**
     * Agrega un producto al catálogo y le asigna un identificador único.
     * @param producto El producto de la tienda a agregar al catálogo.
     */
    public void agregarProducto(Producto producto) {
        if (producto != null) {
            productos.add(producto);
        }
    }

    /**
     * Elimina un producto del catálogo.
     * @param producto El producto a eliminar del catálogo.
     */
    public void eliminarProducto(Producto producto){
        productos.remove(producto);
    }

    /**
     * Obtiene un producto del catálogo según su identificador único.
     * @param id El identificador único del producto a buscar en el catálogo.
     * @return El objeto con el identificador único especificado.
     */
    public Producto obtenerProducto(int id) throws NoExisteProductoExcepcion{
        int indice = numeroSeleccion - 1; 
        
        if (indice >= 0 && indice < productos.size()) {
            return productos.get(indice);
        }
        
        throw new NoExisteProductoExcepcion("No existe un producto con el identificador actual.");
    }

    /**
     * Filtra los productos del catálogo según un criterio definido por el usuario.
     * @param filtro El filtro a aplicar sobre los productos.
     * @return Una lista con los productos que cumplen con el criterio.
     */
    public ArrayList<Producto> filtrar(FiltroProducto filtro){
        ArrayList<Producto> productosFiltrados = new ArrayList<>();
        for(Producto producto : productos){
            if(filtro.cumpleCriterio(producto)){
                productosFiltrados.add(producto);
            }
        }
        return productosFiltrados;
    }

    /**
     * Muestra los productos filtrados en formato Nombre y Precio.
     * @param filtrados La lista de productos filtrados a mostrar.
     * @return Una cadena que muestra los productos filtrados.
     */
    public String mostrarFiltrado(ArrayList<Producto> filtrados) {
        StringBuilder sb = new StringBuilder();
        String marcoEncabezado = "==============================================================================\n";
        String marcoSeparador  = "------------------------------------------------------------------------------\n";

        sb.append(marcoEncabezado);
        sb.append("              [ RESULTADOS DE BÚSQUEDA / PRODUCTOS FILTRADOS ]                 \n");
        sb.append(marcoEncabezado);
        sb.append(String.format(" %-5s | %-48s | %-12s\n", "Nº", "NOMBRE DEL PRODUCTO", "PRECIO"));
        sb.append(marcoSeparador);

        if (filtrados == null || filtrados.isEmpty()) {
            sb.append("   ( No se encontraron productos que coincidan con el filtro aplicado )\n");
        } else {
            for (int i = 0; i < filtrados.size(); i++) {
                Producto p = filtrados.get(i);
                String nombreP = p.nombre();
                if (nombreP.length() > 48) {
                    nombreP = nombreP.substring(0, 45) + "...";
                }
                sb.append(String.format(" #%-4d | %-48s | $ %-9.2f\n", 
                        (i + 1), nombreP, p.precio()));
            }
        }

        sb.append(marcoSeparador);
        int totalEncontrados = (filtrados != null) ? filtrados.size() : 0;
        sb.append(String.format(" Coincidencias encontradas: %d de %d productos registrados.\n", 
                totalEncontrados, productos.size()));
        sb.append(marcoEncabezado);

        return sb.toString();
    }

    /**
     * Muestra el catálogo completo en formato de tabla resumida (Nombre y Precio).
     * @return Cadena formateada para la consola.
     */
    public String mostrarCatalogo() {
        StringBuilder sb = new StringBuilder();
        String marcoEncabezado = "==============================================================================\n";
        String marcoSeparador  = "------------------------------------------------------------------------------\n";

        sb.append(marcoEncabezado);
        sb.append("                      ROCKBUSTER - CATÁLOGO COMPLETO                          \n");
        sb.append(marcoEncabezado);
        sb.append(String.format(" %-5s | %-48s | %-12s\n", "Nº", "NOMBRE DEL PRODUCTO", "PRECIO"));
        sb.append(marcoSeparador);

        for (int i = 0; i < productos.size(); i++) {
            Producto p = productos.get(i);
            String nombreP = p.nombre();
            if (nombreP.length() > 48) {
                nombreP = nombreP.substring(0, 45) + "...";
            }
            sb.append(String.format(" #%-4d | %-48s | $ %-9.2f\n", 
                    (i + 1), nombreP, p.precio()));
        }

        sb.append(marcoSeparador);
        sb.append(marcoEncabezado);

        return sb.toString();
    }

}
