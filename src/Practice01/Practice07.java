package Practice01;

import javax.swing.*;
import java.awt.*;

/**
 * Created by tatsuki on 2017/09/16.
 */
public class Practice07 extends JFrame{
    JButton[] buttons;
    JPanel panel;
    Practice07(){
        setDefaultCloseOperation(3);
        setSize(500,500);
        buttons = new JButton[4];
        add(panel = new JPanel());
        for (int i = 0; i < 4; i++){
            buttons[i] = new JButton("" + i){
                @Override
                protected void paintComponent(Graphics g) {
                    if(isSelected()){
//                        setBackground(Color.BLUE);
                    }
                    if(isFocused()){
                        setBackground(Color.CYAN);
                        setForeground(Color.green);
                        System.out.println("a");
                    }
                    super.paintComponent(g);
                }
            };
            int a = 3-i;
            buttons[i].addActionListener((e) -> buttons[a].grabFocus());
            panel.add(buttons[i]);
        }
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Practice07());
    }
}
