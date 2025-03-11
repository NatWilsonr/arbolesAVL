package arbolBinario;

/**
 * Clase que representa un nodo en un arbol Binario de Busqueda.
 * @param <T> Tipo de dato que debe ser comparable.
 */
public class NodoABB<T extends Comparable<T>> {
    private T elemento;
    private NodoABB<T> izquierdo;
    private NodoABB<T> derecho;
    private NodoABB<T> padre;

    /**
     * Constructor vacio.
     */
    public NodoABB() {
        this.elemento = null;
        this.izquierdo = null;
        this.derecho = null;
        this.padre = null;
    }

    /**
     * Constructor para crear un nodo con un elemento dado.
     * @param elemento Elemento que almacena el nodo.
     */
    public NodoABB(T elemento) {
        this.elemento = elemento;
        this.izquierdo = null;
        this.derecho = null;
        this.padre = null;
    }

    // Getters y Setters
    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public NodoABB<T> getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodoABB<T> izquierdo) {
        this.izquierdo = izquierdo;
    }

    public NodoABB<T> getDerecho() {
        return derecho;
    }

    public void setDerecho(NodoABB<T> derecho) {
        this.derecho = derecho;
    }

    public NodoABB<T> getPadre() {
        return padre;
    }

    public void setPadre(NodoABB<T> padre) {
        this.padre = padre;
    }
}
