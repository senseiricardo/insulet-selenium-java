package javaexercises;

import java.util.ArrayList;
import java.util.List;

public class Polimorfismo {
    public static void main(String[] args){
        List<Figura> figuras = new ArrayList<>();
        figuras.add(new Circulo(10));
        figuras.add(new Cuadrado(10));

        for(Figura f : figuras){
            f.dibujar();
            System.out.println(" El Area es :" + f.calcularArea());
        }
    }
}
