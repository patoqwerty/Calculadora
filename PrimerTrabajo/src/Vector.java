public class Vector {
    // Componente en el eje X
    private double x;
    // Componente en el eje Y
    private double y;
    // Magnitud del vector
    private double magnitud;
    // Dirección del vector en grados
    private double direccion;

    // Constructor de la clase
    public Vector(double x, double y, double magnitud, double direccion) {
        this.x = x;
        this.y = y;
        this.magnitud = magnitud;
        this.direccion = direccion;
    }

    // Devuelve la magnitud del vector
    public double getMagnitud() {
        return magnitud;
    }

    // Modifica la magnitud y recalcula X y Y
    public void setMagnitud(double magnitud) {
        this.magnitud = magnitud;

        // Recalcula las componentes rectangulares
        this.x = calcularX(magnitud, this.direccion);
        this.y = calcularY(magnitud, this.direccion);
    }

    // Devuelve la dirección del vector
    public double getDireccion() {
        return direccion;
    }

    // Modifica la dirección y recalcula X y Y
    public void setDireccion(double direccion) {
        this.direccion = direccion;

        // Recalcula las componentes rectangulares
        this.x = calcularX(this.magnitud, direccion);
        this.y = calcularY(this.magnitud, direccion);
    }

    // Devuelve la componente X
    public double getX() {
        return x;
    }

    // Modifica la componente X y recalcula magnitud y dirección
    public void setX(double x) {
        this.x = x;

        // Recalcula magnitud y dirección
        this.magnitud = calcularMagnitud(x, this.y);
        this.direccion = calcularDireccion(x, this.y);
    }

    // Devuelve la componente Y
    public double getY() {
        return y;
    }

    // Modifica la componente Y y recalcula magnitud y dirección
    public void setY(double y) {
        this.y = y;

        // Recalcula magnitud y dirección
        this.magnitud = calcularMagnitud(this.x, y);
        this.direccion = calcularDireccion(this.x, y);
    }

    // Calcula la componente X a partir de magnitud y dirección
    public static double calcularX(double magnitud, double direccion){
        return magnitud * Math.cos(Math.toRadians(direccion));
    }

    // Calcula la componente Y a partir de magnitud y dirección
    public static double calcularY(double magnitud, double direccion){
        return magnitud * Math.sin(Math.toRadians(direccion));
    }

    // Calcula la magnitud usando el teorema de Pitágoras
    public static double calcularMagnitud(double x, double y){
        return Math.pow((Math.pow(x, 2) + Math.pow(y, 2)), 0.5);
    }

    // Calcula la dirección del vector en grados
    public static double calcularDireccion(double x, double y){

        // Primer cuadrante
        if ((x >= 0) && (y >= 0)){
            return Math.toDegrees(Math.atan(y/x));
        }

        // Cuarto cuadrante
        else if((x >= 0) && (y < 0)){
            return 360 + Math.toDegrees(Math.atan(y/x));
        }

        // Segundo y tercer cuadrante
        else {
            return 180 + Math.toDegrees(Math.atan(y/x));
        }
    }

    @Override
    public String toString() {
        return "Vector [x=" + x + ", y=" + y + ", magnitud=" + magnitud + ", direccion=" + direccion + "]";
    }
    
}