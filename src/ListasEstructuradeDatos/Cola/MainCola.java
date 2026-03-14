package ListasEstructuradeDatos.Cola;

public class MainCola {
    public static void main(String[] args) {
        Cola<String> filaSuper = new Cola<String>();

        System.out.println("--- Llegando a la caja ---");
        filaSuper.encolar("Cliente 1 (Lleva manzanas)");
        filaSuper.encolar("Cliente 2 (Lleva pan)");
        filaSuper.encolar("Cliente 3 (Lleva leche)");

        System.out.println("Estado de la fila:");
        filaSuper.imprimir();

        System.out.println("\n--- El cajero atiende al primero ---");
        filaSuper.desencolar(); // Se va el Cliente 1

        System.out.println("Estado de la fila tras irse el primero:");
        filaSuper.imprimir();

        System.out.println("\n--- Llega alguien nuevo ---");
        filaSuper.encolar("Cliente 4 (Lleva cereales)");

        System.out.println("Estado final de la fila:");
        filaSuper.imprimir();
    }
}