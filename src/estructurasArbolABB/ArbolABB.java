package estructurasArbolABB;

import arbolBinario.NodoABB;

/**
 * Clase que representa un Arbol Binario de Busqueda.
 * @param <T> Tipo de dato que debe ser comparable.
 */
public class ArbolABB<T extends Comparable<T>> {
    protected NodoABB<T> raiz;
    private int cont;

    /**
     * Constructor que inicializa un arbol vacio.
     */
    public ArbolABB() {
        this.raiz = null;
        this.cont = 0;
    }

    /**
     * Constructor que inicializa un arbol con una raiz dada.
     */
    public ArbolABB(NodoABB<T> raiz) {
        this.raiz = raiz;
        this.cont = 1;
    }

    /**
     * Metodo para agregar un nuevo elemento al arbol.
     * @param elemento Elemento a agregar.
     * @return true si se agrega correctamente, false si el elemento ya existe.
     */
    public boolean agregar(T elemento) {
        NodoABB<T> actual = raiz;
        NodoABB<T> antes;
        
        if (raiz == null) {
            raiz = new NodoABB<>(elemento);
            cont++;
            return true;
        }
        
        antes = actual;
        while (actual != null) {
            antes = actual;
            if (elemento.compareTo(actual.getElemento()) <= 0) {
                actual = actual.getIzquierdo();
            } else {
                actual = actual.getDerecho();
            }
        }
        
        NodoABB<T> nuevo = new NodoABB<>(elemento);
        if (elemento.compareTo(antes.getElemento()) <= 0) {
            antes.setIzquierdo(nuevo);
        } else {
            antes.setDerecho(nuevo);
        }
        
        cont++;
        return true;
    }
    
    /**
     * Metodo para eliminar un elemento del arbol.
     * @param elemento Elemento a eliminar.
     */
    public void borra(T elemento) {
        // Buscar el nodo a eliminar
        NodoABB<T> actual = busca(raiz, elemento);
        if (actual == null) return; // No se encontró el elemento

        System.out.println("Eliminando: " + actual.getElemento());
        NodoABB<T> papa = actual.getPadre();
        
        // Caso 1: Nodo hoja (sin hijos)
        if (actual.getIzquierdo() == null && actual.getDerecho() == null) {
            if (actual == raiz) {
                raiz = null; // Si es la raíz, el árbol queda vacío
            } else if (papa != null) {
                if (papa.getIzquierdo() == actual) {
                    papa.setIzquierdo(null);
                } else {
                    papa.setDerecho(null);
                }
            }
            cont--;
            //System.out.println("Nodo eliminado: " + elemento + " (hoja)");
            return;
        }

        // Caso 2: Nodo con un solo hijo
        if (actual.getIzquierdo() == null || actual.getDerecho() == null) {
            NodoABB<T> hijo = (actual.getIzquierdo() != null) ? actual.getIzquierdo() : actual.getDerecho();

            if (actual == raiz) {
                raiz = hijo; // El hijo toma el lugar de la raíz
            } else if (papa != null) {
                if (papa.getIzquierdo() == actual) {
                    papa.setIzquierdo(hijo);
                } else {
                    papa.setDerecho(hijo);
                }
            }
            hijo.setPadre(papa);
            cont--;
            //System.out.println("Nodo eliminado: " + elemento + " (1 hijo), reemplazado por: " + hijo.getElemento());
            return;
        }

        // Caso 3: Nodo con dos hijos
        NodoABB<T> sucesor = actual.getDerecho();
        NodoABB<T> sucesorPapa = actual;
        while (sucesor.getIzquierdo() != null) {
            sucesorPapa = sucesor;
            sucesor = sucesor.getIzquierdo();
        }

        //System.out.println("Nodo eliminado: " + elemento + " (2 hijos), reemplazado por: " + sucesor.getElemento());

        actual.setElemento(sucesor.getElemento());

        // Enlace del sucesor con su hijo derecho
        if (sucesorPapa.getIzquierdo() == sucesor) {
            sucesorPapa.setIzquierdo(sucesor.getDerecho());
        } else {
            sucesorPapa.setDerecho(sucesor.getDerecho());
        }
        
        if (sucesor.getDerecho() != null) {
            sucesor.getDerecho().setPadre(sucesorPapa);
        }
        
        cont--;
    }


    /**
     * Metodo para buscar un elemento en el arbol.
     * @param elemento Elemento a buscar.
     * @return NodoABB si el elemento existe, null si no.
     */
    public NodoABB<T> busca(NodoABB<T> actual, T elemento) {
        if (actual == null || actual.getElemento().equals(elemento)) {
            return actual;
        }
        if (elemento.compareTo(actual.getElemento()) <= 0) {
            return busca(actual.getIzquierdo(), elemento);
        }
        return busca(actual.getDerecho(), elemento);
    }

    /**
     * Metodo para calcular la altura del arbol.
     * @return Altura del arbol.
     */
    public int calcularAltura() {
        return calcularAlturaRec(raiz);
    }

    private int calcularAlturaRec(NodoABB<T> actual) {
        if (actual == null) {
            return 0;
        }
        int alturaIzq = calcularAlturaRec(actual.getIzquierdo());
        int alturaDer = calcularAlturaRec(actual.getDerecho());
        return Math.max(alturaIzq, alturaDer) + 1;
    }

    /**
     * Metodo para obtener el tamano del arbol.
     * @return Numero de elementos en el arbol.
     */
    public int getTamano() {
        return cont;
    }
}
