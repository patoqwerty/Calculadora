import javax.swing.*;
import java.awt.*;


public class MovimientoParabolicoInterfaz extends JFrame{
    public MovimientoParabolicoInterfaz(){
        setTitle("MOVIMIENTO PARABOLICO"); //Titulo
        setSize(500, 400); //Tamaño
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Detener la ejecucion del programa
        setLocationRelativeTo(null);//Cerrar la pantalla

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());//Organizar los componentes uno tras otro

        JLabel etiquetaTitulo = new JLabel("Movimiento Parabolico");
        JLabel etiquetaVelocidad = new JLabel("Velocidad Inicial");

        JLabel etiquetaMagnitud = new JLabel("Magnitud: ");
        JTextField entradaMagnitud = new JTextField(20);

        JLabel etiquetaDireccion = new JLabel("Direccion: ");
        JTextField entradaDireccion = new JTextField(20);

        String [] opciones = {
            "Altura Maxima",
            "Tiempo de Vuelo",
            "Distancia Recorrida",
            "Calcular Todo"};
        JComboBox <String> comoOpciones = new JComboBox<>(opciones);

        JButton botonCalcular = new JButton("Calcular");
        

        JLabel etiquetaResultado = new JLabel("");
        
        botonCalcular.addActionListener(e->{
            Double magnitud = Double.parseDouble(entradaMagnitud.getText());
            Double direccion = Double.parseDouble(entradaDireccion.getText());

            Vector velocidadInicial = new VectorPolar(magnitud, direccion);
            MovimientoParabolico mov = new MovimientoParabolico(velocidadInicial, 0,0);

            int opcion = comoOpciones.getSelectedIndex();

            if (opcion == 0) {
                double resultado =mov.calcularAlturaMaxima();
                etiquetaResultado.setText(resultado + "metros");
            } else if (opcion == 1) {
                double resultado =mov.calcularTiempoVuelo();
                etiquetaResultado.setText(resultado + "segundos");
            } else if (opcion == 2) {
                double resultado =mov.calcularDistanciaTotal();
                etiquetaResultado.setText(resultado + "metros");
            } else if (opcion == 3) {
                etiquetaResultado.setText("<html>Altura Maxima: " + mov.calcularAlturaMaxima() + " metros<br>Tiempo de Vuelo: " + mov.calcularTiempoVuelo() + " segundos<br>Distancia Recorrida: " + mov.calcularDistanciaTotal() + " metros</html>");
            }

            //etiquetaResultado.setText((String)comoOpciones.getSelectedItem());

        });

        panel.add(etiquetaTitulo);//Agregar titulo al panel
        panel.add(etiquetaVelocidad);
        panel.add(etiquetaMagnitud);
        panel.add(entradaMagnitud);
        panel.add(etiquetaDireccion);
        panel.add(entradaDireccion);
        panel.add(comoOpciones);
        panel.add(botonCalcular);
        panel.add(etiquetaResultado);


        add(panel);//Agregar el panel a a ventana


        }
    
        public static void main(String[] args) {
            MovimientoParabolicoInterfaz interfaz = new MovimientoParabolicoInterfaz();
            interfaz.setVisible(true);
        }
}
