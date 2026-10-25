package mixdown;

import excepciones.SinDiscosExcepcion;


/**
 * Clase que representa un disco(Album) que contiene una colección de canciones de
 * un artista o un grupo músical.
 * Disco tendrá la información de un disco fisico como es su nombre, el artista o 
 * grupo músical que interpreto el diso, su género, la fecha de lanzamiento del disco
 * y la colección de sus canciones incluidas en el disco. La clase también tiene propiedades
 * como la disponibilidad y el precio de venta que se le dará en la sucursal en la que
 * se esta vendiendo el ejemplar.
 */
public class Disco {

    private final String nombre;
    private final String artista;
    private final String genero;
    private final int fechaEstreno;
    private final double precioVenta;
    private int disponibilidad;
    private final Cancion[] canciones;

    /**
     * Método constructor que inicializa un objeto Disco con todos sus 
     * atributos definidos, además de un identificador con la cuál 
     * lo podremos buscar en el catálogo de la tienda.
     * @param nombre El nombre del disco.
     * @param artista El nombre del artista o grupo músical que interpreta las
     * canciones del Disco.
     * @param genero El género músical con el que se le asigna el Disco.
     * @param fechaEstreno La fecha de lanzamiento del Disco.
     * @param precioVenta El precio de venta que se le dio al Disco en la sucursal de venta.
     * @param disponibilidad La cantidad de productos disponibles del articulo Disco.
     * @param canciones La colección de canciones que alberga el Disco.
     */
    public Disco(String nombre,
                 String artista,
                 String genero,
                 int fechaEstreno,
                 double precioVenta,
                 int disponibilidad, 
                 Cancion[] canciones) {
        this.nombre = nombre;
        this.artista = artista;
        this.genero = genero;
        this.fechaEstreno = fechaEstreno;
        this.precioVenta = precioVenta;
        this.disponibilidad = disponibilidad;
        this.canciones = canciones;
    }

    /**
     * Método que devuelve el nombre del Disco.
     * @return El nombre del Disco.
     */
    public String nombre(){
        return this.nombre;
    }

    /**
     * Método que devuelve el nombre del artista o grupo músical
     * que interpreta las canciones del Disco.
     * @return El nombre del artista o grupo músical.
     */
    public String artista(){
        return this.artista;
    }

    /**
     * Método que devuelve el género músical que se le asigno al Disco.
     * @return El género músical del Disco.
     */
    public String genero(){
        return this.genero;
    }
    
    /**
     * Método que devuelve la fecha de lanzamiento en el cuál se
     * estreno el Disco.
     * @return La fecha de lanzamiento del Disco.
     */
    public int fechaEstreno(){
        return this.fechaEstreno;
    }

    /**
     * Método que devuelve el valor del Disco dado en la sucursal de venta
     * del mismo.
     * @return El precio en doble punto flotante que representa el
     * valor del Disco en la sucursal.
     */
    public double precio(){
        return this.precioVenta;
    }

    /**
     * Método que devuelve la colección de canciones que tiene el disco de tipo
     * {@link Cancion}.
     * @return La colección de canciones del Disco.
     */
    public Cancion[] coleccionCanciones(){
        return this.canciones;
    }

    /**
     * Método que devuelve el número de ejemplares del Disco
     * que contiene la sucursal para la venta del Disco.
     * @return La cantidad de ejemplares del mismo Disco en venta.
     */
    public int disponibles(){
        return this.disponibilidad;
    }

    /**
     * Método que obtiene la duración total que alberga escuchar
     * todo el Disco con todas sus canciones en segundos-
     * @return la duración del Disco en segundos.
     */
    public int duracion(){
        int duracion = 0;
        if(canciones != null){
            for (Cancion c : canciones) {
            duracion += c.duracion();
            }
        }

        return duracion;
    }

    /**
     * Método que nos dice si hay ejemplares disponibles del Disco para vender.
     * @return Un valor verdadero (True) si hay ejemplares del Disco para vender.
     * Un valor falso (False) en otro caso.
     */
    public boolean hayDisponibles(){
        return disponibilidad > 0;
    }

    /**
     * Método que agrega un ejemplar del Disco a la sucursal para vender.
     */
    public void agregarCopia(){
        disponibilidad++;
    }

    /**
     * Método que elimina un ejemplar del Disco de la sucursal porque fue vendido.
     */
    public void vender() throws SinDiscosExcepcion {
        if(disponibilidad > 0){
            disponibilidad--;
        }else{
            throw new SinDiscosExcepcion("No hay más discos disponibles en el inventario.");
        }
    }

    /**
     * Método auxiliar para formatear la duración de segundos a formato MM:SS.
     */
    private String formatearTiempo(int segundosTotales) {
        int min = segundosTotales / 60;
        int seg = segundosTotales % 60;
        return String.format("%02d:%02d", min, seg);
    }

    /**
     * Genera una representación estética en consola del disco.
     * @return Cadena formateada para la terminal.
     */
    public String presentacion() {
        StringBuilder sb = new StringBuilder();
        String linea = "========================================================================\n";
        String separador = "------------------------------------------------------------------------\n";

        sb.append(linea);
        sb.append(String.format("  DISCO: %-56s\n", nombre.toUpperCase()));
        sb.append(linea);
        sb.append(String.format("  * Artista        : %-48s\n", artista));
        sb.append(String.format("  * Género         : %-48s\n", genero));
        sb.append(String.format("  * Año de Estreno : %-48d\n", fechaEstreno));
        sb.append(String.format("  * Precio         : $%-47.2f\n", precioVenta));
        sb.append(String.format("  * Disponibilidad : %-48s\n", disponibilidad + " ejemplares"));
        sb.append(String.format("  * Duración Total : %-48s\n", formatearTiempo(duracion()) + " min (" + duracion() + " seg)"));
        sb.append(separador);
        sb.append("  CANCIONES INCLUIDAS:\n");
        sb.append(separador);

        if (canciones != null && canciones.length > 0) {
            for (int i = 0; i < canciones.length; i++) {
                Cancion c = canciones[i];
                String tituloFormat = c.titulo(); 
                
                // Para títulos muy largos para mantener el recuadro alineado
                if (tituloFormat.length() > 42) {
                    tituloFormat = tituloFormat.substring(0, 39) + "...";
                }
                
                sb.append(String.format("   %02d. %-45s [%s]\n", 
                        (i + 1), 
                        tituloFormat, 
                        formatearTiempo(c.duracion())));
            }
        } else {
            sb.append("   (Sin canciones registradas)\n");
        }

        sb.append(linea);
        return sb.toString();
    }



}
