/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author Admin
 */
public class Arbol {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int NUMEROS_REQUERIDOS = 10;
        int NUMERO_MAXIMO = 10;

        Random rng = new Random();
        Set<Integer> generated = new LinkedHashSet<>();

        while (generated.size() < NUMEROS_REQUERIDOS) {
            Integer next = rng.nextInt(NUMERO_MAXIMO) + 1;
            // As we're adding to a set, this will automatically do a containment check
            generated.add(next);
        }

        ArbolBinario<Integer> aBinario = new ArbolBinario<>();

        //int numeros[] = {1,2,3,4,8,90,10,51,20,45,10,30,150};
        Object numeros[] = generated.toArray();

        for (Object numero : numeros) {
            aBinario.insertar((Integer) numero);
        }

        aBinario.imprimirArbolBinario(aBinario.getRaiz(), 0);

       aBinario.inOrden();
        System.out.println("************************ ");
       aBinario.posOrden();
        System.out.println("************************ ");
        aBinario.preOrden();        
       System.out.println("************************ ");
//        
        System.out.println("-> Peso = " + aBinario.getPeso());
        System.out.println("-> Numero de Hojas = " + aBinario.getHojas());
        System.out.println("-> Numero de Nodos Internos = " + aBinario.getNodosInternos());
        System.out.println("-> Sumatoria Elementos = " + aBinario.obtenerSumatoria());
        System.out.println("-> Elemento Existe? = " + aBinario.existe(18));
        System.out.println("-> Niveles = " + aBinario.niveles());
        System.out.println("-> Altura  = " + aBinario.altura());
        
        
        for (Integer i : aBinario){
            System.out.println("i = " + i);
        }
        
        /**
         * Nodos Hojas X Nodos Internos x Peso x Suma x Eliminar Si existe
         *
         * Clase principal con elementos a modo random
         */
    }

}
