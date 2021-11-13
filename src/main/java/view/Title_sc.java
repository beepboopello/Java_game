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
import java.io.File;
import java.io.IOException;
import javax.swing.*;

/**
 *
 * @author khangiguess
 */
public class Title_sc extends JFrame //implements ActionListener 
{
 
    private Image_Panel background;
    private JPanel selectpanel;
    private JLabel labelgamemode;

    private final Font FontForLabel = new Font("Comic Sans MS", Font.PLAIN, 16);
    public Title_sc() throws IOException{
        
        background = new Image_Panel("view/bg.png"); // Thêm background từ file ảnh có sẵn - lớp image_panel - chưa hoàn thiện 
        background.setBackground(Color.white);
        this.setContentPane(background);
        
        selectpanel = new JPanel(); // Panel nằm bên trái rộng 500 pixel chứa các button của title screen
        selectpanel.setBounds(0, 0, 500, 720);
        selectpanel.setBackground(Color.lightGray);
        JButton start = new JButton("New game");
        this.add(selectpanel);
        
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
