import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TapeteSierpinski extends JPanel {
    private int nivelDeRecursividad;  // Nivel de recursividad del fractal

    // Constructor que inicializa el nivel de recursividad
    public TapeteSierpinski(int nivelDeRecursividad) {
        this.nivelDeRecursividad = nivelDeRecursividad;
        setBackground(Color.WHITE);  // Color de fondo
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);  // Color de los cuadrados
        // Llamada inicial al método recursivo para dibujar el tapete
        drawSierpinskiCarpet(g, nivelDeRecursividad, 50, 50, 400, 400);
    }

    // Método recursivo para dibujar el tapete de Sierpinski
    private void drawSierpinskiCarpet(Graphics g, int nivel, int x, int y, int width, int height) {
        if (nivel == 0) {
            // Dibujar un cuadrado completo en el nivel base
            g.fillRect(x, y, width, height);
        } else {
            // Tamaño de cada sub-cuadrado
            int newWidth = width / 3;
            int newHeight = height / 3;

            // Dibujar los 8 cuadrados alrededor del cuadrado central
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    // Evitar dibujar el cuadrado central
                    if (i == 1 && j == 1) {
                        continue;
                    }
                    // Llamada recursiva para los sub-cuadrados
                    drawSierpinskiCarpet(g, nivel - 1, x + i * newWidth, y + j * newHeight, newWidth, newHeight);
                }
            }
        }
    }

    // Método principal para crear la ventana
    public static void main(String[] args) {
        JFrame frame = new JFrame("Tapete de Sierpinski");
        
        // Nivel de recursividad para el tapete
        int nivelDeRecursividad = 3;  // Puedes ajustar este valor para más o menos detalle

        // Crear el panel y agregarlo al marco
        TapeteSierpinski panel = new TapeteSierpinski(nivelDeRecursividad);
        frame.add(panel);
        
        // Configuración del marco
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
