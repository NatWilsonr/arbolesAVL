package arbolAVL;

import estructurasArbolABB.ArbolABB;
import arbolBinario.NodoABB;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Clase que representa un Arbol AVL.
 * Extiende de ArbolABB para reutilizar la estructura de un arbol de busqueda.
 * @param <T> Tipo de dato que debe ser comparable.
 */
public class ArbolAVL<T extends Comparable<T>> extends ArbolABB<T> {


    /**
     * Metodo para insertar un elemento en el arbol AVL.
     * Implementa una version iterativa similar al metodo en ArbolABB, pero
     * agregando balanceo despues de la insercion.
     * @param elemento Elemento a insertar.
     */
    public void insertar(T elemento) {
        if (raiz == null) {
            raiz = new NodoABB<>(elemento);
            return;
        }
        
        NodoABB<T> actual = raiz;
        NodoABB<T> padre = null;
        
        // Buscar la posicion donde insertar el nuevo nodo
        while (actual != null) {
            padre = actual;
            if (elemento.compareTo(actual.getElemento()) < 0) {
                actual = actual.getIzquierdo();
            } else if (elemento.compareTo(actual.getElemento()) > 0) {
                actual = actual.getDerecho();
            } else {
                return; // No se permiten duplicados
            }
        }
        
        // Crear el nuevo nodo e insertarlo en la posicion adecuada
        NodoABB<T> nuevo = new NodoABB<>(elemento);
        if (elemento.compareTo(padre.getElemento()) < 0) {
            padre.setIzquierdo(nuevo);
        } else {
            padre.setDerecho(nuevo);
        }
        
        // Aplicar balanceo desde el nodo donde se insertó
        raiz = balancear(raiz);
    }
    
    /**
     * Metodo para eliminar un elemento del arbol AVL.
     * Implementa la version iterativa basada en el metodo de ArbolABB,
     * pero con balanceo despues de la eliminacion.
     * @param elemento Elemento a eliminar.
     */
    public void eliminar(T elemento) {
        NodoABB<T> actual = busca(raiz, elemento);
        if (actual == null) return; // No se encontró el elemento

        NodoABB<T> papa = actual.getPadre();
        
        // Caso 1: Nodo hoja (sin hijos)
        if (actual.getIzquierdo() == null && actual.getDerecho() == null) {
            if (actual == raiz) {
                raiz = null;
            } else if (papa != null) {
                if (papa.getIzquierdo() == actual) {
                    papa.setIzquierdo(null);
                } else {
                    papa.setDerecho(null);
                }
            }
        } 
        // Caso 2: Nodo con un solo hijo
        else if (actual.getIzquierdo() == null || actual.getDerecho() == null) {
            NodoABB<T> hijo = (actual.getIzquierdo() != null) ? actual.getIzquierdo() : actual.getDerecho();
            
            if (actual == raiz) {
                raiz = hijo;
            } else if (papa != null) {
                if (papa.getIzquierdo() == actual) {
                    papa.setIzquierdo(hijo);
                } else {
                    papa.setDerecho(hijo);
                }
            }
            hijo.setPadre(papa);
        } 
        // Caso 3: Nodo con dos hijos
        else {
            NodoABB<T> sucesor = actual.getDerecho();
            NodoABB<T> sucesorPapa = actual;
            while (sucesor.getIzquierdo() != null) {
                sucesorPapa = sucesor;
                sucesor = sucesor.getIzquierdo();
            }
            
            actual.setElemento(sucesor.getElemento());
            
            if (sucesorPapa.getIzquierdo() == sucesor) {
                sucesorPapa.setIzquierdo(sucesor.getDerecho());
            } else {
                sucesorPapa.setDerecho(sucesor.getDerecho());
            }
            
            if (sucesor.getDerecho() != null) {
                sucesor.getDerecho().setPadre(sucesorPapa);
            }
        }
        
        // Aplicar balanceo despues de la eliminacion
        raiz = balancear(raiz);
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
    
            public void imprimirPorNiveles() {
        if (raiz == null) {
            System.out.println("El arbol esta vacio.");
            return;
        }

        Queue<NodoABB<T>> cola = new LinkedList<>();
        cola.add(raiz);

        while (!cola.isEmpty()) {
            NodoABB<T> actual = cola.poll(); // Sacamos el nodo de la cola
            int balance = calcularBalance(actual); // Calculamos el factor de equilibrio

            // Imprimimos el elemento y su factor de equilibrio
            System.out.println("Nodo: " + actual.getElemento() + " | Factor de equilibrio: " + balance);

            // Agregamos los hijos a la cola si existen
            if (actual.getIzquierdo() != null) {
                cola.add(actual.getIzquierdo());
            }
            if (actual.getDerecho() != null) {
                cola.add(actual.getDerecho());
            }
        }
    }
}

