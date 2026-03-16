package ListasEstructuradeDatos.ListaAutoorgasnizable;

public class Nodo<T> {
    private T dato;
    private Nodo<T> siguiente;
    private int tamaño = 0;
    public Nodo(T dato, Nodo<T> siguiente) {
        this.siguiente = siguiente;
        this.dato = dato;
    }
    public int getTamaño() {
        return tamaño;
    }
    public T getDato() { return dato; }
    public void setDato(T dato) { this.dato = dato; }
    public Nodo<T> getSiguiente() { return siguiente; }
    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }
}