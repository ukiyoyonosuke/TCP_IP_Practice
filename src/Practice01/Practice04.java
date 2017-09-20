package Practice01;

import com.intellij.util.ui.JBImageIcon;
import com.jgoodies.common.collect.ArrayListModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.jar.JarFile;

/**
 * Created by tatsuki on 2017/09/15.
 */
public class Practice04 extends JFrame {
    ArrayListModel<String> list;
    JList jList;
    BufferedImage image;
    Practice04(){
        setDefaultCloseOperation(3);
        setSize(500,500);
        try {
            image = ImageIO.read(getClass().getResource("trash.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        list = new ArrayListModel<String>(Arrays.asList("a","b","c","d","e"));
        jList = new JList(list);
        add(jList);
        jList.setCellRenderer(new CellRenderer());
        add(new JCheckBox(),BorderLayout.SOUTH);
        jList.addListSelectionListener((e) -> System.out.println(e));
        setVisible(true);
    }
    private class CellRenderer extends JPanel implements ListCellRenderer{
        JLabel label;
        JButton trash;
        public CellRenderer(){
            setOpaque(true);
            setPreferredSize(new Dimension(500,80));
            label = new JLabel();
            label.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("a");
                }
            });
            add(new JCheckBox());
            add(label);
//            System.out.println(image);
            trash = new JButton(new ImageIcon(image)){
                @Override
                protected void paintComponent(Graphics g) {
                    if (isSelected()){
                        setBackground(Color.BLUE);
                    }
                    super.paintComponent(g);
                }
            };
            add(trash);
            trash.addActionListener((e) -> System.out.println(e));
            trash.setPreferredSize(new Dimension(68,50));
        }

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            label.setText(value.toString());
            if (isSelected){
                setBackground(Color.blue);
//                grabFocus();
                trash.grabFocus();
//                setRequestFocusEnabled(true);
                System.out.println(value);
            }else {
                setBackground(Color.white);
            }
            return this;
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Practice04());
    }
}
