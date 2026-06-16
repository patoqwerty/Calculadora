public class VectorRectangular extends Vector{
    // Constructor de la clase VectorRectangular
    public VectorRectangular(double x, double y) {
        // Llama al constructor de la clase Vector
        // Calcula automáticamente la magnitud y dirección a partir de las componentes X y Y
        super(x, y, calcularMagnitud(x, y), calcularDireccion(x, y));
    }
}