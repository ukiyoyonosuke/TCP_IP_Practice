package Swing_Practice;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by tatsuki on 2017/0　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　3/10.
 */
public class Practice01 extends JFrame{
    private JComponent component;
    private BufferedImage image;
    Practice01(){
        super();
        try {
            image = ImageIO.read(getClass().getResource("image.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        component = new JComponent() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D graphics2D = (Graphics2D)g;
                graphics2D.drawImage(image,0,0,null);
            }
        };
        add(component);
        setVisible(true);
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        setSize(new Dimension(500,500));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
                new Practice01();
            }
        );
    }
}
