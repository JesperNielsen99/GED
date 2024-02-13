import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class GraphicsApp extends JFrame {
    public static void main(String[] args) {
        JFrame frame = new GraphicsApp();
        frame.setSize(700,700);
        frame.setTitle("GraphicsApp");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public GraphicsApp() {
        add(new DrawPanel());
    }

    class DrawPanel extends JPanel {
        Random randomGen = new Random();
        int count = 0;

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int x1 = randomGen.nextInt(10,250);
            int x2 = randomGen.nextInt(10, 250);
            int y1 = randomGen.nextInt(10, 250);
            int y2 = randomGen.nextInt(10, 250);
            g.drawLine(x1, y1, x2, y2);

            Font font = new Font("Arial", Font.BOLD, 18); // You can change the font type, style, and size
            g.setFont(font);
            Color textColor = Color.RED; // You can change the color
            g.setColor(textColor);

            count++;
            g.drawString("" + count, 15 ,15);
        }
    }
}
