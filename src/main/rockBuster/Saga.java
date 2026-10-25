package rockBuster;

import excepciones.SinProductoExcepcion;
import java.util.ArrayList;
import java.util.List;

public class Saga implements Producto {

    private String nombre;
    private String director;
    private int duracion;
    private String genero;
    private String sipnosis;
    private double renta;
    private int disponibilidad;
    private List<Producto> articulos;

    public Saga(String nombre, String director, String genero, String sipnosis, int disponibilidad) {
        this.nombre = nombre;
        this.director = director;
        this.genero = genero;
        this.sipnosis = sipnosis;
        this.disponibilidad = disponibilidad;
        this.articulos = new ArrayList<>();
    }

    public void agregar(Producto articulo) {
        if (articulo != null) {
            this.articulos.add(articulo);
        }
    }

    public void eliminar(Producto articulo) {
        this.articulos.remove(articulo);
    }

    public Producto[] obtenerArticulos() {
        return this.articulos.toArray(new Producto[0]);
    }

    
    public String nombre() {
        return this.nombre;
    }

    
    public String director() {
        return this.director;
    }

   
    public int duracion() {
        int sumaDuracion = 0;
        for (Producto articulo : this.articulos) {
            sumaDuracion += articulo.duracion();
        }
        return sumaDuracion;
    }

    
    public String genero() {
        return this.genero;
    }

    
    public String sipnosis() {
        return this.sipnosis;
    }

    
    public double precio() {
        double total = 0.0;
        for (Producto articulo : this.articulos) {
            total += articulo.precio();
        }
        return total * 0.95;
    }

    
    public String presentacion() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Saga: ").append(this.nombre).append(" ===")
          .append("\nDirector: ").append(this.director)
          .append("\nGénero: ").append(this.genero)
          .append("\nDuración total: ").append(duracion()).append(" min")
          .append("\nPrecio total (con 5% de desc.): $").append(String.format("%.2f", precio()))
          .append("\nDisponibles: ").append(this.disponibilidad)
          .append("\nSinopsis: ").append(this.sipnosis)
          .append("\nArtículos incluidos en la saga:");

        for (Producto articulo : this.articulos) {
            sb.append("\n  - ").append(articulo.nombre()).append(" ($").append(articulo.precio()).append(")");
        }
        return sb.toString();
    }

    
    public void rentar() throws SinProductoExcepcion {
        if (!hayDisponibles()) {
            throw new SinProductoExcepcion("No hay copias disponibles de la saga: " + this.nombre);
        }
        this.disponibilidad--;
    }

    
    public boolean hayDisponibles() {
        if (this.disponibilidad > 0) {
            return true;
        } else {
            return false;
        }
    }

   
    public void devolucion() {
        this.disponibilidad++;
    }

   
    public int disponibles() {
        return this.disponibilidad;
    }
}