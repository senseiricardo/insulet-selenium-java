package javaexercises;

import java.util.Arrays;
import java.util.List;

public class Loops {

    public static void main(String[] args){

        // For - Contador del 1 al 10

        for(int i = 1; i <= 100; i++){ // ? 101 es menor o igual a 100 == FALSE!!!
            System.out.println(i);
        }

        // While
        int whileCount = 1;

        while(whileCount < 5){
            System.out.println(whileCount);
            whileCount++; // en cada ciclo incrementar 1
        }

        // Do-While
        int doWhilecount = 1;
        do{
            System.out.println("Count es :" + doWhilecount); // Concatenacion
            doWhilecount++;
        } while(doWhilecount <=5);

        // FOR EACH
        List<String> frutas = Arrays.asList("Aguacate", "Mango", "Sandia", "Piña", "Limon", "Cereza");
        /*
        Manzana
        Mango
        Sandia
        Piña
         */

        for(String fruta : frutas){
            System.out.println(fruta);
        }

    }
}
