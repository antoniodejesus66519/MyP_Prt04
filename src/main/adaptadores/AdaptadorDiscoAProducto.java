package adaptadores;

import rockBuster.Producto;
import mixdown.Disco;
import excepciones.SinProductoExcepcion;

/**
 * Clase AdaptadorDiscoAProducto que implementa la interfaz {@link Producto} y adapta un objeto de tipo {@link Disco} a un objeto de tipo Producto.
 * Esta clase permite que un objeto Disco pueda ser tratado como un objeto Producto, proporcionando métodos para acceder a sus propiedades y comportamientos.
 * AdaptadorDiscoAProducto  tiene la funcionalidad de adaptar un objeto Disco a la interfaz Producto, permitiendo que se 
 * pueda utilizar en contextos donde se espera un objeto Producto como en el catálogo de una tienda que vendan diferentes tipos de productos.
 */
public class AdaptadorDiscoAProducto implements Producto{

    /*El objeto Disco que se tratará como un objeto Producto. */
    private final Disco discoAdaptable;

    /**
     * Constructor que inicializa un objeto AdaptadorDiscoAProducto con un objeto Disco.
     * @param discoAdaptable El objeto Disco que se adaptará a un objeto Producto.
     * Este objeto Disco se utilizará para proporcionar la funcionalidad de un objeto Producto.
     */
    public AdaptadorDiscoAProducto(Disco discoAdaptable) {
        this.discoAdaptable = discoAdaptable;
    }

    @Override 
    public String nombre(){
        return discoAdaptable.nombre();
    }

    @Override 
    public String director(){
        return discoAdaptable.artista();
    }

    @Override 
    public int duracion(){
        return discoAdaptable.duracion();
    }

    @Override 
    public String genero(){
        return discoAdaptable.genero();
    }

    @Override 
    public String sipnosis(){
        return "No hay sipnosis disponible para este producto.";
    }

    @Override 
    public double precio(){
        return discoAdaptable.precio();
    }

    @Override 
    public int obtenerId(){
        return discoAdaptable.obtenerId();
    }

    @Override 
    public int disponibles(){
        return discoAdaptable.disponibles();
    }

    @Override 
    public boolean hayDisponibles(){
        return discoAdaptable.hayDisponibles();
    }

    @Override 
    public void rentar() throws SinProductosExcepcion{
        try{
            discoAdaptable.vender();
        }catch(Sin DiscosExcepcion e){
            throw new SinProductosExcepcion("No hay productos disponibles para vender.");
        }
    }

    @Override 
    void devolucion(){
        discoAdaptable.agregarCopia();
    }

    @Override 
    String presentacion(){
        return discoAdaptable.presentacion();
    }
}
