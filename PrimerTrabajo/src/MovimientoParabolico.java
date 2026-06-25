public class MovimientoParabolico {
    Vector velocidadInicial;
    Mru movimientoHorizontal;
    Mrua movimientoVertical;


    public MovimientoParabolico(Vector velocidadInicial, double posicionInicial, double alturaInicial) {
        this.velocidadInicial = velocidadInicial;
        movimientoHorizontal = new Mru(velocidadInicial.getX(), posicionInicial);
        movimientoVertical = new Mrua(alturaInicial, velocidadInicial.getY(), -9.81);

    }

    public void evaluarTiempo(double tiempo){
        movimientoHorizontal.evaluarTiempo(tiempo);
        movimientoVertical.evaluarTiempo(tiempo);
    }

    public double getPosicion(){
        return movimientoHorizontal.getPosicion();

    }

    public double getAltura(){
        return movimientoVertical.getPosicion();
    }

    public String calcularTiempoAltura(double altura){
        return movimientoVertical.calcularTiempoPosicion(altura);
    }

    public String calcularTiempoAlturaMaximal(double velocidad){
        return movimientoVertical.calcularTiempoVelocidad(velocidad);
    }

    public Double calcularTiempoVelocidadVertical(double velocidad){
        String tiempo = movimientoVertical.calcularTiempoVelocidad(velocidad).replace("{{t->", "").replace("}}", "");
        return Double.parseDouble(tiempo);

    }

    public  Double calcularTiempoVuelo(){
        String tiempo = calcularTiempoAltura(0);
        int inicio = tiempo.lastIndexOf("t->") + 3;
        int fin = tiempo.indexOf("}", inicio);
        return Double.parseDouble(tiempo.substring(inicio, fin));

       /*  String altura = calcularTiempoAltura(0).replace("{{t->0.0},{t->", "").replace("}}", "");
        return Double.parseDouble(altura);*/
    }

    public double calcularDistanciaTotal(){
        calcularTiempoVuelo();
        movimientoHorizontal.evaluarTiempo(calcularTiempoVuelo());
        return movimientoHorizontal.getPosicion();
    }

    public double calcularAlturaMaxima(){
        movimientoVertical.evaluarTiempo(calcularTiempoVelocidadVertical(0));
        return movimientoVertical.getPosicion();

    }
    
       public static void main(String[] args) {
        Vector velocidadInicial = new VectorPolar(150, 0);

        MovimientoParabolico mov = new MovimientoParabolico(velocidadInicial, 0, 300);
       
        System.out.println("La altura maxima es : " + mov.calcularAlturaMaxima());
        System.out.println("El tiempo de vuelo es: " + mov.calcularTiempoVuelo());
        System.out.println("Distancia recorrida " + mov.calcularDistanciaTotal());
    }
}

