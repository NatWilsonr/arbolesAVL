package arbolDobleEnlazado;
/*
import arbolDobleEnlazado.NodoListaDoble;
import java.util.Iterator;
/**
 * Clase que representa una lista doblemente enlazada.
 * @param <T> Tipo de dato almacenado en la lista.
 
public class ListaDobleEnlazada<T> implements ListaADT<T> {
    protected NodoListaDoble<T> primero;
    protected NodoListaDoble<T> ultimo;

    public ListaA() {
        primero = null;
        ultimo = null;
    }
    
    public Iterator<T> iterator(){
        return new Iterador(primero);
    }
    
    public boolean estaVacia(){
        return primero == null;
    }
    
    public String toString(){
        return toString(new StringBuilder(), primero);
    }
    
    private String toString (StringBuilder sB, NodoListaDoble <T> actual){
        if (actual == null)
            return sB.toString();
        else{
            sB.append(actual.getDato()).append(" ");
            actual = actual.getSig();
            return toString (sB, actual);
        }
    }
    
    public T quitaPrimero(){
        if (this.estaVacia())
            throw new RuntimeException ("lista vacía");
        T eliminado = primero.getDato();
        NodoListaDoble <T> aux = primero;
        if (primero == ultimo)
            ultimo = null;
        else
            primero.getSig().setAnt(null);
        primero = primero.getSig();
        aux.setSig(null);
        return eliminado;       
    }
    
    public T quitaUltimo(){
        if (this.estaVacia())
            throw new RuntimeException ("lista vacía");
        T eliminado = ultimo.getDato();
        NodoListaDoble <T> aux = ultimo;
        if (primero == ultimo){
            ultimo=null;
        }
        else{
            ultimo.setSig(null);
        }
        ultimo = ultimo.getAnt();
        aux.setAnt(null);
        return eliminado;
    }
    
    public T quita(T dato){
         if (this.estaVacia())
            throw new RuntimeException ("lista vacía");
         T eliminado = null;
         NodoListaDoble <T> aux = primero;
         while (!aux.getDato().equals(dato) || aux.getSig() != null){
             aux = aux.getSig();
         }
         if (aux.getDato().equals(dato)){
             eliminado = aux.getDato();
             aux.getAnt().setSig(aux.getSig());
             aux.getSig().setAnt(aux.getAnt());
             aux.setAnt(null);
             aux.setSig(null);
         }
         else
             throw new RuntimeException ("Dato no encontrado");
         
         return eliminado;
    }
    
    public boolean contiene (T dato){
        boolean res = false;
        if (this.estaVacia())
            throw new RuntimeException ("lista vacía");
         NodoListaDoble <T> aux = primero;
         while (!aux.getDato().equals(dato) || aux.getSig() != null){
             aux = aux.getSig();
         }
         if (aux.getDato().equals(dato)){
             res= true;
         }  
        return true;
    }
}
*/
