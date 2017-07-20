package Swing_Practice;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.*;

/**
 * Created by tatsuki on 2017/03/13.
 */
public class Practice02 extends JFrame {
    private static Practice02 practice02;
    private JLabel label;
    private int counter;
    Practice02(){
        setDefaultCloseOperation(3);
        setSize(new Dimension(500,500));
        setResizable(false);
        setLocationRelativeTo(null);
        label = new JLabel(""){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
            }
        };
        add(label);
        System.out.println("a");
        new Thread(()->{
            while(counter < 100){
                label.setText("" + counter);
                System.out.println("" + counter);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                counter++;
            }
        }).start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->createGUI());
    }

    public static void createGUI(){
        practice02 = new Practice02();
        practice02.setVisible(true);
    }
}
