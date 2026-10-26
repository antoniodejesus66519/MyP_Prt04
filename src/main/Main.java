
import adaptadores.AdaptadorDiscoAProducto;
import excepciones.NoExisteProductoExcepcion;
import filtro.FiltroGenero;
import filtro.FiltroPrecioMaximo;
import java.util.ArrayList;
import java.util.Scanner;
import mixdown.Cancion;
import mixdown.Disco;
import rockBuster.Catalogo;
import rockBuster.Pelicula;
import rockBuster.Producto;
import rockBuster.Saga;

/**
 * Clase principal del sistema RockBuster.
 *
 * Permite consultar el catalogo completo de productos,
 * filtrar productos por genero y precio maximo,
 * y consultar la informacion detallada de un producto.
 *
 * El sistema utiliza los patrones de diseno
 * Composite y Adapter.
 */
public class Main {

    private Catalogo catalogo;
    private Scanner scanner;

    /**
     * Metodo principal que inicia la ejecucion.
     *
     * @param args Argumentos de la linea de comandos.
     */
    public static void main(String[] args) {
        Main programa = new Main();
        programa.iniciar();
    }

    /**
     * Inicializa el catalogo, registra los productos
     * y ejecuta el menu principal.
     */
    public void iniciar() {

        catalogo = new Catalogo();
        scanner = new Scanner(System.in);

        cargarProductos();

        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero();
            procesarOpcion(opcion);

        } while (opcion != 0);

        scanner.close();
    }

    /**
     * Crea las peliculas, sagas y discos que
     * forman parte del catalogo de RockBuster.
     *
     * Todos los productos se registran en
     * una unica estructura de datos.
     */
    private void cargarProductos() {

        Pelicula episodioI = new Pelicula(
            "Star Wars Episodio I: La Amenaza Fantasma",
            "George Lucas",
            136,
            "Ciencia ficcion",
            "Dos Jedi descubren una amenaza para la Republica.",
            45.00,
            5
        );

        Pelicula episodioII = new Pelicula(
            "Star Wars Episodio II: El Ataque de los Clones",
            "George Lucas",
            142,
            "Ciencia ficcion",
            "La Republica enfrenta el inicio de las Guerras Clon.",
            45.00,
            4
        );

        Pelicula episodioIII = new Pelicula(
            "Star Wars Episodio III: La Venganza de los Sith",
            "George Lucas",
            140,
            "Ciencia ficcion",
            "Anakin Skywalker se acerca al lado oscuro.",
            50.00,
            3
        );

        Pelicula episodioIV = new Pelicula(
            "Star Wars Episodio IV: Una Nueva Esperanza",
            "George Lucas",
            121,
            "Ciencia ficcion",
            "Luke Skywalker se une a la Alianza Rebelde.",
            50.00,
            5
        );

        Pelicula episodioV = new Pelicula(
            "Star Wars Episodio V: El Imperio Contraataca",
            "Irvin Kershner",
            124,
            "Ciencia ficcion",
            "El Imperio persigue a la Alianza Rebelde.",
            50.00,
            4
        );

        Pelicula episodioVI = new Pelicula(
            "Star Wars Episodio VI: El Retorno del Jedi",
            "Richard Marquand",
            131,
            "Ciencia ficcion",
            "Los rebeldes luchan contra el Imperio.",
            50.00,
            3
        );

        Pelicula rogueOne = new Pelicula(
            "Rogue One: Una Historia de Star Wars",
            "Gareth Edwards",
            133,
            "Ciencia ficcion",
            "Un grupo rebelde busca los planos de la Estrella de la Muerte.",
            48.00,
            4
        );

        /*
         * Patron Composite:
         * Una saga contiene varias peliculas.
         */
        Saga precuelas = new Saga(
            "Saga: Trilogia de Precuelas",
            "George Lucas",
            "Ciencia ficcion",
            "Los origenes de Darth Vader.",
            3
        );

        precuelas.agregar(episodioI);
        precuelas.agregar(episodioII);
        precuelas.agregar(episodioIII);

        Saga original = new Saga(
            "Saga: Trilogia Original",
            "Varios directores",
            "Ciencia ficcion",
            "La lucha de la Alianza Rebelde contra el Imperio.",
            4
        );

        original.agregar(episodioIV);
        original.agregar(episodioV);
        original.agregar(episodioVI);

        /*
         * Composite anidado:
         * Una saga contiene otras sagas y peliculas.
         */
        Saga coleccionStarWars = new Saga(
            "Coleccion Star Wars",
            "Varios directores",
            "Ciencia ficcion",
            "Coleccion de peliculas y trilogias de Star Wars.",
            2
        );

        coleccionStarWars.agregar(precuelas);
        coleccionStarWars.agregar(original);
        coleccionStarWars.agregar(rogueOne);

        /*
         * Patron Adapter:
         * Un Disco se adapta a la interfaz Producto.
         */
        Cancion[] canciones = {
            new Cancion(
                "Come Together",
                "The Beatles",
                259
            ),
            new Cancion(
                "Something",
                "The Beatles",
                182
            ),
            new Cancion(
                "Here Comes the Sun",
                "The Beatles",
                185
            )
        };

        Disco disco = new Disco(
            "Abbey Road",
            "The Beatles",
            "Rock",
            1969,
            120.00,
            5,
            canciones
        );

        AdaptadorDiscoAProducto discoAdaptado =
            new AdaptadorDiscoAProducto(disco);

        /*
         * Registro de todos los productos
         * en el catalogo unico.
         */
        catalogo.agregarProducto(episodioI);
        catalogo.agregarProducto(episodioII);
        catalogo.agregarProducto(episodioIII);
        catalogo.agregarProducto(episodioIV);
        catalogo.agregarProducto(episodioV);
        catalogo.agregarProducto(episodioVI);
        catalogo.agregarProducto(rogueOne);
        catalogo.agregarProducto(precuelas);
        catalogo.agregarProducto(original);
        catalogo.agregarProducto(coleccionStarWars);
        catalogo.agregarProducto(discoAdaptado);
    }

    /**
     * Muestra el menu principal del programa.
     */
    public void mostrarMenu() {

        System.out.println();
        System.out.println("========================================");
        System.out.println("               ROCKBUSTER               ");
        System.out.println("========================================");
        System.out.println("1. Ver catalogo completo");
        System.out.println("2. Filtrar por genero");
        System.out.println("3. Filtrar por precio maximo");
        System.out.println("0. Salir");
        System.out.println("========================================");
        System.out.print("Selecciona una opcion: ");
    }

    /**
     * Ejecuta la opcion seleccionada por el usuario.
     *
     * @param opcion Numero de opcion del menu.
     */
    public void procesarOpcion(int opcion) {

        switch (opcion) {

            case 1:
                System.out.println(
                    catalogo.mostrarCatalogo()
                );

                seleccionarProducto(null);
                break;

               case 2:
    System.out.println();
    System.out.println("Generos disponibles:");
    System.out.println("1. Ciencia ficcion");
    System.out.println("2. Rock");
    System.out.println();

    System.out.print("Ingresa el genero: ");
    String genero = scanner.nextLine().trim();

    if (genero.equalsIgnoreCase("Ciencia ficcion")) {
        genero = "Ciencia ficcion";
    } else if (genero.equalsIgnoreCase("Rock")) {
        genero = "Rock";
    } else {
        System.out.println(
            "El genero ingresado no existe en el catalogo."
        );
        return;
    }

    FiltroGenero filtroGenero =
        new FiltroGenero(genero);

    productosFiltrados =
        catalogo.filtrar(filtroGenero);

    System.out.println();
    System.out.println(
        catalogo.mostrarFiltrado(productosFiltrados)
    );
    break; 

            case 3:
                System.out.print(
                    "Ingresa el precio maximo: "
                );

                double precio = leerDouble();

                if (precio < 0) {
                    System.out.println(
                        "El precio no puede ser negativo."
                    );
                    break;
                }

                FiltroPrecioMaximo filtroPrecio =
                    new FiltroPrecioMaximo(precio);

                ArrayList<Producto> porPrecio =
                    catalogo.filtrar(filtroPrecio);

                System.out.println(
                    catalogo.mostrarFiltrado(porPrecio)
                );

                seleccionarProducto(porPrecio);
                break;

            case 0:
                System.out.println(
                    "Gracias por utilizar RockBuster."
                );
                break;

            default:
                System.out.println(
                    "Opcion no valida. Intenta nuevamente."
                );
                break;
        }
    }

    /**
     * Permite seleccionar un producto del catalogo
     * completo o de una lista de productos filtrados.
     *
     * @param filtrados Lista de productos filtrados.
     *                  Si es null, utiliza el catalogo completo.
     */
    private void seleccionarProducto(
        ArrayList<Producto> filtrados
    ) {

        System.out.println();
        System.out.println(
            "Ingresa el numero del producto para consultar sus detalles."
        );
        System.out.println(
            "Ingresa 0 para regresar al menu."
        );
        System.out.print("Seleccion: ");

        int seleccion = leerEntero();

        if (seleccion == 0) {
            return;
        }

        try {
            Producto producto;

            if (filtrados == null) {

                producto =
                    catalogo.obtenerProducto(seleccion);

            } else {

                if (seleccion < 1 ||
                    seleccion > filtrados.size()) {

                    throw new NoExisteProductoExcepcion(
                        "No existe un producto con ese numero."
                    );
                }

                producto = filtrados.get(seleccion - 1);
            }

            System.out.println();
            System.out.println(
                "===== INFORMACION DEL PRODUCTO ====="
            );

            System.out.println(
                producto.presentacion()
            );

        } catch (NoExisteProductoExcepcion e) {

            System.out.println(
                "Error: " + e.getMessage()
            );
        }
    }

    /**
     * Lee un numero entero ingresado por el usuario.
     *
     * @return Numero entero o -1 si la entrada es invalida.
     */
    private int leerEntero() {

        try {
            return Integer.parseInt(
                scanner.nextLine().trim()
            );

        } catch (NumberFormatException e) {

            System.out.println(
                "Error: Debes ingresar un numero entero."
            );

            return -1;
        }
    }

    /**
     * Lee un numero decimal ingresado por el usuario.
     *
     * @return Numero decimal o -1 si la entrada es invalida.
     */
    private double leerDouble() {

        try {
            return Double.parseDouble(
                scanner.nextLine().trim()
            );

        } catch (NumberFormatException e) {

            System.out.println(
                "Error: Debes ingresar un precio valido."
            );

            return -1;
        }
    }
}
