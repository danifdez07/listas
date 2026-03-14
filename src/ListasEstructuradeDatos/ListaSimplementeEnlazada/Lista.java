package ListasEstructuradeDatos.ListaSimplementeEnlazada;

public class Lista<T> implements ListaTAD<T> {
    private Nodo<T> cabeza;
    private int tamano;
    public Lista(){}
    @Override
    public boolean esVacia(){
        return false;
    }
    @Override
    public int longitud(){
        return 0;
    }
    @Override
    public void insertarFinal(T elemento){
        if(this.cabeza == null){
            this.cabeza = new Nodo<>(elemento);
            tamano++;
        }
        else{
            insertarFinalRecursividad(this.cabeza, elemento);
        }


    }
    @Override
    public boolean buscar(T elemento){
        return false;
    }
    @Override
    public int aciertos_exactos(ListaTAD<T> otraLista){
        Lista<T> otraListaReal = (Lista<T>) otraLista;
        Nodo<T> cabezaOtra = otraListaReal.cabeza;
        return aciertos_exactosRec(this.cabeza, cabezaOtra);}
        private int aciertos_exactosRec(Nodo<T> actualMia, Nodo<T> actualOtra) {
            if (actualMia == null || actualOtra == null) {
                return 0;
            }
            if (actualMia.getDato().equals(actualOtra.getDato())) {
                return 1 + aciertos_exactosRec(actualMia.getSiguiente(), actualOtra.getSiguiente());
            }
            else {
                return 0 + aciertos_exactosRec(actualMia.getSiguiente(), actualOtra.getSiguiente());
            }
        }

    private void insertarFinalRecursividad(Nodo<T> actual, T elemento){
        if(actual.getSiguiente() == null){
            actual.setSiguiente(new Nodo<>(elemento));
            tamano++;}
        else {insertarFinalRecursividad(actual.getSiguiente(), elemento);}

    }
    private boolean buscarRec(Nodo<T> actual, T elemento){
        return false;
    }
    public void eliminar(T elemento) {
        this.cabeza = eliminarRec(this.cabeza, elemento);
    }


    private Nodo<T> eliminarRec(Nodo<T> actual, T elemento) {


        if (actual == null) {
            return null; // Devolvemos la nada
        }


        if (actual.getDato().equals(elemento)) {
            tamano--; // Restamos 1 al contador de tamaño

            return actual.getSiguiente();
        }


        actual.setSiguiente(eliminarRec(actual.getSiguiente(), elemento));


        return actual;
    }

}
