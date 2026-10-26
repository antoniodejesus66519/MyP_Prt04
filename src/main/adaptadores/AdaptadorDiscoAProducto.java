package adaptadores;

import rockBuster.Producto;
import mixdown.Disco;
import excepciones.SinProductoExcepcion;
import excepciones.SinDiscosExcepcion;

/**
 * Clase AdaptadorDiscoAProducto que implementa la interfaz
 * Producto y adapta un objeto de tipo Disco.
 *
 * Permite que un Disco pueda ser tratado como un Producto
 * dentro del catalogo de RockBuster.
 *
 * Esta clase implementa el patron de diseno Adapter.
 */
public class AdaptadorDiscoAProducto implements Producto {

    /* Disco que sera adaptado a la interfaz Producto. */
    private final Disco discoAdaptable;

    /**
     * Constructor que inicializa el adaptador.
     *
     * @param discoAdaptable Disco que sera adaptado.
     */
    public AdaptadorDiscoAProducto(Disco discoAdaptable) {
        this.discoAdaptable = discoAdaptable;
    }

    /**
     * Obtiene el nombre del disco.
     *
     * @return Nombre del disco.
     */
    @Override
    public String nombre() {
        return discoAdaptable.nombre();
    }

    /**
     * Obtiene el artista del disco como director.
     *
     * @return Nombre del artista.
     */
    @Override
    public String director() {
        return discoAdaptable.artista();
    }

    /**
     * Obtiene la duracion total de las canciones.
     *
     * @return Duracion total del disco en segundos.
     */
    @Override
    public int duracion() {
        return discoAdaptable.duracion();
    }

    /**
     * Obtiene el genero musical del disco.
     *
     * @return Genero del disco.
     */
    @Override
    public String genero() {
        return discoAdaptable.genero();
    }

    /**
     * Devuelve un mensaje porque los discos
     * no cuentan con sinopsis.
     *
     * @return Mensaje informativo.
     */
    @Override
    public String sipnosis() {
        return "No hay sipnosis disponible para este producto.";
    }

    /**
     * Obtiene el precio de venta del disco.
     *
     * @return Precio del disco.
     */
    @Override
    public double precio() {
        return discoAdaptable.precio();
    }

    /**
     * Obtiene la cantidad de discos disponibles.
     *
     * @return Cantidad de ejemplares disponibles.
     */
    @Override
    public int disponibles() {
        return discoAdaptable.disponibles();
    }

    /**
     * Verifica si existen discos disponibles.
     *
     * @return true si hay discos disponibles.
     */
    @Override
    public boolean hayDisponibles() {
        return discoAdaptable.hayDisponibles();
    }

    /**
     * Adapta la operacion de renta de Producto
     * a la operacion de venta de Disco.
     *
     * @throws SinProductoExcepcion Si no hay discos disponibles.
     */
    @Override
    public void rentar() throws SinProductoExcepcion {
        try {
            discoAdaptable.vender();
        } catch (SinDiscosExcepcion e) {
            throw new SinProductoExcepcion(
                "No hay productos disponibles para vender."
            );
        }
    }

    /**
     * Adapta la devolucion de Producto
     * a la operacion de agregar una copia de Disco.
     */
    @Override
    public void devolucion() {
        discoAdaptable.agregarCopia();
    }

    /**
     * Obtiene la presentacion completa del disco.
     *
     * @return Informacion del disco.
     */
    @Override
    public String presentacion() {
        return discoAdaptable.presentacion();
    }
}
