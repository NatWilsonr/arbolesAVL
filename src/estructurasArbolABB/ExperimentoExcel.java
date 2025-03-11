package estructurasArbolABB;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author Asus
 */
public class ExperimentoExcel {

    /**
     * @param args the command line arguments
     */
    private static final int REPETICIONES = 30;
    private static final int[] TAMANOS = {10, 50, 100, 500, 1000, 1250, 1500};


    public static void main(String[] args) {
        Random rand = new Random();
        String archivo = "resultados_experimento.csv";
        try (FileWriter writer = new FileWriter(archivo)) {
        writer.write("Tamaño,Iteracion,Altura\n");

        System.out.println("Ejecutando experimento...");
        for (int tamano : TAMANOS) {
            int minAltura = Integer.MAX_VALUE;
            int maxAltura = Integer.MIN_VALUE;
            int sumaAlturas = 0;

            for (int i = 1; i <= REPETICIONES; i++) {
                ArbolABB<Integer> arbol = new ArbolABB<>();

                for (int j = 0; j < tamano; j++) {
                    arbol.agregar(rand.nextInt(10000));
                }

                int altura = arbol.calcularAltura();
                sumaAlturas += altura;

                if (altura < minAltura) minAltura = altura;
                if (altura > maxAltura) maxAltura = altura;

                // Escribir en el archivo CSV
                writer.write(tamano + "," + i + "," + altura + "\n");
            }

            double promedio = sumaAlturas / (double) REPETICIONES;
            System.out.println("Para N = " + tamano + ":");
            System.out.println(" - Altura minima: " + minAltura);
            System.out.println(" - Altura maxima: " + maxAltura);
            System.out.println(" - Altura promedio: " + promedio);
            System.out.println();
        }

        System.out.println("Resultados guardados en " + archivo);
           } catch (IOException e) {
        System.err.println("Error al escribir en el archivo: " + e.getMessage());
           }
    
    }
}
