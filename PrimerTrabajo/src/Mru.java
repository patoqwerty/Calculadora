public class Mru {
    private double posicionInicial;
    private Particula particula;

    public Mru(double velocidad, double posicionInicial) {
        this.posicionInicial = posicionInicial;
        particula = new Particula(crearEcuacionPosicion(velocidad), 0);
    }

    public String crearEcuacionPosicion(double velocidad){
        return posicionInicial + "+" + velocidad + "*t";
    }

    public void evaluarTiempo(double tiempo){
        particula.cambiarTiempo(tiempo);
    }

    public double getVelocidad() {
        return particula.getVelocidad();
    }

    public double getPosicionInicial() {
        return posicionInicial;
    }

    public String getEcuacionPosicion(){
        return particula.getEcuacionPosicion();
    }

    public double getPosicion(){
        return particula.getPosicion();
    }

    public static void main(String[] args) {
        Mru mru = new Mru(2, 3);
        System.out.println(mru.getEcuacionPosicion());
        System.out.println("Posicion:" + mru.getPosicion());

        mru.evaluarTiempo(2);
        System.out.println("Posicion:" + mru.getPosicion());

    }
}
