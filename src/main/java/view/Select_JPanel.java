package view;

import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener; Bỏ dấu chú thích khi cần implement interface "ActionListener"
import java.awt.*;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Select_JPanel extends JPanel //implements ActionListener 
{
    private final Font font = new Font("Comic Sans MS", Font.PLAIN, 18);
    public Select_JPanel(Title_sc title){
        
        setBounds(100, 100, 300, 520); 
        setBackground(Color.lightGray);
        setLayout(new GridLayout(3,1,0,100));

        JButton start = new JButton("New game"); // Button tạo 1 panel bên phải chứa các lựa chọn của trò chơi 
        start.setFont(font);
        start.addActionListener(event -> {
            title.changeVisible_gamemode(!title.getVisible_gamemode());
            title.changeVisible_highscore(false);
        });
        add(start);

        JButton highscore = new JButton("High score"); // Button tạo 1 panel bên phải chứa thông tin điểm cao của các người chơi
        highscore.setFont(font);
        highscore.addActionListener( event ->{
            title.changeVisible_highscore(!title.getVisible_highscore()); // Thay đổi khả năng xuất hiện của panel 
            title.changeVisible_gamemode(false);
        });
        add(highscore);

        JButton quit = new JButton("Quit game"); // Button đóng game 
        quit.setFont(font);
        quit.addActionListener(event ->{
            title.dispose();
        });
        add(quit);
        setOpaque(false);
    }
    
}
