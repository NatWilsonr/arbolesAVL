/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbolDobleEnlazado;

/**
 * Clase que representa un nodo en una lista doblemente enlazada.
 * @param <T> Tipo de dato almacenado en el nodo.
 */
public class NodoListaDoble<T> {

    private T elemento;
    private NodoListaDoble<T> anterior;
    private NodoListaDoble<T> siguiente;

    /**
     * Constructor para crear un nodo con un elemento dado.
     * @param elemento Elemento que almacena el nodo.
     */
    public NodoListaDoble(T elemento) {
        this.elemento = elemento;
        this.anterior = null;
        this.siguiente = null;
    }

    // Getters y Setters
    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public NodoListaDoble<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoListaDoble<T> anterior) {
        this.anterior = anterior;
    }

    public NodoListaDoble<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoListaDoble<T> siguiente) {
        this.siguiente = siguiente;
    }
}
