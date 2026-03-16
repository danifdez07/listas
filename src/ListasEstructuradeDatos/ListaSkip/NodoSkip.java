package ListasEstructuradeDatos.ListaSkip;

public class NodoSkip<T extends Comparable<T>> {
    private T dato;
    private NodoSkip<T>[] siguiente; // al crear un arrays de siguiente nos permite saltar el numero de arrays q haya

    @SuppressWarnings("unchecked")
    public NodoSkip(T dato, int nivel) {
        this.dato = dato;
        this.siguiente = new NodoSkip[nivel + 1];
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public NodoSkip<T> getSiguiente(int nivel) {
        return this.siguiente[nivel];
    }

    public void setSiguiente(int nivel, NodoSkip<T> nodo) {
        this.siguiente[nivel] = nodo;
    }
}