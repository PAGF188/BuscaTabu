
/**
 * @autor Pablo García Fernández.
 * @file Parser.java
 * @objective procesar los archivos .txt pasados como argumentos (el de aleatorios y el de ciudades)
 */
public class Coordenadas {
    double x;
    double y;

    public Coordenadas(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Coordenadas{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
