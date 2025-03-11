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

        // Insertar elementos y verificar el balanceo
        System.out.println("Insertando elementos...");
        int[] elementos = {30, 20, 40, 10, 25, 35, 50, 5, 15, 27};
        for (int elem : elementos) {
            arbol.insertar(elem);
            System.out.println("Insertado: " + elem);
        }

        // Imprimir el arbol por niveles con los factores de equilibrio
        System.out.println("\nImprimiendo arbol AVL por niveles:");
        arbol.imprimirPorNiveles();

        // Buscar elementos
        System.out.println("\nBuscando elementos...");
        int[] busquedas = {10, 25, 50, 100};
        for (int elem : busquedas) {
            System.out.println("Elemento " + elem + " encontrado: " + arbol.buscar(elem));
        }

        // Eliminar elementos y verificar el balanceo
        System.out.println("\nEliminando elementos...");
        int[] eliminaciones = {10, 20, 30};
        for (int elem : eliminaciones) {
            arbol.eliminar(elem);
            System.out.println("Eliminado: " + elem);
        }

        // Imprimir el arbol nuevamente despues de eliminaciones
        System.out.println("\nImprimiendo arbol AVL despues de eliminaciones:");
        arbol.imprimirPorNiveles();

        // Buscar elementos despues de eliminaciones
        System.out.println("\nBuscando despues de eliminaciones...");
        for (int elem : busquedas) {
            System.out.println("Elemento " + elem + " encontrado: " + arbol.buscar(elem));
        }
        
        System.out.println("\nPruebas completadas.");
    }
    
}
