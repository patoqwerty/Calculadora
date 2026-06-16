public class Mrua {
    private double posicionInicial;
    private double velocidadInicial;
    private Particula particula;

    public Mrua(double posicionInicial, double velocidadInicial, double aceleracion) {
        this.posicionInicial = posicionInicial;
        this.velocidadInicial = velocidadInicial;
        particula = new Particula(crearEcuacionPosicion(aceleracion), 0);
    }

    public String crearEcuacionPosicion(double aceleracion){
        return posicionInicial + "+" + velocidadInicial + "*t+" +
        (aceleracion/2) + "*t^2";
    }

    public void evaluarTiempo(double tiempo){
        particula.cambiarTiempo(tiempo);
    }

    public double getPosicion(){
        return particula.getPosicion();
    }

    public double getVelocidad(){
        return particula.getVelocidad();
    }

    public double getAceleracion(){
        return particula.getAceleracion();
    }

    public String getEcuacionPosicion(){
        return particula.getEcuacionPosicion();
    }

    public String getEcuacionVelocidad(){
        return particula.getEcuacionVelocidad();
    }

    public void imprimirVariables (double tiempo){
        System.out.println("Posicion en el segundo " + tiempo + " : " + getPosicion() + " m");
        System.out.println("Velocidad en el segundo " + tiempo + " : " + getVelocidad()+ " m/s");
        System.out.println("Aceleracion en el segundo " + tiempo + " : " + getAceleracion() + " m/s^2");
    }

    public void imprimirEcuaciones (){
        System.out.println("Ecuacion Posicion: " + getEcuacionPosicion());
        System.out.println("Ecuacion Velocidad: " + getEcuacionVelocidad());
    }

    public static void main(String[] args) {
        Mrua mrua = new Mrua(3, 2, 2);
        mrua.imprimirEcuaciones();
        double tiempo = 3;

        mrua.evaluarTiempo(tiempo);
        mrua.imprimirVariables(tiempo);

        tiempo = 5;
        mrua.evaluarTiempo(tiempo);
        mrua.imprimirVariables(tiempo);
    }
}
