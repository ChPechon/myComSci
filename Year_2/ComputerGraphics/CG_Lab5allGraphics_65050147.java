import java.awt.*;
import javax.swing.*;

public class CG_Lab5allGraphics_65050147 extends JPanel implements Runnable {

    public static void main(String[] args) {
        CG_Lab5allGraphics_65050147 m = new CG_Lab5allGraphics_65050147();

        JFrame f = new JFrame();
        f.add(m);
        f.setTitle("Graphics");
        f.setSize(600, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        (new Thread(m)).start();
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, 600, 600);
        g2.setColor(Color.BLACK);
        g2.translate(circleMove, 0);
        g.drawOval(0, 0, 100, 100);
        g2.translate(-circleMove, 0);

        g2.rotate(squareRotate, 300, 300);
        g2.drawRect(200, 200, 200, 200);
        g2.rotate(-squareRotate, 300, 300);

        if (animationStarted) {
            g2.translate(0, -squareMove);
            g2.drawRect(0, 500, 100, 100);
            g2.translate(0, squareMove);
        } else {
            g2.drawRect(0, 500, 100, 100);
        }
    }

    double circleMove = 0;
    double squareRotate = 0;
    double squareMove = 0;

    double circleVelocity = 100;
    double squareVelocity = 100;

    boolean animationStarted = false;

    @Override
    public void run() {
        double lastTime = System.currentTimeMillis();
        double currentTime, elapsedTime;
        double startTime = lastTime;

        while (true) {
            currentTime = System.currentTimeMillis();
            elapsedTime = currentTime - lastTime;
            lastTime = currentTime;

            squareRotate += 0.5 * elapsedTime / 1000.0;
            circleMove += circleVelocity * elapsedTime / 1000.0;

            // check if circle move to the edge window
            if (circleMove >= 500) {
                circleMove = 500;
                circleVelocity = -circleVelocity;
            }
            else if (circleMove <= 0) {
                circleMove = 0;
                circleVelocity = -circleVelocity;
            }

            // check if there's 3 second of animation
            if (currentTime - startTime > 3000)
                animationStarted = true;

            // move the square
            if (animationStarted) {
                squareMove -= squareVelocity * elapsedTime / 1000.0;

                if (squareMove >= 500) {
                    squareMove = 500;
                    squareVelocity = -squareVelocity;
                }
                else if (squareMove <= 0) {
                    squareMove = 0;
                    squareVelocity = -squareVelocity;
                }
            }
            repaint();
        }
    }
}
