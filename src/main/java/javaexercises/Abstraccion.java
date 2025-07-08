package javaexercises;

public class Abstraccion {
    public static void main(String[] args){
        Figura figura = new Circulo(5);
        figura.dibujar();

        Figura figura2 = new Cuadrado(5);
        System.out.println(" El Area es :" + figura2.calcularArea());

    }
}

abstract class Figura{
    public abstract void dibujar();
    public abstract double calcularArea();
}

class Cuadrado extends Figura{
    private double lado;

    public Cuadrado(double lado){
        this.lado = lado;
    }

    public void dibujar(){
        System.out.println("Dibujando un cuadrado");
    }

    public double calcularArea(){
        return lado * lado;
    }
}

class Circulo extends Figura{
    private double radio;

    public Circulo(double radio){
        this.radio = radio;
    }

    public void dibujar(){
        System.out.println("Dibujando un circulo");
    }

    public double calcularArea(){
        return Math.PI * radio * radio;
    }
}
