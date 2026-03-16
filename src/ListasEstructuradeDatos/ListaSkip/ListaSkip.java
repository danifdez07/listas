package ListasEstructuradeDatos.ListaSkip;

import java.util.Random;

public class ListaSkip<T extends Comparable<T>> { // hace q los datos metidos se puedan comparar
    private static final int MAX_NIVEL = 16;
    private NodoSkip<T> cabeza;
    private int nivelActual;
    private Random random;

    public ListaSkip() {
        this.cabeza = new NodoSkip<>(null, MAX_NIVEL);
        this.nivelActual = 0;
        this.random = new Random();
    }

    private int lanzarMoneda() {
        int nivel = 0;
        while (nivel < MAX_NIVEL && random.nextBoolean()) {// iguala el nivel al maximo
            nivel++;
        }
        return nivel;
    }

    public void insertar(T elemento) {
        @SuppressWarnings("unchecked")
        NodoSkip<T>[] actualizacion = new NodoSkip[MAX_NIVEL + 1];
        NodoSkip<T> actual = this.cabeza;

        for (int i = nivelActual; i >= 0; i--) {
            while (actual.getSiguiente(i) != null && actual.getSiguiente(i).getDato().compareTo(elemento) < 0) {// hacemos un bucle q se mantenga siempre y cuando el siguiente i veces del actual no sea nulo y menor al elemento
                actual = actual.getSiguiente(i);
            }
            actualizacion[i] = actual;
        }

        int nuevoNivel = lanzarMoneda();
        if (nuevoNivel > nivelActual) { // si el nivel obtenido al lanzar la moneda es mayor al actual se mete al for y pasamos el i numero de la lisata a la cabeza
            for (int i = nivelActual + 1; i <= nuevoNivel; i++) {
                actualizacion[i] = cabeza;
            }
            nivelActual = nuevoNivel;
        }

        NodoSkip<T> nuevoNodo = new NodoSkip<>(elemento, nuevoNivel);
        for (int i = 0; i <= nuevoNivel; i++) {//subimos el numero de i para q sea mayor al nivelactual y se pueda meter al if
            nuevoNodo.setSiguiente(i, actualizacion[i].getSiguiente(i));
            actualizacion[i].setSiguiente(i, nuevoNodo);
        }
    }

    public boolean buscar(T elemento) {
        NodoSkip<T> actual = this.cabeza;
        for (int i = nivelActual; i >= 0; i--) {
            while (actual.getSiguiente(i) != null && actual.getSiguiente(i).getDato().compareTo(elemento) < 0) {
                actual = actual.getSiguiente(i);
            }
        }
        actual = actual.getSiguiente(0);
        return actual != null && actual.getDato().equals(elemento);// una vez se sale del while y del for nos da un elemento actual distinto a lp nulo y al elemento
    }

    public boolean eliminar(T elemento) {
        @SuppressWarnings("unchecked")
        NodoSkip<T>[] actualizacion = new NodoSkip[MAX_NIVEL + 1];//array para saber por dnd vamos
        NodoSkip<T> actual = this.cabeza;

        for (int i = nivelActual; i >= 0; i--) {//como empezamos desde arriba vamos bajando mientras q el siguiente numero sea distinto a null y menor al q buscamos
            while (actual.getSiguiente(i) != null && actual.getSiguiente(i).getDato().compareTo(elemento) < 0) {
                actual = actual.getSiguiente(i);
            }
            actualizacion[i] = actual;
        }

        actual = actual.getSiguiente(0);

        if (actual != null && actual.getDato().equals(elemento)) {// esto es para cuando encontramos al elemento
            for (int i = 0; i <= nivelActual; i++) {//subimos desde abajo de la lista
                if (actualizacion[i].getSiguiente(i) != actual) break;
                actualizacion[i].setSiguiente(i, actual.getSiguiente(i));//hacemos q el array apunte al siguiente elemento al del elemento q buscamos
            }
            while (nivelActual > 0 && cabeza.getSiguiente(nivelActual) == null) {
                nivelActual--;// con esto unimos lo de arriba para que no se elimine todo
            }
            return true;
        }
        return false;
    }

    public void imprimir() {
        for (int i = nivelActual; i >= 0; i--) {
            NodoSkip<T> actual = cabeza.getSiguiente(i);
            System.out.print("Nivel " + i + ": ");
            while (actual != null) {
                System.out.print(actual.getDato() + " -> ");
                actual = actual.getSiguiente(i);
            }
            System.out.println("null");
        }
    }
}