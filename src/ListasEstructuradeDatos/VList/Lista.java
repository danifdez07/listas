package ListasEstructuradeDatos.VList;

public class Lista<T> {
    private Nodo<T> cabeza;

    public Lista() {
        // El estado inicial es un subespacio de dimensión 2^0 = 1
        this.cabeza = new Nodo<>(1);
    }

    public void insertar(T elemento) {
        // Verificamos si el vector actual ha alcanzado su capacidad máxima
        if (this.cabeza.getElementosUsados() == this.cabeza.getElementos().length) {

            // Progresión geométrica: definimos un nuevo bloque con tamaño 2^n
            // Esto garantiza que el coste de inserción amortizado sea O(1)
            Nodo<T> nuevoBloque = new Nodo<>(this.cabeza.getElementos().length * 2);

            // Reestructuramos la jerarquía de la lista (LIFO)
            nuevoBloque.setSiguiente(this.cabeza);
            this.cabeza = nuevoBloque;
        }

        // Mapeo del elemento en la siguiente posición disponible del array
        int pos = this.cabeza.getElementosUsados();
        this.cabeza.getElementos()[pos] = elemento;
        this.cabeza.setElementosUsados(pos + 1);
    }

    public boolean buscar(T elemento) {
        Nodo<T> actual = this.cabeza;

        // Recorrido por los bloques (nodos) de la estructura
        while (actual != null) {
            // Aprovechamos la localidad de referencia: leer un array es más rápido para la CPU
            for (int i = 0; i < actual.getElementosUsados(); i++) {
                if (actual.getElementos()[i].equals(elemento)) {
                    return true;
                }
            }
            // Saltamos al siguiente subconjunto si no está en el bloque actual
            actual = actual.getSiguiente();
        }
        return false;
    }

    public void imprimir() {
        Nodo<T> actual = this.cabeza;
        while (actual != null) {
            System.out.print("Bloque (Capacidad 2^n = " + actual.getElementos().length + "): [");
            for (int i = 0; i < actual.getElementosUsados(); i++) {
                System.out.print(actual.getElementos()[i] + (i < actual.getElementosUsados() - 1 ? ", " : ""));
            }
            System.out.println("] -> ");
            actual = actual.getSiguiente();
        }
        System.out.println("null");
    }
}
