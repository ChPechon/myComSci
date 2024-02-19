package myProject.fifty;
import java.awt.FlowLayout;
import  java.awt.Dimension;
import  java.awt.event.ActionListener;
import  java.awt.event.ActionEvent;
import  javax.swing.*;

public class App {
    private JFrame f;
    private JLabel lblogo;
    private JButton btnNew;
    private JButton btnLeft;
    private JButton btnRight;
    private JLabel  lbYourScore;
    private JLabel  lbScore;
    private JButton btnNext;
    private Icon    img1;
    private Icon    img2;
    private Icon    img3;
    private Icon    img4;

    public App() {
        f = new JFrame("fifty-fifty");
        f.setSize(500, 450);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        detailComponents();
    }

    private void detailComponents() {
        try {
            img1 = new ImageIcon("myProject/fifty/packGUI/CS.png"); // fixing
            img2 = new ImageIcon("myProject/fifty/packGUI/puppy.png");
            img3 = new ImageIcon("myProject/fifty/packGUI/blue600x600.png");
            img4 = new ImageIcon("myProject/fifty/packGUI/orange600x600.jpg");
        } catch (Exception e) {
            System.out.println(e);
        }
        lblogo = new JLabel("logo");
        btnNew = new JButton("new");
        btnLeft = new JButton(img3); //L
        btnRight = new JButton(img4); //R
        lbYourScore = new JLabel("Your Score");
        lbScore = new JLabel("0");
        btnNext = new JButton("next");
        lblogo.setPreferredSize(new Dimension(200, 100));
        btnNew.setPreferredSize(new Dimension(200, 100));
        btnLeft.setPreferredSize(new Dimension(200, 200));
        btnRight.setPreferredSize(new Dimension(200, 200));
        lbYourScore.setPreferredSize(new Dimension(100, 100));
        lbScore.setPreferredSize(new Dimension(100, 100));
        btnNext.setPreferredSize(new Dimension(200, 100));
        f.setLayout(new FlowLayout());
        f.add(lblogo);
        f.add(btnNew);
        f.add(btnLeft);
        f.add(btnRight);
        f.add(lbYourScore);
        f.add(lbScore);
        f.add(btnNext);
        AllButtonListener bl = new AllButtonListener();
        btnLeft.addActionListener(bl);
    }

    private class AllButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev) {
            JButton source = (JButton)ev.getSource();
            if (source == btnLeft) {
                btnLeft.setIcon(img1); // runable but image cannot show
            } else if(source == btnRight) {
                btnRight.setIcon(img2);
            }
        }
    }
}

// lec7 Swing3 Fifty-Fifty (29.19)
