package Practice01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by tatsuki on 2017/09/20.
 */
public class Practice08 extends JFrame {
    JPanel[] panels;
    Practice08(){
        panels = new JPanel[3];
        getContentPane().setLayout(new FlowLayout());
        for (JPanel panel:panels){
            panel = new JPanel();
            System.out.println(panel.isFocusable());
            System.out.println(panel.isRequestFocusEnabled());
            panel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    JComponent component = (JComponent) e.getSource();
                    component.grabFocus();
                }
            });
            panel.setPreferredSize(new Dimension(500,100));
            panel.setBackground(new Color(0,(int)(255*Math.random()),0));
            panel.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    JComponent component = (JComponent)e.getSource();
                    component.setBackground(Color.BLUE);
                }

                @Override
                public void focusLost(FocusEvent e) {
                    JComponent component = (JComponent)e.getOppositeComponent();
                    System.out.println(component);
                    component.setBackground(Color.GREEN);
                }
            });
            add(panel);
        }
        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Practice08());
    }
}
