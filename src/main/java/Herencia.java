public class Herencia {

    public static void main(String [] args){

        Perro miPerro = new Perro("firulais");
        miPerro.ladrar();

        miPerro.dormir();

    }
}

// Inner class
class Animal {
    public void dormir(){
        System.out.println("El animal esta durmiendo...");
    }
}

class Perro extends Animal{

    private String nombre;

    public Perro(String nombre){
        this.nombre = nombre;
    }

    public void ladrar(){
        System.out.println(nombre + " Guau!!!");
    }

}
