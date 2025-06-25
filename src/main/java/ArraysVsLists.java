import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysVsLists {
    public static void main(String[] args){

        // Arreglo

        // Colores             0      1        2          3
        String[] colores = {"Azul", "Rojo", "Verde", "Amarillo"};

        System.out.println("El color es :" + colores[0]);

        int[] numeros = new int[5];
        numeros[1] = 3;
        numeros[2]= 5;
        numeros[0]= 9;
        numeros[3]= 10;
        numeros[4]= 100;

        System.out.println("El numero es:"+numeros[4]);

        String[][] alumnos = new String[5][5];
        alumnos[0][0] = "Ricardo";
        alumnos[0][1] = "Avalos";
        alumnos[1][0] = "Juan Carlos";
        alumnos[1][1] = "Gaona";

        // Listas

        List<String> animales = new ArrayList<>();
        animales.add("Perro");
        animales.add("Gato");
        animales.add("Tortuga");

        for(String animal : animales){
            System.out.println(animal);
        }

        animales.remove("Perro");
        animales.add("Peces");

        System.out.println("Lista Modificada");

        for(String animal : animales){
            System.out.println(animal);
        }

        // TIP
        List<String> alumnos2 = Arrays.asList("Paulina", "Paola", "Hassan");
        alumnos2.forEach(System.out::println);

    }
}
