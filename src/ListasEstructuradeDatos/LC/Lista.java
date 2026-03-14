package ListasEstructuradeDatos.LC;

public class Lista<T> {
    private Nodo<T> cabeza;
    private Nodo<T> cola;
    private int tamano;
    public  Lista(){
        this.tamano=0;

    }
    public void insertarPrincipio(T dato){
        Nodo<T> NuevoNodo = new Nodo<>(dato);
        if(cabeza==null){
            cabeza =  NuevoNodo;
            cola =  NuevoNodo;
            NuevoNodo.setSiguiente(cabeza);
            NuevoNodo.setAnterior(cola);
        }
        else{
            NuevoNodo.setSiguiente(cabeza);
            NuevoNodo.setAnterior(cola);
            cabeza.setAnterior(NuevoNodo);
            cola.setSiguiente(NuevoNodo);
            cabeza = NuevoNodo;

        }
        tamano++;
    }
    public void insertarFinal(T dato){
        Nodo<T> NuevoNodo = new Nodo<>(dato);
        if(cabeza==null){
            cabeza =  NuevoNodo;
            cola =  NuevoNodo;
            NuevoNodo.setSiguiente(cabeza);
            NuevoNodo.setAnterior(cola);
        }
        else{
            NuevoNodo.setSiguiente(cabeza);
            NuevoNodo.setAnterior(cola);
            cabeza.setAnterior(NuevoNodo);
            cola.setSiguiente(NuevoNodo);
            cola = NuevoNodo;

        }
        tamano ++;
    }
    public void imprimirAdelante(){
        if(cabeza==null){
            return;
        }
        Nodo<T> actual = cabeza;
        do{
            System.out.println(actual.getDato());
            actual = actual.getSiguiente();
        } while (actual != cabeza);

    }
    public void imprimirAtras(){
        if(cola==null){
            return;
        }
        Nodo<T> actual = cola;
        do{
            System.out.println(actual.getDato());
            actual = actual.getAnterior();
        } while (actual != cola);

    }

}


