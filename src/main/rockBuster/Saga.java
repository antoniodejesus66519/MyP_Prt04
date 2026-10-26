package rockBuster;

import excepciones.SinProductoExcepcion;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa un producto compuesto o colección de obras, llamada saga, dentro del catalogo de RockBuster
 * 
 * Actua como el nodo compuesto en el patron Composite
 * Puede almacenar tanto peliculas individuales como otras sagas anidadas de forma recursiva
 */

public class Saga implements Producto {

    private String nombre;
    private String director;
    private int duracion;
    private String genero;
    private String sipnosis;
    private double renta;
    private int disponibilidad;
    private List<Producto> articulos;

    /**
     * Constructor para una nueva saga con sus atributos principales
     * 
     * @param nombre Titulo o nombre de la saga
     * @param director Director o creador representativo
     * @param genero Genero temático
     * @param sipnosis Argumento global de la saga
     * @param disponibilidad Cantidad de paquetes disponibles para renta
     */
    public Saga(String nombre, String director, String genero, String sipnosis, int disponibilidad) {
        this.nombre = nombre;
        this.director = director;
        this.genero = genero;
        this.sipnosis = sipnosis;
        this.disponibilidad = disponibilidad;
        this.articulos = new ArrayList<>();
    }

    /**
     * Agrega un nuevo producto a la coleccion
     * 
     * @param articulo Un tipo Producto que se va agregar
     */
    public void agregar(Producto articulo) {
        if (articulo != null) {
            this.articulos.add(articulo);
        }
    }

    /**
     * Eliminar un elemento de la coleccion
     * 
     * @param articulo Un tipo Producto a eliminar
     */
    public void eliminar(Producto articulo) {
        this.articulos.remove(articulo);
    }

    /**
     * Obtiene el arreglo con todos los productos que forman parte de la saga
     * 
     * @return Un arreglo de tipo Producto
     */
    public Producto[] obtenerArticulos() {
        return this.articulos.toArray(new Producto[0]);
    }

    @Override
    public String nombre() {
        return this.nombre;
    }

    @Override
    public String director() {
        return this.director;
    }

    @Override
    public int duracion() {
        int sumaDuracion = 0;
        for (Producto articulo : this.articulos) {
            sumaDuracion += articulo.duracion();
        }
        return sumaDuracion;
    }

    @Override
    public String genero() {
        return this.genero;
    }

    @Override
    public String sipnosis() {
        return this.sipnosis;
    }

    @Override
    public double precio() {
        double total = 0.0;
        for (Producto articulo : this.articulos) {
            total += articulo.precio();
        }
        return total * 0.95;
    }

    @Override
    public String presentacion() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Saga: ").append(this.nombre).append(" ===")
          .append("\nDirector: ").append(this.director)
          .append("\nGenero: ").append(this.genero)
          .append("\nDuracion total: ").append(duracion()).append(" min")
          .append("\nPrecio total (con 5% de desc.): $").append(String.format("%.2f", precio()))
          .append("\nDisponibles: ").append(this.disponibilidad)
          .append("\nSinopsis: ").append(this.sipnosis)
          .append("\nArticulos incluidos en la saga:");

        for (Producto articulo : this.articulos) {
            sb.append("\n  - ").append(articulo.nombre()).append(" ($").append(articulo.precio()).append(")");
        }
        return sb.toString();
    }

    @Override
    public void rentar() throws SinProductoExcepcion {
        if (!hayDisponibles()) {
            throw new SinProductoExcepcion("No hay copias disponibles de la saga: " + this.nombre);
        }
        this.disponibilidad--;
    }

    @Override
    public boolean hayDisponibles() {
        if (this.disponibilidad > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void devolucion() {
        this.disponibilidad++;
    }

    @Override
    public int disponibles() {
        return this.disponibilidad;
    }
}