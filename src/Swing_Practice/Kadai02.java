package Swing_Practice;

import sun.plugin.util.UIUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.List;

/**
 * Created by tatsuki on 2017/03/16.
 */
public class Kadai02 extends JFrame {
    private JComponent component;
    private IndexFrame indexFrame;
    private BufferedImage[] icons;
    private BufferedImage[] backgrounds;
    Kadai02(){
        setDefaultCloseOperation(3);
        setSize(600,400);
        setLocationRelativeTo(null);
        component = new JComponent() {
            @Override
            protected void paintComponent(Graphics g) {
//                super.paintComponent(g);
                Graphics2D graphics2D = (Graphics2D) g;
                graphics2D.setBackground(Color.WHITE);
                graphics2D.setFont(graphics2D.getFont().deriveFont(Font.ITALIC,105f));
                graphics2D.setColor(Color.YELLOW.darker());
                graphics2D.drawString("F",44,120);
//                graphics2D.setFont(graphics2D.getFont().deriveFont(Font.ITALIC,54f));
//                graphics2D.drawString("orce",75,53);
                graphics2D.setColor(Color.YELLOW);
//                graphics2D.setFont(graphics2D.getFont().deriveFont(Font.ITALIC,68f));
                graphics2D.drawString("F",40,125);
                graphics2D.setFont(graphics2D.getFont().deriveFont(Font.ITALIC,68f));
                graphics2D.drawString("orce",83,125);
                graphics2D.setColor(Color.RED.darker());
                graphics2D.setFont(graphics2D.getFont().deriveFont(Font.ITALIC,105f));
                graphics2D.drawString("S",140,220);
                graphics2D.setColor(Color.RED);
                graphics2D.drawString("S",136,225);
                graphics2D.setFont(graphics2D.getFont().deriveFont(Font.ITALIC,68f));
                graphics2D.drawString("oftware",193,220);
                graphics2D.setColor(Color.CYAN);
                graphics2D.fillRect(0,295,600,10);
            }
        };
        add(component);
        indexFrame = new IndexFrame();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->new Kadai02().setVisible(true));
    }

    private class IndexFrame extends JFrame{
        IndexFrame(){
            setDefaultCloseOperation(3);
            setSize(new Dimension(1000,600));
            setResizable(false);
            setLocationRelativeTo(null);
        }
    }

    private class ProgressBar extends SwingWorker{

        @Override
        protected void process(List chunks) {
            super.process(chunks);
        }

        @Override
        protected void done() {
            super.done();
        }

        @Override
        protected Object doInBackground() throws Exception {
            icons = new BufferedImage[3];
            return null;
        }
    }

}