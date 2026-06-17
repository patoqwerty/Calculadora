import org.matheclipse.core.eval.ExprEvaluator;

public class Particula{
    private double posicion;
    private double velocidad;
    private double aceleracion;
    private String ecuacionPosicion;
    private String ecuacionVelocidad;
    private String ecuacionAceleracion;

    private double tiempo;

    private static ExprEvaluator util = new ExprEvaluator();

    public Particula(String ecuacionPosicion, double tiempo) {
        this.ecuacionPosicion = ecuacionPosicion;
        this.tiempo = tiempo;
        calcularEcuacionVelocidad();
        calcularEcuacionAceleracion();
        calcularPosicion(tiempo);
        calcularVelocidad(tiempo);
        calcularAceleracion(tiempo);
    }

    public void cambiarTiempo(double tiempo){
        this.tiempo = tiempo;
        calcularPosicion(tiempo);
        calcularVelocidad(tiempo);
        calcularAceleracion(tiempo);
    }

    public void calcularEcuacionVelocidad(){
        ecuacionVelocidad = util.eval(
            "D("+ ecuacionPosicion + ", t)"
        ).toString();
    }

    public void calcularEcuacionAceleracion(){
        ecuacionAceleracion = util.eval(
            "D("+ ecuacionVelocidad + ", t)"
        ).toString();
    }

    public void calcularPosicion(double tiempo){
        posicion = util.eval (ecuacionPosicion.replace("t", "("+ tiempo + ")")).toDoubleDefault(Double.NaN);
    }

    public void calcularVelocidad(double tiempo){
        velocidad = util.eval(ecuacionVelocidad.replace("t", "("+ tiempo + ")")).toDoubleDefault(Double.NaN);
    }

    public void calcularAceleracion(double tiempo){
        aceleracion = util.eval (ecuacionAceleracion.replace("t", "("+ tiempo + ")")).toDoubleDefault(Double.NaN);
    }

    public double getPosicion() {
        return posicion;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public double getAceleracion() {
        return aceleracion;
    }

    public String getEcuacionPosicion() {
        return ecuacionPosicion;
    }

    public String getEcuacionVelocidad() {
        return ecuacionVelocidad;
    }

    public String getEcuacionAceleracion() {
        return ecuacionAceleracion;
    }

    public double getTiempo() {
        return tiempo;
    }

    public static void main(String[] args) {
        Particula particula1 = new Particula("t^2 + 3*t - 1",0);
        particula1.cambiarTiempo(2);
    }
}