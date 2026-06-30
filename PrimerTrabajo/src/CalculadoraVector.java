import java.util.ArrayList;
import java.util.List;

public class CalculadoraVector {
    public void imprimirSuma(Vector vector1, Vector vector2){
        double x = vector1.getX() + vector2.getX();
        double y = vector1.getY() + vector2.getY();

        System.out.println("Suma = ("+ x + " , " + y + ")");
    }

    public String devolverSuma(Vector vector1, Vector vector2){
        double x = vector1.getX() + vector2.getX();
        double y = vector1.getY() + vector2.getY();

        return "("+ x+ " , " + y + ")";
    }

    public Vector regresarVectorSuma(List<Vector> vectores){
        double x = 0;
        double y = 0;
        for (Vector vector : vectores){
            x+= vector.getX();
            y+= vector.getY();        
        }
        
        return new VectorRectangular(x, y);
    }

    public static void main(String[] args) {
        VectorRectangular a = new VectorRectangular(30, -45);
        VectorRectangular b = new VectorRectangular(-25, -10);
        VectorPolar c = new VectorPolar(40, 130);
        VectorPolar d = new VectorPolar(30, 35);

        //System.out.println("Suma = ("+ (b.getX() + c.getX()) + " , " + (b.getY() + c.getY()) + ")");

        //Instancia de la calculadora 
        CalculadoraVector calculadoraVector = new CalculadoraVector();

        //Sumar en imprimir directamente con el metodo imprimirSuma()
        calculadoraVector.imprimirSuma(b, c);

        //Devolver la cadena de caracteres del resultado de la suma
        //NOTA: Si queremos observar el valor debemos imprimirlo
        System.out.println("Suma = " + calculadoraVector.devolverSuma(b, c));

        //Devuelve un nuevo objeto de tipo vector
        //Con este nuevo objeto podemos ocupar todos los metodos de la clase Vector
        //Si queremos observar el resultado, se pueden generar cadenas de caracteres
        //Esta opcion nos permite usar el vector resultado para operarlo con otro vector


        List <Vector> vectores = new ArrayList <> ();
        vectores.add(b);
        vectores.add(c);
        Vector resultadoSuma = calculadoraVector.regresarVectorSuma(vectores);
        //System.out.println(resultadoSuma.toString());
        System.out.println("Suma = (" + resultadoSuma.getX() + " , " + (resultadoSuma.getY()));

        calculadoraVector.imprimirSuma(resultadoSuma, d);

    }
}
