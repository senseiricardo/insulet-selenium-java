package javaexercises;

public class Constructor {
    public static void main(String[] args){

        Bartender b1 = new Bartender("Ricardo", "Bebidas internacionales");
        Bartender b2 = new Bartender("Hassan", "Cerveza artesanal");
        Bartender b3 = new Bartender();
        b3.nombre = "Juan Carlos";
        b3.estilo = "Tequila";
        Bartender b4 = new Bartender("Paulina", "Whisky", "Insulet bar");
        Bartender b5 = new Bartender("Pamela");

        b1.presentarse();
        b2.presentarse();
        b3.presentarse();
        b4.presentarse();
        b5.presentarse();

        b1.servirBebida("Mojito");

    }
}

// Inner class
class Bartender{

    String nombre;
    String estilo;
    String nombreBar;

    public Bartender(){ // javaexercises.Constructor embebido

    }

    public Bartender(String nombre, String estilo){
        this.nombre = nombre;
        this.estilo = estilo;
    }

    public Bartender(String nombre){
        this.nombre = nombre;
        this.estilo = "Bebidas Internacionales";
    }

    public Bartender(String nombre, String estilo, String nombreBar){
        this.nombre = nombre;
        this.estilo = estilo;
        this.nombreBar = nombreBar;
    }

    public void servirBebida(String bebida){
        System.out.println(nombre + " sirve una "+ bebida + " con estilo "+ estilo);
    }

    public void presentarse(){
        System.out.println("Mi nombre es "+ nombre+ " y sere tu bartender especializado en "+estilo);
    }
}
