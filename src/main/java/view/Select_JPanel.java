package view;

import javax.swing.*;
import javax.swing.event.AncestorListener;

import java.awt.*;

public class Select_JPanel extends JPanel //implements AncestorListener
{
    public Select_JPanel(){
        setBounds(100, 100, 300, 520);  
        setBackground(Color.lightGray);
        setLayout(new GridLayout(3,1,0,100));

        JButton start = new JButton("New game"); // Button tạo 1 panel bên phải chứa các lựa chọn của trò chơi 
        add(start);

        JButton highscore = new JButton("High score"); // Button tạo 1 panel bên phải chứa thông tin điểm cao của các người chơi (có thể cần sử dụng db)
        add(highscore);

        JButton quit = new JButton("Quit game"); // Button đóng game 
        add(quit);
        
    }
    
}
