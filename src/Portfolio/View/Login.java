package Portfolio.View;

import Portfolio.Control.ConnectDB;

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
    static BufferedImage background;
    Login(){
        super("Login");
        try {
            background = ImageIO.read(getClass().getResource("login.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setSize(new Dimension(550,350));
        start = System.nanoTime()/1000000;
        setContentPane(login = new JPanel(null){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D)g;
                timer = new Timer(10,(e) -> {
                    time = System.nanoTime()/1000000 - start;
                    alpha = time/300;
                    System.out.println(start);
                    System.out.println(alpha);
                    if (alpha >= 1){
                        System.out.println("a");
                        timer.stop();

                    }
                    g2d.setComposite(AlphaComposite.SrcOver.derive(1));
                    g2d.drawImage(background,0,0,550,350,null);
                });
                timer.start();
            }
        });
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        user = new JTextField();
        pass = new JPasswordField();
        user_label = new JLabel("User ID : ");
        pass_label = new JLabel("Password : ");
        user_label.setForeground(Color.WHITE);
        pass_label.setForeground(Color.WHITE);
        submit = new JButton("Sign In"){
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D)g;

                g2d.setComposite(AlphaComposite.SrcOver.derive((float) 0.8));
                super.paintComponent(g2d);
            }
        };
        submit.addActionListener((e) -> {
            name = user.getText();
            String passWord = String.valueOf(pass.getPassword());
            ResultSet resultSet = ConnectDB.createSQL("select user pass from USER where user = " + name + " and pass = " + passWord );
            try {
                ResultSetMetaData data = resultSet.getMetaData();
                if (data.getColumnCount() <= 0 || data.getColumnCount() >1){
                    JOptionPane.showMessageDialog(this,"UserID　もしくは PassWor　が正しくないようです。\n" +
                            "再度入力してください");
                }else {
                    this.setVisible(false);
                    new Index(name,true);
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        });
        reset = new JButton("Cancel"){
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D)g;
                g2d.setComposite(AlphaComposite.SrcOver.derive((float) 0.8));
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
        add(user_label);
        add(user);
        add(pass_label);
        add(pass);
        add(submit);
        add(reset);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            new Login();
        });
    }
}
