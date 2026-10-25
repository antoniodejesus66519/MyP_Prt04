package mixdown;
/**
 * Clase que representa un objeto Cancion con su título, artista y duración.
 * Cancion es una clase sencilla que solo almacena información sobre una canción
 * específica de cualquier artista o grupo musical.
 */
public class Cancion {
    private final String titulo;
    private final String artista;
    private final int duracion;

    /**
     * Constructor que inicializa una instancia de Cancion con su título, artista y duración.
     * @param titulo el titulo de la canción.
     * @param artista el nombre del artista o grupo musical que interpreta la canción.
     * @param duracion la duración de la canción en segundos.
     */
    public Cancion(String titulo, String artista, int duracion) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracion = duracion;
    }

    /**
     * Método que devuelve el título de la canción.
     * @return El titulo de la canción.
     */
    public String titulo() {
        return titulo;
    }

    /**
     * Método que devuelve el nombre del artista o grupo musical que 
     * interpreta la canción.
     * @return El nombre del artista o grupo musical.
     */
    public String artista() {
        return artista;
    }

    /**
     * Método que devuelve la duración de la canción en segundo.
     * @return La duración de la canción.
     */
    public int duracion() {
        return duracion;
    }
}
