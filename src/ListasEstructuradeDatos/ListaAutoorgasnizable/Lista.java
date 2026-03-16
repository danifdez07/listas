package ListasEstructuradeDatos.ListaAutoorgasnizable;

public class Lista<T> {
    private Nodo<T> cabeza;
    private int tamano;
    public  Lista(){
        this.cabeza = null;
    }
    public void insertar (T elemento){
        this.cabeza = new Nodo<>(elemento, this.cabeza);

    }
    public boolean buscar(T elemento){
        if(this.cabeza== null){
            return false;
        }
        if(this.cabeza.getDato().equals(elemento)){
          return true;
        }
        Nodo<T> anterior = this.cabeza;
        Nodo<T> nuevo = this.cabeza.getSiguiente();
        while(nuevo != null){ // aqui basicamente ponemos q el siguiente elemento de anterior pase a ser el siguiente q iba a tener nuevo para q no se corte
            if(nuevo.getDato().equals(elemento)){// hacemos q el siguiente elemento de la lista de nuevo sea la cabeza de la lista para no perderla
                anterior.setSiguiente(nuevo.getSiguiente());// y le damos a la cabeza de la lista, es decir al primer elemento, el valor de nuevo
                nuevo.setSiguiente(this.cabeza);
                this.cabeza = nuevo;
                return true;
            }
            anterior = nuevo;
            nuevo=nuevo.getSiguiente();
        }
        return false;

    }
    public void imprimirLista() {
        Nodo<T> nuevo = this.cabeza;
        while (nuevo != null) {
            System.out.print(nuevo.getDato() + " -> ");
            nuevo = nuevo.getSiguiente();
        }
        System.out.println("null");
    }
    public boolean eliminar(T elemento) {
        if (this.cabeza == null) {
            return false;
        }

        if (this.cabeza.getDato().equals(elemento)) {
            this.cabeza = this.cabeza.getSiguiente();
            this.tamano--;
            return true;
        }

        Nodo<T> anterior = this.cabeza;
        Nodo<T> nuevo = this.cabeza.getSiguiente();

        while (nuevo != null) {
            if (nuevo.getDato().equals(elemento)) {
                anterior.setSiguiente(nuevo.getSiguiente());
                this.tamano--;
                return true;
            }
            anterior = nuevo;
            nuevo = nuevo.getSiguiente();
        }
        return false;
    }
    public boolean buscarTransposicion(T elemento) {
        if (this.cabeza == null) {
            return false;
        }

        if (this.cabeza.getDato().equals(elemento)) {
            return true;
        }

        Nodo<T> anterior = this.cabeza;
        Nodo<T> nuevo = this.cabeza.getSiguiente();
        Nodo<T> previo = null;

        while (nuevo != null) {// hace q la cosa acabe el previo apuntando al nuevo el nuevo a anterior y anterior al siguiente elemento, sirve asi para intercambiar elementos dentro de la lista
            if (nuevo.getDato().equals(elemento)) {
                if (previo == null) {
                    anterior.setSiguiente(nuevo.getSiguiente());
                    nuevo.setSiguiente(anterior);
                    this.cabeza = nuevo;
                } else {
                    previo.setSiguiente(nuevo);
                    anterior.setSiguiente(nuevo.getSiguiente());
                    nuevo.setSiguiente(anterior);
                }
                return true;
            }
            previo = anterior;
            anterior = nuevo;
            nuevo = nuevo.getSiguiente();
        }
        return false;
    }
}
