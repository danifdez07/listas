package ListasEstructuradeDatos.Cola;

public class Cola<T> {
    private Nodo<T> inicio;
    private Nodo<T> fin;
    private int tamano;
    public Cola(){
        tamano =0;
    }
    public void encolar(T dato){
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        if(inicio == null){
            inicio =nuevoNodo;
            fin = nuevoNodo;
        }
        else{
            fin.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(fin);
            fin = nuevoNodo;
        }
        tamano++;

    }
    public void desencolar(){
        if(inicio == null){
            return;
        }
        else{
            inicio= inicio.getSiguiente();
            if(inicio == null){
                fin = null;
            }
            else{
                inicio.setAnterior(null);
            }
        }
        tamano--;
    }
    public void imprimir() {
        Nodo<T> actual = inicio;
        while (actual != null) {
            System.out.println(actual.getDato());
            actual = actual.getSiguiente();
        }
    }

}
