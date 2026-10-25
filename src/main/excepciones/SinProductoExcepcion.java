package excepciones;

/**
 * Excepcion que se produce cuando un producto
 * no tiene unidades disponibles.
 */
public class SinProductoExcepcion extends Exception {

    /**
     * Construye la excepcion con un mensaje.
     *
     * @param mensaje Descripcion del error.
     */
    public SinProductoExcepcion(String mensaje) {
        super(mensaje);
    }
}