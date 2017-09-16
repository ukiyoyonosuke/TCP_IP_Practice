package Practice01;

import oracle.jvm.hotspot.jfr.JFR;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by tatsuki on 2017/09/15.
 */
public class Practice05 extends JFrame{
    JButton button;
    BufferedImage image;
    Practice05(){
        setDefaultCloseOperation(3);
        try {
            image = ImageIO.read(getClass().getResource("trash.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setSize(500,500);
        button = new JButton(new ImageIcon(image));
        getContentPane().setLayout(null);
        button.setPreferredSize(new Dimension(70,52));
        button.setBounds(50,50,72,52);
        add(button);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Practice05());
    }
}
