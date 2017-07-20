package Portfolio.View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by tatsuki on 2017/06/08.
 */
public class Index extends JFrame{
    static BufferedImage background;
    JLabel account;
    JLabel register;
    JLabel register_icon;
    JLabel search_edit;
    JLabel search_edit_icon;
    JLabel edit_user;
    JLabel edit_user_icon;
    JLabel access_log;
    JLabel access_log_icon;
    Index(String user,boolean admin){
        super("Index");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new Dimension(600,500));
        try {
            background = ImageIO.read(getClass().getResource(""));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setContentPane(new JPanel(null){
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D)g;
                g2d.drawImage(background,0,0,600,500,null);
                super.paintComponent(g);
            }
        });
        account = new JLabel("");
        register = new JLabel("");
        register_icon = new JLabel();
        search_edit = new JLabel("");
        search_edit_icon = new JLabel();
        edit_user = new JLabel("");
        edit_user_icon = new JLabel();
        access_log = new JLabel("");
        access_log_icon = new JLabel();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Index("admin",true);
        });
    }
}
