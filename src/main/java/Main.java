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
            System.out.println(ciudades.size());
            for (Map.Entry<Integer,Coordenadas> entry : ciudades.entrySet()) {
                Integer key = entry.getKey();
                Coordenadas value = entry.getValue();
                System.out.println(key + "\t" + value + "\n");
            }
        }
        else if(args.length==2){

        }
        else{
            System.out.println("Argument Error! : java -jar <fichero_distancias> [fichero_aleatorios]\n\n");
        }
    }
}
