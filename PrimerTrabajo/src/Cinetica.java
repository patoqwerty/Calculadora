import java.util.ArrayList;
import java.util.List;

public class Cinetica {
    private List<Vector> fuerzas;
    private double masa;

    public Cinetica(List<Vector> fuerzas, double masa) {
        this.fuerzas = fuerzas;
        this.masa = masa;
    }
    
    public double CalculadoraAceleracion (){
        CalculadoraVector calculadoraVector = new CalculadoraVector();
        Vector resultado = calculadoraVector.regresarVectorSuma(fuerzas);
        return resultado.getX() / masa;
    }

    public static void main(String[] args) {
        Vector vector1 = new VectorPolar(20, 0);

        Vector vec1 = new VectorPolar(30, 0);
        Vector vec2 = new VectorPolar(20, 0);
        Vector vec3 = new VectorPolar(10, 0);

        List<Vector> fuerzas2 = new ArrayList<>();
        fuerzas2.add (vec1);
        fuerzas2.add (vec2);
        fuerzas2.add (vec3);

        List<Vector> fuerzas = new ArrayList<>();
        fuerzas.add (vector1);

        Cinetica ejemploCinetica1 = new Cinetica(fuerzas, 3);
        System.out.println("La aceleracion es: " +
            ejemploCinetica1.CalculadoraAceleracion() + "m/s");

        Vector vector2 = new VectorPolar(30, 75);
        fuerzas.add (vector2);

        Cinetica ejemploCinetica2 = new Cinetica(fuerzas, 5);
        System.out.println("La aceleracion es: " +
            ejemploCinetica2.CalculadoraAceleracion() + "m/s");
        
    }

    
}
