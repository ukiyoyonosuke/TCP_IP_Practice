package Portfolio.View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by tatsuki on 2017/06/15.
 */
public class Edit_User extends JFrame{
    BufferedImage background;
    JList user_list;
    JSplitPane splitPane;
    JSeparator separator;
    JLabel profile;
    JTextField name;
    JTextField age;
    JTextField gender;
    JTextField details;
    JPanel LeftPanel;
    JPanel RightPanel;
    Edit_User(String user){
        try {
            background = ImageIO.read(getClass().getResource("image2.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        splitPane = new JSplitPane(){
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D)g.create();
                g2d.drawImage(background,0,0,getWidth(),getHeight(),null);
//                super.paintComponent(g);
            }
        };
        setSize(new Dimension(800,600));
        user_list = new JList();
        LeftPanel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
//                g.setColor(Color.BLUE);
//                g.fillRect(0,0,getWidth(),getHeight());
                System.out.println(getWidth());
//                super.paintComponent(g);
            }
        };
        name = new JTextField(30);
        gender = new JTextField(30);
        age = new JTextField(30);
        details = new JTextField(30);
//        LeftPanel.add();
        RightPanel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
//                g.setColor(Color.YELLOW);
//                g.fillRect(0,0,getWidth(),getHeight());
                System.out.println(getWidth());
//                super.paintComponent(g);
            }
        };
        RightPanel.add(name);
        RightPanel.add(age);
        RightPanel.add(gender);
        RightPanel.add(details);
        LeftPanel.add(user_list);
        splitPane.setLeftComponent(LeftPanel);
        splitPane.setRightComponent(RightPanel);
        splitPane.setDividerSize(2);
        add(splitPane);
        splitPane.setDividerLocation(0.8);
        setResizable(false);
        setVisible(true);
        System.out.println(LeftPanel.getWidth());
        System.out.println(RightPanel.getWidth());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Edit_User("a");
        });
    }
}
