package vista;


import data.Vinilo;
import logica.ColeccionVinilo;

import java.util.Scanner;

public class MenuPrincipal {
    private final Scanner sc = new Scanner(System.in);
    private final ColeccionVinilo coleccion = new ColeccionVinilo();

    public MenuPrincipal() {
        menu();
    }

    public void menu() {
        int opcion;
        do {
            mostrarOpciones();
            opcion = obtenerOpcion();
            if (opcion != -1) {
                ejecutarOpcion(opcion);
            }
        } while (opcion != 5);
    }

    public void mostrarOpciones() {
        System.out.println("\n=============================");
        System.out.println("            Colección de Vinilos            ");
        System.out.println("      Opciones      ");
        System.out.println("============================= ");
        System.out.println("    [1] Agregar Vinilo     ");
        System.out.println("    [2] Buscar Vinilo     ");
        System.out.println("    [3] Cuantos Vinilos hay    ");
        System.out.println("    [4] Ver espacios libres   ");
        System.out.println("    [5] Salir       ");


        System.out.println("============================= ");
        System.out.print("      Opcion: ");
    }

    public int obtenerOpcion() {
        int opcion;
        try {
            opcion = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Ingrese un numero valido");
            return -1; // Devolver un valor inválido para que no ejecute ninguna opción
        }
        return opcion;
    }

    public void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> ManejoAgregarVinilo();
            case 2 -> ManejoBuscarVinilo();
            case 3 -> System.out.println("Cantidad de vinilos: " + coleccion.getVinilos());
            case 4 -> System.out.println("Espacios libres: " + coleccion.espaciosVacios());
            case 5 -> System.out.println("Hasta luego...");
            default -> System.out.println("Opción inválida...");
        }
    }
    public void ManejoAgregarVinilo() {
        String artista = solicitarArtista();
        String disco = solicitarDisco();
        int anoLanzamiento = solicitarAno();

        Vinilo nuevoVinilo = new Vinilo(artista, disco, anoLanzamiento);
        agregarViniloAColeccion(nuevoVinilo);
        System.out.println("Vinilo agregado exitosamente");
    }

    private String solicitarArtista() {
        System.out.print("Ingrese el nombre del artista: ");
        return sc.nextLine();
    }

    private String solicitarDisco() {
        System.out.print("Ingrese el nombre del disco: ");
        return sc.nextLine();
    }

    private int solicitarAno() {
        int anoLanzamiento = 0;
        boolean anoValido = false;

        while (!anoValido) {
            System.out.print("Ingrese el año de lanzamiento: ");
            try {
                anoLanzamiento = Integer.parseInt(sc.nextLine());
                anoValido = validarAno(anoLanzamiento);
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido");
            }
        }
        return anoLanzamiento;
    }

    private boolean validarAno(int ano) {
        if (ano > 1877 && ano <= 2025) {
            return true;
        } else {
            System.out.println("Por favor, ingrese un año válido (1877-2025)");
            return false;
        }
    }

    private void agregarViniloAColeccion(Vinilo vinilo) {
        if (coleccion.estaVinilo(vinilo)) {
            System.out.println("¡Error! Este vinilo ya existe en la colección");
        } else if (coleccion.espaciosVacios() <= 0) {
            System.out.println("¡Error! La colección está llena");
        } else {
            coleccion.addVinilo(vinilo);
        }
    }

    public void ManejoBuscarVinilo() {
        System.out.println("\n=== Buscar Vinilo ===");
        String artista = solicitarArtista();
        String disco = solicitarDisco();

        Vinilo viniloBuscado = new Vinilo(artista, disco, 0); // El año no es necesario para la búsqueda

        if (coleccion.estaVinilo(viniloBuscado)) {
            System.out.println("¡Vinilo encontrado!");
            System.out.println("El vinilo '" + disco + "' de '" + artista + "' está en la colección.");
        } else {
            System.out.println("Vinilo no encontrado.");
            System.out.println("El vinilo '" + disco + "' de '" + artista + "' no está en la colección.");
        }
    }


}