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
    
       public static void main(String[] args) {
        Vector velocidadInicial = new VectorPolar(30, 70);
        MovimientoParabolico mov = new MovimientoParabolico(velocidadInicial, 0, 0);
        mov.evaluarTiempo(2);
        System.out.println("Distancia en el segundo 2 es: " + mov.getPosicion());
        System.out.println("Altura en el segundo 2 es: " + mov.getAltura());

        //System.out.println("El tiempo en el que el proyectil alcanza su altura maxima es : " + mov.calcularTiempoVelocidadVertical(0));

        mov.evaluarTiempo(mov.calcularTiempoVelocidadVertical(0));
        System.out.println("La altura maxima es : " + mov.getAltura());
    }
}

