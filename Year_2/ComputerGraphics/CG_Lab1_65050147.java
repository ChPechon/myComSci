import java.awt.*;
import java.util.Random;

import javax.swing.*;

class CG_Lab1_65050147 extends JPanel {
    public static void main(String[] args) {
        GraphicsSwing m = new GraphicsSwing();

        JFrame f = new JFrame();
        f.add(m);
        f.setTitle("First Swing");
        f.setSize(600, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        g.drawString("Hello", 40, 40);
        g.setColor(Color.BLUE);
        g.fillRect(130, 30, 100, 80);
        g.drawOval(30, 130, 50, 60);
        g.setColor(Color.RED);
        g.drawLine(0, 0, 200, 30);
        g.fillOval(130, 130, 50, 60);
        g.drawArc(30, 200, 40, 50, 90, 60);
        g.fillArc(30, 130, 40, 50, 180, 40);

        for (int i = 0; i < 10; i++) {
            Random rand = new Random();
            Color color = new Color(rand.nextInt(0xFFFFFF));
            g.setColor(color);
            plot(g, rand.nextInt(600), rand.nextInt(600));
        }
    }

    private void plot(Graphics g, int x, int y) {
        g.fillRect(x, y,5, 5);
    }
}