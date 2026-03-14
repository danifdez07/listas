package ListasEstructuradeDatos.LDE;

public class Main {
    public static void main(String[] args) {
        // 1. Creamos la lista de números
        Lista<Integer> miLista = new Lista<>();

        // 2. Insertamos datos para probar
        System.out.println("--- Insertando 10, 20, 30, 40 ---");
        miLista.insertarFinal(10);
        miLista.insertarFinal(20);
        miLista.insertarFinal(30);
        miLista.insertarFinal(40);

        System.out.println("Lista leída hacia adelante:");
        miLista.imprimirAdelante(); // Debería salir 10, 20, 30, 40

        // 3. Probamos la búsqueda
        System.out.println("\n¿Está el 30 en la lista?: " + miLista.buscar(30));

        // 4. Probamos la "Cirugía" (eliminar el 20)
        System.out.println("\nEliminando el 20 (elemento intermedio)...");
        miLista.eliminar(20);
        miLista.imprimirAdelante(); // Debería salir 10, 30, 40

        // 5. Probamos eliminar los extremos
        System.out.println("\nEliminando el primero (10) y el último (40)...");
        miLista.eliminarPrimero();
        miLista.eliminarUltimo();
        miLista.imprimirAdelante(); // Debería quedar solo el 30

        // 6. Comprobamos lectura hacia atrás (para ver si los cables anterior están bien)
        System.out.println("\nComprobando cables 'anterior' (hacia atrás):");
        miLista.imprimirAtras(); // Debería salir 30

        System.out.println("\nLongitud final: " + miLista.longitud());
    }
}