package arbolAVL;

import estructurasArbolABB.ArbolABB;
import arbolBinario.NodoABB;

/**
 * Clase que representa un Arbol AVL.
 * Extiende de ArbolABB para reutilizar la estructura de un arbol de busqueda.
 * @param <T> Tipo de dato que debe ser comparable.
 */
public class ArbolAVL<T extends Comparable<T>> extends ArbolABB<T> {

    /**
     * Metodo para insertar un elemento en el arbol AVL.
     * Realiza la insercion y luego revisa si el arbol necesita balanceo.
     * @param elemento Elemento a insertar.
     */
    public void insertar(T elemento) {
        raiz = insertarRec(raiz, elemento);
    }
    
    private NodoABB<T> insertarRec(NodoABB<T> nodo, T elemento) {
        // Insercion normal en ABB
        if (nodo == null) {
            return new NodoABB<>(elemento);
        }
        if (elemento.compareTo(nodo.getElemento()) < 0) {
            nodo.setIzquierdo(insertarRec(nodo.getIzquierdo(), elemento));
        } else if (elemento.compareTo(nodo.getElemento()) > 0) {
            nodo.setDerecho(insertarRec(nodo.getDerecho(), elemento));
        } else {
            return nodo; // No se permiten duplicados
        }
        
        // Actualizar altura y balancear
        return balancear(nodo);
    }
    
    /**
     * Metodo para eliminar un elemento del arbol AVL.
     * Se realiza la eliminacion y luego se verifica si es necesario balancear.
     * @param elemento Elemento a eliminar.
     */
    public void eliminar(T elemento) {
        raiz = eliminarRec(raiz, elemento);
    }
    
    private NodoABB<T> eliminarRec(NodoABB<T> nodo, T elemento) {
        if (nodo == null) {
            return null;
        }
        
        if (elemento.compareTo(nodo.getElemento()) < 0) {
            nodo.setIzquierdo(eliminarRec(nodo.getIzquierdo(), elemento));
        } else if (elemento.compareTo(nodo.getElemento()) > 0) {
            nodo.setDerecho(eliminarRec(nodo.getDerecho(), elemento));
        } else {
            if (nodo.getIzquierdo() == null || nodo.getDerecho() == null) {
                nodo = (nodo.getIzquierdo() != null) ? nodo.getIzquierdo() : nodo.getDerecho();
            } else {
                NodoABB<T> sucesor = encontrarMinimo(nodo.getDerecho());
                nodo.setElemento(sucesor.getElemento());
                nodo.setDerecho(eliminarRec(nodo.getDerecho(), sucesor.getElemento()));
            }
        }
        
        if (nodo == null) return null;
        
        return balancear(nodo);
    }
    
    private NodoABB<T> encontrarMinimo(NodoABB<T> nodo) {
        while (nodo.getIzquierdo() != null) {
            nodo = nodo.getIzquierdo();
        }
        return nodo;
    }
    
    /**
     * Metodo para buscar un elemento en el arbol AVL.
     * @param elemento Elemento a buscar.
     * @return true si el elemento esta en el arbol, false si no.
     */
    public boolean buscar(T elemento) {
        return busca(raiz, elemento) != null;
    }
    
    /**
     * Metodo para balancear el arbol AVL despues de una operacion.
     * @param nodo Nodo a revisar.
     * @return Nodo balanceado.
     */
    private NodoABB<T> balancear(NodoABB<T> nodo) {
        int balance = calcularBalance(nodo);
        
        // Rotacion Simple Derecha (Caso Izquierda-Izquierda)
        if (balance > 1 && calcularBalance(nodo.getIzquierdo()) >= 0) {
            return rotacionDerecha(nodo);
        }
        
        // Rotacion Simple Izquierda (Caso Derecha-Derecha)
        if (balance < -1 && calcularBalance(nodo.getDerecho()) <= 0) {
            return rotacionIzquierda(nodo);
        }
        
        // Rotacion Doble Izquierda-Derecha (Caso Izquierda-Derecha)
        if (balance > 1 && calcularBalance(nodo.getIzquierdo()) < 0) {
            nodo.setIzquierdo(rotacionIzquierda(nodo.getIzquierdo()));
            return rotacionDerecha(nodo);
        }
        
        // Rotacion Doble Derecha-Izquierda (Caso Derecha-Izquierda)
        if (balance < -1 && calcularBalance(nodo.getDerecho()) > 0) {
            nodo.setDerecho(rotacionDerecha(nodo.getDerecho()));
            return rotacionIzquierda(nodo);
        }
        
        return nodo;
    }
    
    private int calcularBalance(NodoABB<T> nodo) {
        return calcularAlturaRec(nodo.getIzquierdo()) - calcularAlturaRec(nodo.getDerecho());
    }
    
    private int calcularAlturaRec(NodoABB<T> nodo) {
        if (nodo == null) {
            return 0;
        }
        int alturaIzq = calcularAlturaRec(nodo.getIzquierdo());
        int alturaDer = calcularAlturaRec(nodo.getDerecho());
        return Math.max(alturaIzq, alturaDer) + 1;
    }
    
    private NodoABB<T> rotacionDerecha(NodoABB<T> nodo) {
        NodoABB<T> nuevaRaiz = nodo.getIzquierdo();
        nodo.setIzquierdo(nuevaRaiz.getDerecho());
        nuevaRaiz.setDerecho(nodo);
        return nuevaRaiz;
    }
    
    private NodoABB<T> rotacionIzquierda(NodoABB<T> nodo) {
        NodoABB<T> nuevaRaiz = nodo.getDerecho();
        nodo.setDerecho(nuevaRaiz.getIzquierdo());
        nuevaRaiz.setIzquierdo(nodo);
        return nuevaRaiz;
    }
}

