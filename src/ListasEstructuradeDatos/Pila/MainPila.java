package ListasEstructuradeDatos.Pila; // Asegúrate de que coincida con tu carpeta

public class MainPila {
    public static void main(String[] args) {
        PilaLista<String> torreDePlatos = new PilaLista<>();

        System.out.println("--- Apilando platos ---");
        torreDePlatos.apilar("Plato Blanco (Fondo)");
        torreDePlatos.apilar("Plato Azul (Medio)");
        torreDePlatos.apilar("Plato Rojo (Cima)");

        System.out.println("Estado de la pila (el Rojo debería estar arriba):");
        torreDePlatos.imprimir();

        System.out.println("\n--- Quitamos el plato de arriba (Desapilar) ---");
        torreDePlatos.desapilar(); // Adiós al Rojo

        System.out.println("Estado de la pila ahora:");
        torreDePlatos.imprimir();

        System.out.println("\n--- Ponemos un plato nuevo arriba ---");
        torreDePlatos.apilar("Plato Dorado (Nuevo)");
        torreDePlatos.imprimir();
    }
}
