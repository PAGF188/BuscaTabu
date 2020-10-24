import java.util.ArrayList;
import java.util.HashMap;

/**
 * @autor Pablo García Fernández.
 * @file Main.java
 * @objective Leer argumentos de entrada. Disparar le ejecución de la búsqueda
 */
public class Main {
    public static void main(String[] args) {
        //Cuando queremos que el estado inicial sea aleatorio
        if(args.length==1){
            HashMap<Integer,Coordenadas> ciudades = Parser.parsearCiudades(args[0]);
            Busqueda b = new Busqueda(ciudades);
            b.buscar();
        }
        //cuando le pasamos nosotros el estado inicial.
        else if(args.length==2){
            HashMap<Integer,Coordenadas> ciudades = Parser.parsearCiudades(args[0]);
            ArrayList<Integer> estadoInicial = Parser.parsearAleatorios(args[1]);
            Busqueda b = new Busqueda(ciudades,estadoInicial);
            b.buscar();
        }
        else{
            System.out.println("Argument Error! : java -jar <fichero_distancias> [fichero_aleatorios]\n\n");
        }
    }
}


/**
 * for (Map.Entry<Integer, Coordenadas> entry : ciudades.entrySet()) {
 *                 System.out.println("clave=" + entry.getKey() + ", valor=" + entry.getValue());
 *             }
 */
