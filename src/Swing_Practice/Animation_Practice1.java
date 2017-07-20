package Swing_Practice;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by tatsuki on 2017/07/19.
 */
public class Animation_Practice1 extends JFrame{
    static BufferedImage image;
    Animation_Practice1(){
        setSize(new Dimension(500,500));
        setDefaultCloseOperation(3);
        setContentPane(new JComponent() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D)g;
                System.out.println(image);
                g2d.drawImage(image,0,0,500,500,null);
            }
        });
    }

    public static void main(String[] args) {
        try {
            image = ImageIO.read(new File("/image.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> {
            new Animation_Practice1().setVisible(true);
        });
    }
}
