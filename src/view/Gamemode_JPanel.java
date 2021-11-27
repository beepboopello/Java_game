package view;


import controller.Sound;
import java.awt.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Gamemode_JPanel extends JPanel {
    private final Font font = new Font("Comic Sans MS", Font.PLAIN, 20);
    public Gamemode_JPanel(Title_sc title){
        // Vị trí của panel 
        setBounds(500, 0, 780, 720);
        setLayout(null);

        // Label chỉ dẫn 
        JPanel top = new JPanel();
        top.setBounds(0,100,780,100);
        top.setOpaque(false);
        JLabel text_mode = new JLabel("Select your game mode");
        text_mode.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        text_mode.setForeground(Color.white);
        top.add(text_mode);
        add(top);
        
        // Button chọn chế độ classic 3*3 - được đặt vào 1 panel 
        JPanel mode_classic = new JPanel();
        mode_classic.setBounds(125, 200, 200, 400);
        JButton but_classic = new JButton("Classic");
        but_classic.setFont(font);
        // Tạo frame mới chứa mode classic + ẩn frame chính khi được click 
        but_classic.addActionListener(event ->{
            Sound.soundClick();
            title.stopBGSound();
            // Tạo frame chứa chế độ classic
            title.setVisible(false);
            try {
                new Classic_gamemode(title);
            } catch (IOException ex) {
                Logger.getLogger(Gamemode_JPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        mode_classic.setLayout(new GridLayout(1,1));
        mode_classic.add(but_classic);
        add(mode_classic);

        // Button chọn chế độ classic 3*3 - được đặt vào 1 panel 
        JPanel mode_custom = new JPanel();
        mode_custom.setBounds(455, 200, 200, 400);
        JButton but_custom = new JButton("Custom");
        but_custom.setFont(font);
        but_custom.addActionListener(event ->{
            Sound.soundClick();
            title.stopBGSound();
            // Tạo frame chứa chế độ custom
            title.setVisible(false);
            try {
                new Custom_gamemode(title);
            } catch (IOException ex) {
                Logger.getLogger(Gamemode_JPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        mode_custom.setLayout(new GridLayout(1,1));
        mode_custom.add(but_custom);
        add(mode_custom);
        setOpaque(false);
    }
}
