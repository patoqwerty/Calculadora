import org.matheclipse.core.eval.ExprEvaluator;

public class Funcion {
    public static void main(String[] args) {
        //Motor matematico
        ExprEvaluator util = new ExprEvaluator();

        //Derivar una funcion
        String funcion = "x^2 + 3*x";

        String derivada = util.eval(
            "D("+ funcion + ", x)"
        ).toString();

        String derivada2 = util.eval(
            "D(x^2 + 3*x, x)"
        ).toString();

        System.out.println(derivada);
        System.out.println(derivada2);

        //Evaluar una funcion
        int tiempo = 2;
        String funcion_evaluada =  funcion.replace("x", "("+ tiempo + ")");
        String resultado_evaluacion = util.eval(funcion_evaluada).toString();

        System.out.println(resultado_evaluacion);
}
}