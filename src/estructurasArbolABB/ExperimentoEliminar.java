package estructurasArbolABB;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
/**
 *
 * @author Nat :)
 */
public class ExperimentoEliminar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArbolABB<Integer> arbol = new ArbolABB<>();
        int n = 1000; // Tamano inicial del arbol
        ArrayList<Integer> elementos = new ArrayList<>();
        Random rand = new Random();

        // 1. Insertamos elementos en orden creciente para que el arbol sea sesgado
        for (int i = 1; i <= n; i++) {
            arbol.agregar(i);
            elementos.add(i);
        }
        
        // Mostramos la info. inicial del arbol
        System.out.println("Altura inicial (sesgado): " + arbol.calcularAltura());

        // 2. Realizamos multiples operaciones de borrar-insertar aleatorias
        int iteraciones = 100000; // Cuantas veces lo vamos a hacer
        ArrayList<Integer> alturas = new ArrayList<>();
        
        for (int i = 0; i < iteraciones; i++) {
            // Elegimos un elemento aleatorio para borrar
            //int indiceBorrar = rand.nextInt(elementos.size());
            int indiceBorrar = (int) (Math.random()*elementos.size());
            int elementoBorrar = elementos.get(indiceBorrar);
            arbol.borra(elementoBorrar);
            //elementos.remove(indiceBorrar);

            // Insertamos de regreso
            arbol.agregar(elementoBorrar);
            //elementos.add(elementoBorrar);

            // Medimos la nueva altura y la guardamos en la lista
            int alturaActual = arbol.calcularAltura();
            alturas.add(alturaActual);
            
            // Imprimir cada altura en su propia linea
            System.out.println("Iteracion " + (i + 1) + ": Altura del arbol = " + alturaActual);
        }   
    }
}
