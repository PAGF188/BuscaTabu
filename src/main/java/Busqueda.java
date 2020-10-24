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
    private ArrayList<Integer> estado;    //mejor solucion
    private ArrayList<Integer> vecino;
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
        vecino = (ArrayList<Integer>) estado.clone();

    }

    /**
     * Para iniciar la búsqueda con estado inicial aleatorio.
     * @param costes, Para cada ciudad sus posicion en coordenadas (radianes)
     */
    public Busqueda(HashMap<Integer, Coordenadas> costes) {
        this.costes = costes;
        this.iteracción = 0;
        estado = this.generaEstadoAleatorio();
        vecino = (ArrayList<Integer>) estado.clone();
    }

    public void buscar(){
        imprimeEstado(estado);
        System.out.println("\n\tCOSTE: " + costeRecorrido(this.estado));
    }

    /**
     * generar estado inicial aleatorio.
     * @return array de enteros con la configuración inicial
     */
    private ArrayList<Integer> generaEstadoAleatorio(){
        ArrayList<Integer> si = new ArrayList<>();
        for(int i=0; i<costes.size()-1; i++){
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

    /**
     * Para calcular el coste de un recorrido en base a la formula del enunciado
     * @return int, coste (redondeado hacia arriba)
     */
    private int costeRecorrido(ArrayList<Integer> estado){
        double coste=0.0;
        //primera ciudad del vector de recorrido (que no contiene a la ciudad 0)
        Integer ciudad1 = estado.get(0);
        //Sumamos en coste la distancia de la ciudad con id 0 a la primera ciudad del estado.
        coste += costes.get(0).distancia(costes.get(ciudad1));

        //la última a mano
        for(int i=0;i<estado.size()-1;i++){
            coste += costes.get(estado.get(i)).distancia(costes.get(estado.get(i+1)));
        }

        //sumamos de la úlima a cero
        coste += costes.get(estado.get(estado.size()-1)).distancia(costes.get(0));
        return((int)Math.ceil(coste));
    }
    
    public void imprimeEstado(ArrayList<Integer> estado){
        System.out.print("RECORRIDO: ");
        for(Integer x: estado) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

}
