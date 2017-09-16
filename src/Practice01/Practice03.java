package Practice01;

import javax.swing.*;
import java.awt.*;

/**
 * Created by tatsuki on 2017/08/21.
 */
public class Practice03 extends JFrame{
    JList list;
    Practice03(){

        super("JList");
        setDefaultCloseOperation(3);
        setSize(new Dimension(500,500));
        setLocationRelativeTo(null);
        setResizable(false);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Practice03().setVisible(true);
        });
    }
}
