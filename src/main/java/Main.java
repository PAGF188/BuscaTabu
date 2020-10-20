import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @autor Pablo García Fernández.
 * @file Main.java
 * @objective Leer argumentos de entrada. Disparar le ejecución de la búsqueda
 */
public class Main {
    public static void main(String[] args) {
        if(args.length==1){
            HashMap<Integer,Coordenadas> ciudades = Parser.parsearCiudades(args[0]);
        }
        else if(args.length==2){
            HashMap<Integer,Coordenadas> ciudades = Parser.parsearCiudades(args[0]);
            ArrayList<Integer> estadoInicial = Parser.parsearAleatorios(args[1]);
        }
        else{
            System.out.println("Argument Error! : java -jar <fichero_distancias> [fichero_aleatorios]\n\n");
        }
    }
}
