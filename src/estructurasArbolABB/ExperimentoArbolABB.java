package estructurasArbolABB;

import estructurasArbolABB.ArbolABB;
import java.util.Random;
/**
 * Clase que realiza un experimento para determinar la altura promedio
 * de un Arbol Binario de Busqueda con secuencias de numeros aleatorios.
 */
public class ExperimentoArbolABB {
    private static final int REPETICIONES = 30;
    private static final int[] TAMANOS = {10, 50, 100, 500, 1000, 1250, 1500};

    public static void main(String[] args) {
        Random azar = new Random();
        
        System.out.println("Ejecutando experimento...");
        for (int tamano : TAMANOS) {
            int minAltura = Integer.MAX_VALUE;
            int maxAltura = Integer.MIN_VALUE;
            int sumaAlturas = 0;
            
            for (int i = 0; i < REPETICIONES; i++) {
                ArbolABB<Integer> arbol = new ArbolABB<>();
                
                for (int j = 0; j < tamano; j++) {
                    arbol.agregar(azar.nextInt(10000));
                }
                
                int altura = arbol.calcularAltura();
                sumaAlturas += altura;
                
                if (altura < minAltura) minAltura = altura;
                if (altura > maxAltura) maxAltura = altura;
            }
            
            double promedio;
            
            promedio = sumaAlturas / (double) REPETICIONES;
            System.out.println("Para N = " + tamano + ":");
            System.out.println(" - Altura minima de un arbol: " + minAltura);
            System.out.println(" - Altura maxima de un arbol: " + maxAltura);
            System.out.println(" - Altura promedio de un arbol: " + promedio);
            System.out.println();
        }
    }
}
