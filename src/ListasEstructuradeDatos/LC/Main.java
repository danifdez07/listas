package ListasEstructuradeDatos.LC;

public class Main {
    public static void main(String[] args) {

        Lista<Integer> miListaCircular = new Lista<>();


        System.out.println("--- Construyendo el tren por el final ---");
        miListaCircular.insertarFinal(10);
        miListaCircular.insertarFinal(20);
        miListaCircular.insertarFinal(30);


        System.out.println("--- Añadiendo la locomotora por el principio ---");
        miListaCircular.insertarPrincipio(5);


        System.out.println("\nRecorriendo hacia ADELANTE (Esperado: 5, 10, 20, 30):");
        miListaCircular.imprimirAdelante();


        System.out.println("\nRecorriendo hacia ATRÁS (Esperado: 30, 20, 10, 5):");
        miListaCircular.imprimirAtras();
    }
}
