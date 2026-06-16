public class VectorPolar extends Vector{
    // Constructor de la clase VectorPolar
    public VectorPolar(double magnitud, double direccion) {
        // Llama al constructor de la clase Vector
        // Calcula automáticamente las componentes X y Y a partir de la magnitud y dirección
        super(calcularX(magnitud, direccion),calcularY(magnitud, direccion), magnitud, direccion);
    }
}