public class Examen {
   public static void main(String[] args) {
        System.out.println("Examen parcial 1");
        System.out.println("Pregunta 1");
        Vector a = new VectorPolar(35, 120);
        Vector b = new VectorPolar(40, 220);
        CalculadoraVector calculadora = new CalculadoraVector();
        Vector c = calculadora.regresarVectorSuma(a, b);
        System.out.println("Magnitud del vector A+B = "+ c.getMagnitud());
        System.out.println("Direccion del vector A+B = "+ c.getDireccion());

        System.out.println("\nPregunta 2");
        Particula particula = new Particula("((2*t^3)/3)+((t^2)/2)-6*t+5", 1.886);
        System.out.println("Ecuacion velocidad = "+particula.getEcuacionVelocidad());
        System.out.println("Ecuacion aceleracion = "+particula.getEcuacionAceleracion());
        System.out.println("Posicion en t=1.88s = "+particula.getPosicion());
        System.out.println("Velocidad en t=1.88s = "+particula.getVelocidad());
        System.out.println("Aceleracion en t=1.88s = "+particula.getAceleracion());

        System.out.println("\nPregunta 3");
        Mrua mrua = new Mrua(0, 0, 9.81);
        mrua.evaluarTiempo(3);
        System.out.println("Altura = "+mrua.getPosicion());
        System.out.println("Velocidad con la que impacta = "+mrua.getVelocidad());
    }
    
}
