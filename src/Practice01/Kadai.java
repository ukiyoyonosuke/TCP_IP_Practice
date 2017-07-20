package Practice01;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * Created by tatsuki on 2017/03/03.
 */
public class Kadai extends JFrame implements ActionListener,FocusListener,KeyListener{
    private int number;
    private JButton start;
    private JTextField input;
    private JTextArea result;
    private int answer;
    private int n = 5;
//    private Rectangle position;
    private String answers = "";
    Kadai(){
        super("数当てゲーム");
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
//        position = this.getGraphicsConfiguration().getBounds();
//        this.setLocation(position.x + position.width  / 2 - this.getSize().width  / 2, position.y + position.height / 2 - this.getSize().height / 2);
        setResizable(false);
        setSize(new Dimension(500,500));
        start = new JButton("Start");
        start.setPreferredSize(new Dimension(500,35));
        start.addActionListener(this);
        add(start,BorderLayout.SOUTH);
        input = new JTextField("");
        input.setPreferredSize(new Dimension(500,75));
        input.setFont(new Font("MS ゴッシク",Font.PLAIN,50));
        input.addFocusListener(this);
        add(input,BorderLayout.NORTH);
        result = new JTextArea("\n　　　　　　　　Startボタンを押してゲームを開始してください"){
        };
        add(result);
        result.setEditable(false);
        input.addKeyListener(this);
        JOptionPane.showMessageDialog(this,
                "　　　　　                         数当てゲームへようこそ\n\n" +
                         "このゲームは1~100までの数字の中からランダムに選ばれた1つの数字を当てるゲームです。\n" +
                         "                チャンスは5回までで、不正解のたびにヒントが1つ出されます。\n\n" +
                         "　　　　　あなたの推理と勘を頼りに正解の数字に辿り着いてください。");
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Kadai().setVisible(true);
            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent e) {
//        input.setText("                              1~100の数値を入力してください。");
        if(n == 5){
            result.setText("\n                                1~100の数値を入力してください。");
            number = (int)(Math.random()*100)+1;
            n = 0;
            answers = "";
        }else {
            if(JOptionPane.showConfirmDialog(this, "ゲームを初めからやり直しますか？", "確認", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                n = 0;
                answers = "";
                number = (int)(Math.random()*100)+1;
                result.setText("\n                                1~100の数値を入力してください。");
            }
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
//        if (input.getText().equals("                              1~100の数値を入力してください。")){
//            input.setText("");
//        }
    }

    @Override
    public void focusLost(FocusEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode()==KeyEvent.VK_ENTER) {
            if (n <= 4) {
                if (input.getText().matches("[0-9]+")) {
                    answer = Integer.parseInt(input.getText());
                    if (answer <= 100 && answer >= 0) {
                        if (JOptionPane.showConfirmDialog(this, "あなたの解答は" + answer + "でよろしいですか？", "確認", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
//                        result.append("あなたの解答：" + answer + "\n");
                            if (result.getText().equals("\n                                1~100の数値を入力してください。"))
                                result.setText("");
                                answers += "あなたの解答：" + answer + "\n";
                                n++;
                            if (answer == number) {
                                JOptionPane.showMessageDialog(this, "\n正解！");
                                result.append((n + 1) + "回目に正解しました。");
                                result.append(answers);
                                result.append("正解：" + number + "\n");
                                result.append("\n                       ゲームをやり直すにはStartボタンを押してください。");
                                n = 5;
                            } else {
                                if (n == 5) {
                                    JOptionPane.showMessageDialog(this, "\n正解は" + number + "でした。");
                                    result.append(answers);
                                    result.append("正解：" + number + "\n");
                                    result.append("\n                ゲームをやり直すにはStartボタンを押してください。");
                                } else {
                                    if (number > answer) {
                                        JOptionPane.showMessageDialog(this, "違います。\n" + "ヒント：" + answer + "より上の数です。\n");
//                                    result.append("ヒント：" + answer + "より上の数です。\n");
                                        answers += "ヒント：" + answer + "より上の数です。\n";
                                    } else {
                                        JOptionPane.showMessageDialog(this, "違います。\n" + "ヒント：" + answer + "より下の数です。\n");
//                                    result.append("ヒント：" + answer + "より下の数です。\n");
                                        answers += "ヒント：" + answer + "よりの数です。\n";
                                    }
                                }
                            }

                        }
                        input.setText("");
                    } else {
                        JOptionPane.showMessageDialog(this, "1~100の数値を入力してください。");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "数値を入力してください。");
                    input.setText("");
                }
            }else {
                JOptionPane.showMessageDialog(this, "Startボタンを押してください。");
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
