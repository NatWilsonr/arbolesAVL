/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arbolAVL;

/**
 * Clase de prueba para verificar la impresion por niveles del Arbol AVL.
 */
public class pruebaImpresionAVL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Crear un arbol AVL de enteros
        ArbolAVL<Integer> arbol = new ArbolAVL<>();

        // Insertar elementos
        System.out.println("Insertando elementos...");
        int[] elementos = {30, 20, 40, 10, 25, 35, 50, 5, 15, 27};
        for (int elem : elementos) {
            arbol.insertar(elem);
            System.out.println("Insertado: " + elem);
        }

        // Imprimir el arbol por niveles con los factores de equilibrio
        System.out.println("\nImprimiendo arbol AVL por niveles:");
        arbol.imprimirPorNiveles();
    }
    
}
