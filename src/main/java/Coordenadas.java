
/**
 * @autor Pablo García Fernández.
 * @file Parser.java
 * @objective procesar los archivos .txt pasados como argumentos (el de aleatorios y el de ciudades)
 */
public class Coordenadas {
    public double x;
    public double y;
    private final static int radio = 6371;


    public Coordenadas(double x, double y) {
        this.x = Math.toRadians(x);
        this.y = Math.toRadians(y);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distancia(Coordenadas aux){
        return(Math.ceil(2.0*radio*Math.asin(Math.sqrt(Math.sin((aux.x-this.x)/2.0)*Math.sin((aux.x-this.x)/2.0) +
                Math.cos(this.x)*Math.cos(aux.x)*Math.sin((aux.y-this.y)/2)*Math.sin((aux.y-this.y)/2.0)))));
    }

    @Override
    public String toString() {
        return "Coordenadas{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
