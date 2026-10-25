package excepciones;

/**
 * Excepcion que se produce cuando no hay discos disponibles.
 */
public class SinDiscosExcepcion extends Exception {

    /**
     * Construye la excepcion con un mensaje.
     *
     * @param mensaje Descripcion del error.
     */
    public SinDiscosExcepcion(String mensaje) {
        super(mensaje);
    }
}