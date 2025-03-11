package arbolDobleEnlazado;

import java.util.Iterator;

/**
 *
 * @author Asus
 */
public interface ListaADT <T> extends Iterable<T>{
    public Iterator <T> iterator();
    public boolean estaVacia();
    public T quitaPrimero();
    public T quitaUltimo();
    public T quita(T dato);
    public boolean contiene (T dato);
    //puede haber mas metodos
}
