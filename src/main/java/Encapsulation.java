import java.awt.desktop.SystemEventListener;

public class Encapsulation {
    public static void main(String[] args){

        Persona persona1 = new Persona();
        persona1.setNombre("Ricardo");
        persona1.setEdad(-100);

        System.out.println("La edad de la persona "+persona1.getNombre()
        +" es de " + persona1.getEdad() + " años");

        Persona persona2 = new Persona("Juan Carlos", 37);

        System.out.println("Nombre: "+persona2.getNombre());
        System.out.println("Edad: "+persona2.getEdad());

        persona2.setEdad(38);
        System.out.println("Edad modificada: "+persona2.getEdad());
    }
}

class Persona{
    private String nombre;
    private int edad;

    // Constructor
    public Persona(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }

    public Persona(){

    }

    // Getters and setters - Encapsulation

    public String getNombre(){
        return nombre;
    }

    public int getEdad(){
        return edad;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setEdad(int edad){
        if(edad > 0){
            this.edad = edad;
        }else{
            this.edad = -1;
            System.out.println("Edad no valida");
        }
    }
}
