import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Pablo García Fernández
 * @file Bsqueda.java
 * @objective - Se encarga de realizar la búsqueda tabú para el problema del viajante.
 *            - Muestra la mejor solución encontrada e información de la misma (coste, vector desplazamiento...)
 *
 */
public class Busqueda {
    private HashMap<Integer,Coordenadas> costes;
    private ArrayList<Integer> estado;
    private int iteracción;

    /**
     * Para iniciar la búsqueda en una solucion dada.
     * @param costes, Para cada ciudad sus posicion en coordenadas (radianes)
     * @param estadoInicial, estado de partida, solucion inicial.
     */
    public Busqueda(HashMap<Integer, Coordenadas> costes, ArrayList<Integer> estadoInicial) {
        this.costes = costes;
        this.estado = estadoInicial;
        this.iteracción = 0;
    }

    /**
     * Para iniciar la búsqueda con estado inicial aleatorio.
     * @param costes, Para cada ciudad sus posicion en coordenadas (radianes)
     */
    public Busqueda(HashMap<Integer, Coordenadas> costes) {
        this.costes = costes;
        this.iteracción = 0;
        estado = this.generaEstadoAleatorio();
    }

    public void buscar(){
        System.out.println("buscar");
    }

    /**
     * generar estado inicial aleatorio. Repasar esta funcion
     */
    private ArrayList<Integer> generaEstadoAleatorio(){
        ArrayList<Integer> si = new ArrayList<>();
        System.out.println(costes.size());
        for(int i=0; i<costes.size(); i++){
            int valor = 1 + (int)(Math.random() * 99);
            if(si.contains(valor)) {
                do {
                    valor = (valor + 1) % 99;
                    if (valor == 0)
                        valor = 99;
                } while (si.contains(valor));
            }
            si.add(valor);
        }
        return(si);
    }
    
    public void imprimeEstado(){
        for(Integer x: estado) {
            System.out.println(x + " ");
        }
    }

}
