import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class CG_Lab6_65050147 extends JPanel {
    public static void main(String[] args) {
        CG_Lab6_65050147 m = new CG_Lab6_65050147();

        JFrame f = new JFrame();
        f.add(m);
        f.setTitle("Transformation Lab");
        f.setSize(600, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }   

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        g2.setTransform(new AffineTransform(1, 0, 0, 1, 100, 100));
        g2.drawRect(200, 200, 200, 200);

        g2.setColor(Color.RED);
        g2.setTransform(new AffineTransform(Math.cos(Math.toRadians(30)), -Math.sin(Math.toRadians(30)),
                        Math.sin(Math.toRadians(30)), Math.cos(Math.toRadians(30)),0, 0));
        g2.drawRect(200, 200, 200, 200);

        g2.setColor(Color.BLUE);
        g2.setTransform(new AffineTransform(2, 0, 0 , 2, -50, 50));
        g2.drawRect(200, 200, 200, 200);
    }
}