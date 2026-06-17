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
    
    public static void main(String[] args) {
        Vector velocidadInicial = new VectorPolar(50, 30);
        MovimientoParabolico mov = new MovimientoParabolico(velocidadInicial, 0, 0);
        mov.evaluarTiempo(2);
        System.out.println("Distancia en el segundo 2 es: " + mov.getPosicion());
        System.out.println("Altura en el segundo 2 es: " + mov.getAltura());
    }
}
