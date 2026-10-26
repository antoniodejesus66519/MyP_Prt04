import java.util.ArrayList;
import java.util.Scanner;

import rockBuster.Catalogo;
import rockBuster.Pelicula;
import rockBuster.Producto;
import rockBuster.Saga;

import adaptadores.AdaptadorDiscoAProducto;
import excepciones.NoExisteProductoExcepcion;
import filtro.FiltroGenero;
import filtro.FiltroPrecioMaximo;
import mixdown.Cancion;
import mixdown.Disco;

/**
 * Clase principal del sistema RockBuster.
 *
 * Permite consultar un catalogo de peliculas, sagas
 * y discos musicales, filtrar por genero o precio
 * maximo y consultar los detalles de un producto.
 *
 * Utiliza los patrones Composite y Adapter.
 */
public class Main {

    private Catalogo catalogo;
    private Scanner scanner;

    /**
     * Punto de entrada del programa.
     *
     * @param args Argumentos de linea de comandos.
     */
    public static void main(String[] args) {
        Main programa = new Main();
        programa.iniciar();
    }

    /**
     * Inicializa el sistema, agrega los productos
     * al catalogo y ejecuta el menu principal.
     */
    private void iniciar() {

        catalogo = new Catalogo();
        scanner = new Scanner(System.in);

        // Creacion de peliculas individuales.

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

        // Patron Composite: saga con peliculas.

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

        // Composite anidado: saga que contiene otras sagas.

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

        // Patron Adapter: disco convertido a Producto.

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

        // Registro de productos en el catalogo unico.

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

        // Ejecucion del menu principal.

        int opcion;

        do {
            mostrarMenu();

            try {
                opcion = Integer.parseInt(
                    scanner.nextLine().trim()
                );
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            procesarOpcion(opcion);

        } while (opcion != 0);

        scanner.close();
    }

    /**
     * Muestra las opciones disponibles del sistema.
     */
    private void mostrarMenu() {

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
     * Procesa la opcion elegida por el usuario.
     *
     * Permite mostrar productos, aplicar filtros
     * y consultar los detalles de un producto.
     *
     * @param opcion Opcion seleccionada del menu.
     */
    private void procesarOpcion(int opcion) {

        ArrayList<Producto> productosFiltrados = null;

        switch (opcion) {

            case 1:
                System.out.println();
                System.out.println(
                    catalogo.mostrarCatalogo()
                );
                break;

            case 2:
                System.out.print("Ingresa el genero: ");

                String genero = scanner.nextLine();

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

                double precio;

                try {
                    precio = Double.parseDouble(
                        scanner.nextLine().trim()
                    );
                } catch (NumberFormatException e) {
                    System.out.println(
                        "Error: Debes ingresar un precio valido."
                    );
                    return;
                }

                if (!Double.isFinite(precio) || precio < 0) {
                    System.out.println(
                        "Error: El precio debe ser un numero finito no negativo."
                    );
                    return;
                }

                FiltroPrecioMaximo filtroPrecio =
                    new FiltroPrecioMaximo(precio);

                productosFiltrados =
                    catalogo.filtrar(filtroPrecio);

                System.out.println();
                System.out.println(
                    catalogo.mostrarFiltrado(productosFiltrados)
                );
                break;

            case 0:
                System.out.println(
                    "Gracias por utilizar RockBuster."
                );
                return;

            default:
                System.out.println(
                    "Opcion no valida. Intenta nuevamente."
                );
                return;
        }

        // Seleccion de un producto para consultar detalles.

        if (productosFiltrados != null &&
            productosFiltrados.isEmpty()) {

            System.out.println(
                "No se encontraron productos con ese criterio."
            );
            return;
        }

        System.out.println();
        System.out.println(
            "Ingresa el numero del producto para ver sus detalles."
        );
        System.out.println(
            "Ingresa 0 para regresar al menu."
        );
        System.out.print("Seleccion: ");

        int seleccion;

        try {
            seleccion = Integer.parseInt(
                scanner.nextLine().trim()
            );
        } catch (NumberFormatException e) {
            System.out.println(
                "Error: Debes ingresar un numero entero."
            );
            return;
        }

        if (seleccion == 0) {
            return;
        }

        try {
            Producto producto;

            if (productosFiltrados == null) {

                // Seleccion desde el catalogo completo.

                producto = catalogo.obtenerProducto(seleccion);

            } else {

                // Seleccion desde los resultados filtrados.

                if (seleccion < 1 ||
                    seleccion > productosFiltrados.size()) {

                    throw new NoExisteProductoExcepcion(
                        "No existe un producto con ese numero."
                    );
                }

                producto = productosFiltrados.get(
                    seleccion - 1
                );
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
}
