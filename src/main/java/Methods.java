public class Methods {

    // Metodo main
    public static void main(String [] args){

    }

    // Metodo nuevo
    public static void hello(){
        System.out.println("Hello World!");
        hello2(); // Invocacion!

    }

    // Metodo nuevo 2
    public static void hello2(){
        System.out.println("Hello World!");
    }

    // Return
    public static int sum(int a, int b){
        int c = a+b;
        return c;
    }

    // 1 - Modificador de access
    // 2- static or non static
    // 3- Return (Int, Double, Obj, Array, List)
    // 4- Nombre del metodo
    // 5- Parametros
    // 6- Cuerpo

    //1      2     3      4            5
    public static void descriptionName(){

        // 6 - bloque de codigo

    }

    // OVERLOADING - Sobrecarga de metodos
    public static double sum(double a, double b){
        double c = a+b;
        return c;
    }


}
