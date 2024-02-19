import java.awt.*;
import javax.swing.*;

public class CG_Lab4_65050147 extends JPanel {

    public static void main(String[] args) {
        CG_Lab4_65050147 m = new CG_Lab4_65050147();

        JFrame f = new JFrame();
        f.add(m);
        f.setTitle("Circle and Elipse test");
        f.setSize(600, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        midpointCircle(g, 100, 100, 100);
        midpointEllipse(g, 400, 350, 50, 100);
    }

    public void midpointCircle(Graphics g, int xc, int yc, int r) {
        int x = 0;
        int y = r;
        int Dx = 2 * x;
        int Dy = 2 * y;
        int D = 1 - r;
        while (x <= y) {

            // Plot 8 octants
            plot(g, xc + x, yc + y); // 1
            plot(g, xc + y, yc + x); // 2
            plot(g, xc + y, yc - x); // 3
            plot(g, xc + x, yc - y); // 4
            plot(g, xc - x, yc - y); // 5
            plot(g, xc - y, yc - x); // 6
            plot(g, xc - y, yc + x); // 7
            plot(g, xc - x, yc + y); // 8
            x = x + 1;
            Dx = Dx + 2;
            D = D + Dx + 1;

            if (D >= 0) {
                y = y - 1;
                Dy = Dy - 2;
                D = D - Dy;
            }
        }
    }

    public void midpointEllipse(Graphics g, int xc, int yc, int a, int b) {
        int a2 = a * a;
        int b2 = b * b;
        int twoA2 = 2 * a2, twoB2 = 2 * b2;

        // REGION 1
        int x = 0;
        int y = b;
        int D = Math.round(b2 - a2 * b + a2 / 4);
        int Dx = 0, Dy = twoA2 * y;

        while (Dx <= Dy) {
            // Plot 4 quardants
            plot(g, xc + x, yc + y); // 1
            plot(g, xc + x, yc - y); // 2
            plot(g, xc - x, yc - y); // 3
            plot(g, xc - x, yc + y); // 4

            x = x + 1;
            Dx = Dx + twoB2;
            D = D + Dx + b2;

            if (D >= 0) {
                y = y - 1;
                Dy = Dy - twoA2;
                D = D - Dy;
            }
        }

        // REGION 2
        x = a;
        y = 0;
        D = Math.round(a2 - b2 * a + b2 / 4);
        Dx = twoB2 * x;
        Dy = 0;

        while (Dx >= Dy) {

            // Plot 4 quardants
            plot(g, xc + x, yc + y); // 1
            plot(g, xc + x, yc - y); // 2
            plot(g, xc - x, yc - y); // 3
            plot(g, xc - x, yc + y); // 4

            y = y + 1;
            Dy = Dy + twoA2;
            D = D + Dy + a2;

            if (D >= 0) {
                x = x - 1;
                Dx = Dx - twoB2;
                D = D - Dx;
            }
        }
    }

    private void plot(Graphics g, int x, int y) {
        g.fillRect(x, y, 1, 1);
    }
}