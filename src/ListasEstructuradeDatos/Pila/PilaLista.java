package ListasEstructuradeDatos.Pila;

public class PilaLista<T> {
    private Nodo<T> cima;
    private int tamano;
    public void apilar(T dato){
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        nuevoNodo.setSiguiente(cima);
        cima = nuevoNodo;
        tamano++;

    }
    public void desapilar(){
        if(cima != null){
            cima = cima.getSiguiente();
        }
        tamano--;
    }
    public void imprimir() {
        Nodo<T> actual = cima;
        while (actual != null) {
            System.out.println("| " + actual.getDato() + " |");
            actual = actual.getSiguiente();
        }
        System.out.println("-----");
    }
}
