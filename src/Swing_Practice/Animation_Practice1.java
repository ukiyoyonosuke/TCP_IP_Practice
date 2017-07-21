package Swing_Practice;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

/**
 * Created by tatsuki on 2017/07/19.
 */
public class Animation_Practice1 extends JFrame{
    BufferedImage image;
    private float start_time;
    private float time;
    private float alpha;
    private Timer timer;
    Animation_Practice1(){
        setSize(new Dimension(500,500));
        setDefaultCloseOperation(3);
        try {
            image = ImageIO.read(getClass().getResource("image.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setContentPane(new JComponent() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D)g;
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,alpha));
                System.out.println(alpha);
                System.out.println(time);
                g2d.drawImage(image, 0, 0, 500, 500,
                        (img, infoflags,  x,  y,  width,  height) -> {
                            System.out.println("a");
                            System.out.println(infoflags);
                            System.out.println(x);
                            System.out.println(width);
                            return false;
                        });
            }
        });
        start_time = System.nanoTime()/1000000;
        timer = new Timer(50,(e)->{
            time = System.nanoTime()/1000000 - start_time;
            alpha = time/3000;
            if (alpha > 1) {
                timer.stop();
            }else {
                repaint();
            }
        });
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Animation_Practice1().setVisible(true);
        });
    }
}
