package Portfolio.View;

import Portfolio.Control.ConnectDB;
import Portfolio.Control.Validation;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * Created by tatsuki on 2017/06/08.
 */
public class Login extends JFrame{
    private float alpha;
    private float start;
    private float time;
    private Timer timer;
    JTextField user;
    JPasswordField pass;
    JButton submit;
    JButton reset;
    JLabel user_label;
    JLabel pass_label;
    JPanel login;
    static String name;
    BufferedImage background;
    Login(){
        super("Login");
        try {
            background = ImageIO.read(getClass().getResource("login.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setSize(new Dimension(550,350));
        setContentPane(login = new JPanel(null){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D)g;
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,alpha));
                g2d.drawImage(background,0,0,550,350,null);
            }
        });
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        user = new JTextField(){
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D)g;
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.7f));
                super.paintComponent(g);
            }
        };
        pass = new JPasswordField(){
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D)g;
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.7f));
                super.paintComponent(g);
            }
        };
        user_label = new JLabel("User ID : ");
        pass_label = new JLabel("Password : ");
        user_label.setForeground(Color.WHITE);
        pass_label.setForeground(Color.WHITE);
        submit = new JButton("Sign In"){
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D)g;
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,alpha));
                super.paintComponent(g2d);
            }
        };
        submit.addActionListener((e) -> {
            name = user.getText();
            String passWord = String.valueOf(pass.getPassword());
//            ResultSet resultSet = null;
//            try {
//                resultSet = ConnectDB.createSQL("select user pass from USER1 where user = " + name + " and pass = " + passWord );
//            } catch (Exception e1) {
//                e1.printStackTrace();
//            }
            try {
                ResultSet resultSet = ConnectDB.createSQL("select name,pass from USER1 where name = '" + name + "' and pass = '" + passWord + "'");
                System.out.println(resultSet.getRow());
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            if(Validation.checkID(name,passWord)){
                System.out.println(true);
            }else {
                JOptionPane.showMessageDialog(this,"UserID　もしくは PassWordが正しくないようです。\n" +
                        "再度入力してください");
            }
        });
        reset = new JButton("Cancel"){
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D)g;
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,alpha));
                super.paintComponent(g);
            }
        };
        reset.addActionListener((e)-> {
            user.setText("");
            pass.setText("");
        });
        getContentPane().setLayout(null);
        user_label.setBounds(110,100,100,30);
        user.setBounds(180,100,220,30);
        pass_label.setBounds(100,140,100,30);
        pass.setBounds(180,140,220,30);
        submit.setBounds(190,200,70,30);
        reset.setBounds(290,200,70,30);
        start = System.nanoTime()/1000000;
        timer = new Timer(50,(e) -> {
            time = System.nanoTime()/1000000 - start;
            alpha = time/3000;
            System.out.println(time);
            System.out.println(alpha);
            if (alpha > 1){
                timer.stop();
                alpha = 1;
                add(user_label);
                add(user);
                add(pass_label);
                add(pass);
                add(submit);
                add(reset);
                repaint();
            }else {
                repaint();
            }
        });
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            new Login().setVisible(true);
        });
    }
}
