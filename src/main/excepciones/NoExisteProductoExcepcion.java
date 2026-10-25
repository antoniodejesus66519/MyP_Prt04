package excepciones;

/**
 * Excepcion que se produce cuando no se encuentra
 * un producto solicitado en el catalogo.
 */
public class NoExisteProductoExcepcion extends Exception {

    /**
     * Construye la excepcion con un mensaje.
     *
     * @param mensaje Descripcion del error.
     */
    public NoExisteProductoExcepcion(String mensaje) {
        super(mensaje);
    }
}