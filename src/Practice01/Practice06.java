package Practice01;

import oracle.jvm.hotspot.jfr.JFR;
import org.bouncycastle.jcajce.util.JcaJceHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by tatsuki on 2017/09/16.
 */
public class Practice06 extends JFrame{
    JComponent component;
    int x;
    int y;
    int clickcount;
    Practice06(){
        setDefaultCloseOperation(3);
        setSize(500,500);
        x = y = 100;
        component = new JComponent() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D graphics2D = (Graphics2D)g.create();
                graphics2D.setColor(Color.green.brighter());
                graphics2D.fillOval(x-25,y-25,50,50);
                graphics2D.setColor(Color.BLUE);
                graphics2D.drawString(clickcount + "",100,400);
                graphics2D.dispose();
            }
        };
        component.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                super.mouseClicked(e);
                System.out.println("a");
                x = e.getX();
                y = e.getY();
//                synchronized (component){
//                    clickcount += e.getClickCount();
//                }
                counter();
                repaint();
                System.out.println(x + "  " + y + e.paramString());
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                x = e.getX();
                y = e.getY();
                repaint();
                System.out.println(x + "  " + y );
                JOptionPane.showMessageDialog(component,"a");
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                System.out.println(x + "  " + y + e.paramString() );
                x = e.getX();
                y = e.getY();
                repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                System.out.println(x + "  " + y );
                x = e.getX();
                y = e.getY();
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println(x + "  " + y );
                x = e.getX();
                y = e.getY();
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println(x + "  " + y );
                x = e.getX();
                y = e.getY();
                repaint();
            }
        });
        add(component);
        add(new JLabel("aaaaaaaaaaaaa"){
            @Override
            protected void paintComponent(Graphics g) {
                g.setColor(Color.green);
                super.paintComponent(g);
            }
        },BorderLayout.SOUTH);
        setVisible(true);
    }

    private synchronized void counter(){
        clickcount++;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Practice06());
    }
}
