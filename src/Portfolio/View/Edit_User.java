package Portfolio.View;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by tatsuki on 2017/06/15.
 */
public class Edit_User extends JFrame{
    BufferedImage background;
    JList user_list;
    JSeparator separator;
    JLabel profile;
    JTextField name;
    JTextField age;
    JTextField gender;
    JTextField details;
    Edit_User(String user){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(new Dimension(600,500));
        setResizable(false);
        setVisible(true);
    }
}
