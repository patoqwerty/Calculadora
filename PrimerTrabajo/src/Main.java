import org.matheclipse.core.eval.ExprEvaluator;

public class Main { 
    public static void main(String[] args) { 
 
        // Crear motor matemático de Symja 
        ExprEvaluator util = new ExprEvaluator(); 
 
        // ========================================= 
        // DERIVAR FUNCIÓN 
        // ========================================= 
 
        // Variable donde se guardará la derivada 
        String derivada = 
 
                // eval() interpreta y resuelve expresiones matemáticas 
                util.eval( 
 
                        // D(funcion, variable) 
                        // significa: 
                        // derivar la función respecto a la variable 
                        // 
                        // Función: 
                        //      t^2 + 3*t 
                        // 
                        // Variable: 
                        //      t 
                        // 
                        // Derivada matemática: 
                        // 
                        // d/dt(t^2) = 2*t 
                        // d/dt(3*t) = 3 
                        // 
                        // Resultado: 
                        //      3 + 2*t 
                        "D(t^2 + 3*t, t)" 
 
                ) 
 
                // Convertir resultado matemático a texto 
                .toString(); 
 
 
 
        // Mostrar derivada obtenida 
        System.out.println(derivada); 
 
 
 
        // ========================================= 
        // EVALUAR DERIVADA 
        // ========================================= 
 
        // Crear nueva expresión reemplazando: 
        // 
        //      t -> (2) 
        // 
        // Entonces: 
        // 
        //      3+2*t 
        // 
        // se convierte en: 
        // 
        //      3+2*(2) 
        // 
        String expresion = 
 
                derivada.replace( 
                        "t", 
                        "(2)" 
                ); 
 
 
 
        // Variable donde se guardará el resultado final 
        String resultado = 
 
                // Evaluar expresión matemática 
                util.eval(expresion) 
 
                // Convertir resultado a texto 
                .toString(); 
 
 
 
        // Mostrar resultado final 
        System.out.println(resultado); 
 
 
 
        // ========================================= 
        // RESULTADO FINAL 
        // ========================================= 
        // 
        // Función original: 
        // 
        //      t^2 + 3*t 
        // 
        // 
        // Derivada: 
        // 
        //      3 + 2*t 
        // 
        // 
        // Evaluación en t = 2: 
        // 
        //      3 + 2*(2) 
        // 
        //      3 + 4 
        // 
        //      7 
        // 
    } 
} 