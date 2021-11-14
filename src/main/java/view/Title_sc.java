/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
//import java.awt.Image;
//import java.awt.Color;
//import java.awt.HeadlessException;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author khangiguess
 */
public class Title_sc extends JFrame //implements ActionListener 
{
 
    private Image_Panel_class background;
    private JPanel selectpanel;
    private JLabel labelgamemode;

    private final Font FontForLabel = new Font("Comic Sans MS", Font.PLAIN, 16);
    public Title_sc(){
        
        background = new Image_Panel_class("view/bg.png"); // Thêm background từ file ảnh có sẵn - lớp image_panel - chưa hoàn thiện 
        background.setBackground(Color.white);
        this.setContentPane(background);

        this.add(new Select_JPanel()); // Khởi tạo select pane chứa các lựa chọn của title screen

        JPanel selectbackground = new JPanel(); // Background của select pane 
        selectbackground.setBounds(0,0,500,720);
        selectbackground.setBackground(Color.lightGray);
        this.add(selectbackground);



        Dimension size = new Dimension(1280,720);
        setPreferredSize(size);
        setMaximumSize(size);
        setMinimumSize(size);
        setTitle("Tic Tac Toe");
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
          
    }
     
}
