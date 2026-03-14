package ListasEstructuradeDatos.ListaSimplementeEnlazada;

public class Main {
    public static void main(String[] args) {

        ListaTAD<Integer> claveSecreta = new Lista<>();
        claveSecreta.insertarFinal(1);
        claveSecreta.insertarFinal(2);
        claveSecreta.insertarFinal(3);
        claveSecreta.insertarFinal(4);
        ListaTAD<Integer> jugada = new Lista<>();
        jugada.insertarFinal(1);
        jugada.insertarFinal(2);
        jugada.insertarFinal(3);
        jugada.insertarFinal(9);
        System.out.println("--- MASTERMIND ---");
        System.out.println("Calculando aciertos exactos...");

        int aciertos = claveSecreta.aciertos_exactos(jugada);

        System.out.println("Resultado: Tienes " + aciertos + " aciertos exactos.");
    }
}