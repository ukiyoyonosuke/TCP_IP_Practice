package Portfolio.View;

import Portfolio.Control.ConnectDB;
import com.jgoodies.common.collect.ArrayListModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.ResultSet;

/**
 * Created by tatsuki on 2017/06/15.
 */
public class Edit_User extends JFrame{
    BufferedImage background;
    JList user_list;
    ArrayListModel<Record> elements;
    JSplitPane LeftsplitPane;
    JSplitPane Rightsplitpane;
    ResultSet resultSet;
    JSeparator separator;
    JLabel profile;
    JTextField name;
    JTextField age;
    JTextField gender;
    JTextField details;
    JPanel AccessLog;
    JPanel LeftPanel;
    JPanel RightPanel;
    Edit_User(String user){
        super(user);
        setLocationRelativeTo(null);
        elements = new ArrayListModel<Record>();
        try {
            resultSet = ConnectDB.createSQL("select * from user1");
            while (resultSet.next()){
                elements.add(new Record(resultSet.getBoolean(1),resultSet.getString(2)));
                System.out.println(resultSet.getBoolean(1));
                System.out.println(resultSet.getString(2));
                System.out.println(resultSet);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error");
            e.printStackTrace();
        }
        try {
            background = ImageIO.read(getClass().getResource("image2.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setContentPane(new JComponent() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D)g.create();
                g2d.drawImage(background,0,0,getWidth(),getHeight(),null);
//                super.paintComponent(g);
            }
        });
        getContentPane().setLayout(new BorderLayout(){
            @Override
            public void addLayoutComponent(Component comp, Object constraints) {
                if (constraints == null){
                    constraints = BorderLayout.CENTER;
                }
                super.addLayoutComponent(comp, constraints);
            }
        });
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        LeftsplitPane = new JSplitPane(){
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D)g.create();
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.5f));
                g2d.dispose();
//                g2d.drawImage(background,0,0,getWidth(),getHeight(),null);
//                super.paintComponent(g);
            }
        };
        setSize(new Dimension(800,600));
        Rightsplitpane = new JSplitPane(JSplitPane.VERTICAL_SPLIT){
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D)g.create();
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.5f));
                g2d.dispose();
            }
        };
        user_list = new JList(elements);
        LeftPanel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D)g.create();
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.5f));
                g2d.dispose();
//                g.setColor(Color.BLUE);
//                g.fillRect(0,0,getWidth(),getHeight());
//                System.out.println(getWidth());
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
                Graphics2D g2d = (Graphics2D)g.create();
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.5f));
                g2d.dispose();
//                g.setColor(Color.YELLOW);
//                g.fillRect(0,0,getWidth(),getHeight());
//                System.out.println(getWidth());
//                super.paintComponent(g);
            }
        };
        AccessLog = new JPanel();
        RightPanel.add(name);
        RightPanel.add(age);
        RightPanel.add(gender);
        RightPanel.add(details);
        Rightsplitpane.setLeftComponent(RightPanel);
        Rightsplitpane.setRightComponent(AccessLog);
        LeftPanel.add(user_list);
        user_list.setFixedCellWidth(530);
        user_list.setFixedCellHeight(50);
        LeftsplitPane.setDividerLocation(550);
        LeftsplitPane.setLeftComponent(LeftPanel);
        LeftsplitPane.setRightComponent(Rightsplitpane);
        LeftsplitPane.setDividerSize(2);
        add(LeftsplitPane);
        LeftsplitPane.setSize(new Dimension(550,600));
        user_list.setSize(new Dimension(550,600));
        System.out.println(LeftsplitPane.getWidth());
        System.out.println(LeftsplitPane.getDividerLocation());
        LeftsplitPane.setDividerLocation(0.5);
        System.out.println(LeftsplitPane.getDividerLocation());
        setResizable(false);
        setVisible(true);
//        System.out.println(LeftPanel.getWidth());
//        System.out.println(RightPanel.getWidth());
//        System.out.println(getWidth());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Edit_User("a");
        });
    }
    private class Record{
        private boolean is_Admin;
        private String name;
        private Record(boolean is_admin, String name) {
            is_Admin = is_admin;
            this.name = name;
        }

        public boolean isIs_Admin() {
            return is_Admin;
        }

        public void setIs_Admin(boolean is_Admin) {
            this.is_Admin = is_Admin;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return is_Admin + " : " + name;
        }
    }
    private class Update_List extends SwingWorker{

        @Override
        protected Object doInBackground() throws Exception {
            return null;
        }
    }
}
