/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol;

/**
 *
 * @author Admin
 */
public class Arbol {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArbolBinario aBinario = new ArbolBinario();
        
        //int numeros[] = {1,2,3,4,8,90,10,51,20,45,10,30,150};
        
        
        int numeros[] = {16,69,72,33,57,36,18,47,11,23};
        
        for (int i = 0; i < numeros.length; i++) {
           aBinario.insertar(numeros[i]);
        }
        
          
        aBinario.imprimirArbolBinario(aBinario.getRaiz(), 0);
        
        aBinario.inOrden();
        System.out.println("************************ ");
        aBinario.posOrden();
        System.out.println("************************ ");
        aBinario.preOrden();
        
        System.out.println("************************ ");
        System.out.println("aBinario.getPeso() = " + aBinario.getPeso());
        System.out.println(" " + aBinario.getHojas());
        
        /**
         * Nodos Hojas
         * Nodos Internos
         * Peso
         * Suma 
         * Eliminar
         * Si existe
         * 
         * Clase principal con elementos a modo random
         */
        
    }
    
}
