package main.adaptadores;

import main.rockBuster.Producto;
import main.mixdown.Disco;

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

    @Override String nombre(){
        return discoAdaptable.nombre();
    }

    @Override String director(){
        return discoAdaptable.artista();
    }

    @Override int duracion(){
        return discoAdaptable.duracion();
    }

    @Override String genero(){
        return discoAdaptable.genero();
    }

    @Override String sipnosis(){
        return "No hay sipnosis disponible para este producto.";
    }

    @Override double precio(){
        return discoAdaptable.precio();
    }

    @Override int obtenerId(){
        return discoAdaptable.obtenerId();
    }

    @Override int disponibles(){
        return discoAdaptable.disponibles();
    }

    @Override int hayDisponibles(){
        return discoAdaptable.hayDisponibles();
    }

    @Override void rentar() throws SinProductosExcepcion{
        try{
            discoAdaptable.vender();
        }catch(Sin DiscosExcepcion e){
            throw new SinProductosExcepcion("No hay productos disponibles para vender.");
        }
    }

    @Override void devolucion(){
        discoAdaptable.agregarCopia();
    }

    @Override String presentacion(){
        return discoAdaptable.presentacion();
    }
}
