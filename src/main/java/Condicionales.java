public class Condicionales {
    public static void main(String[] args){

        // Eres mayor de edad?

        int edad = 17;

        // IF - Condicion 1
        if(edad >= 18){
            System.out.println("Eres mayor de edad🍻");
        }

        // IF ELSE
        if(edad >= 18){
            System.out.println("Eres mayor de edad🍻");
        }else{
            System.out.println("Eres menor de edad, fuera de mi bar!");
        }

        // IF-ELSE-IF
        // Mis calificaciones

        int calificacion = 55;
        if(calificacion >= 90){
            System.out.println("Excelente!!!");
        } else if (calificacion >= 80){
            // Block code o bloque de codigo
            System.out.println("Bien!!!");
        } else if (calificacion >= 70){
            System.out.println("Panzaste!!");
        }else{
            System.out.println("Reprobado!!!");
        }

        /*
        dia 1 = lunes
        dia 2 = martes
        dia 3 = miercoles
        .
        ,
        .
         */

        int dia = 10;
        switch(dia){
            case 1:
                System.out.println("Lunes");
                break;
            case 2:
                System.out.println("Martes");
                break;
            case 3:
                System.out.println("Miercoles");
                break;
            default:
                System.out.println("Otro dia");
        }

        // TIP:

        // Operador terniario
        String mensaje = (edad >=18) ? "Adulto" : "Menor de edad";
        System.out.println(mensaje);


    }
}
