package ListasEstructuradeDatos.VList;

public class Nodo<T> {
    private T[] elementos; // Array para guardar los datos de forma contigua
    private int elementosUsados;
    private Nodo<T> siguiente;

    @SuppressWarnings("unchecked")
    public Nodo(int capacidad) {
        this.elementos = (T[]) new Object[capacidad];//el object es como una variable universal que prepara para guardar cualquier clase d elemento, y la T[] es para q se traten los arrays como T creandolos en esa capacidad
        this.elementosUsados = 0;
        this.siguiente = null;
    }

    public T[] getElementos() { return elementos; }

    public int getElementosUsados() { return elementosUsados; }

    public void setElementosUsados(int cant) { this.elementosUsados = cant; }

    public Nodo<T> getSiguiente() { return siguiente; }

    public void setSiguiente(Nodo<T> sig) { this.siguiente = sig; }
}
