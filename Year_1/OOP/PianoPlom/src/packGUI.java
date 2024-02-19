package PianoPlom.src;

import  javax.swing.*;
import  java.awt.*;
import  java.awt.event.*;

public class packGUI extends JFrame implements ActionListener {
    private JLayeredPane Keyboard;
    private JPanel panel;
    private JLabel titles;
    private JButton C, D, E, F, G, A, B;
    private JButton Db, Eb, Gb, Ab, Bb;
    private JButton Play; // ปุ่ม Play

    public packGUI() {
        ComponentsDetail();
    }

    public void ComponentsDetail() {
        Keyboard = getLayeredPane();
        panel = new JPanel();
        titles = new JLabel("Ear Training");
        C = new JButton("C");
        Db = new JButton("Db");
        D = new JButton("D");
        Eb = new JButton("Eb");
        E = new JButton("E");
        F = new JButton("F");
        Gb = new JButton("Gb");
        G = new JButton("G");
        Ab = new JButton("Ab");
        A = new JButton("A");
        Bb = new JButton("Bb");
        B = new JButton("B");
        Play = new JButton("Play");
        Play.setBounds(400, 550, 120, 40);
        add(Play);
        Play.addActionListener(this);

        panel.setBounds(0, 0, 500, 500);
        panel.setVisible(true);
        panel.setLayout(null);
        panel.setBackground(Color.gray);
        titles.setVisible(true);
        titles.setBounds(10, 10, 200, 200);

        //ตรงนี้แก้โค้ดที่เขียนซ้ำ ๆ ลงไปใน methods แก้ง่ายขึ้นเยอะ
        setWhiteNoteDetails(C, 100, 200, 1);
        setWhiteNoteDetails(D, 200, 200, 2);
        setWhiteNoteDetails(E, 300, 200, 3);
        setWhiteNoteDetails(F, 400, 200, 4);
        setWhiteNoteDetails(G, 500, 200, 5);
        setWhiteNoteDetails(A, 600, 200, 6);
        setWhiteNoteDetails(B, 700, 200, 7);

        setBlackNoteDetails(Db, 174, 200, 8);
        setBlackNoteDetails(Eb, 274, 200, 9);
        setBlackNoteDetails(Gb, 474, 200, 10);
        setBlackNoteDetails(Ab, 574, 200, 11);
        setBlackNoteDetails(Bb, 674, 200, 12);
        panel.add(titles);
        add(panel);
    }

    private void setWhiteNoteDetails(JButton key, int x, int y, int z) {
        key.setBounds(x, y, 100, 300);
        key.setBackground(Color.white);
        key.setFocusable(false);
        key.setVerticalAlignment(JButton.BOTTOM);
        Keyboard.add(key, Integer.valueOf(z));
        key.addActionListener(this);
    }

    private void setBlackNoteDetails(JButton key, int x, int y, int z) {
        key.setBounds(x, y, 52, 200);
        key.setBackground(Color.black);
        key.setFocusable(false);
        key.setForeground(Color.white);
        key.setVerticalAlignment(JButton.BOTTOM);
        Keyboard.add(key, Integer.valueOf(z));
        key.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
