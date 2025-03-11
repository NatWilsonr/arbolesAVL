package estructurasArbolABB;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Nat :)
 */
public class EliminarExcel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArbolABB<Integer> arbol = new ArbolABB<>();
        int n = 500; // Tamaho del arbol inicial
        ArrayList<Integer> elementos = new ArrayList<>();
        Random rand = new Random();

        // 1. Insertamos elementos en orden creciente para que el arbol sea sesgado
        for (int i = 1; i <= n; i++) {
            arbol.agregar(i);
            elementos.add(i);
        }
        
        System.out.println("Altura inicial (sesgado): " + arbol.calcularAltura());

        // 2. Realizar múltiples operaciones de borrar-insertar aleatorias
        int iteraciones = 150;
        ArrayList<Integer> alturas = new ArrayList<>();

        for (int i = 0; i < iteraciones; i++) {
            // Elegimos un elemento aleatorio para borrar
            int indiceBorrar = rand.nextInt(elementos.size());
            int elementoBorrar = elementos.get(indiceBorrar);
            arbol.borra(elementoBorrar);
            elementos.remove(indiceBorrar);

            // Insertamos un número aleatorio entre 1 y 2*n
            //int nuevoElemento = rand.nextInt(2 * n) + 1;
            arbol.agregar(elementoBorrar);
            elementos.add(elementoBorrar);

            // Medimos la nueva altura
            alturas.add(arbol.calcularAltura());
        }

        // 3. Guardar resultados en un archivo CSV
        try (FileWriter writer = new FileWriter("altura_arbol.csv")) {
            writer.write("iteracion,altura\n"); // Encabezado
            for (int i = 0; i < alturas.size(); i++) {
                writer.write(i + "," + alturas.get(i) + "\n");
            }
            System.out.println("Datos guardados en altura_arbol.csv");
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo CSV: " + e.getMessage());
        }
    }
    
}
