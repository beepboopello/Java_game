/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author khangiguess
 */
    public class Image_Panel_class extends JPanel{ // Class không / chưa được sử dụng tới 
        private final Image img;
        public Image_Panel_class(String img) throws IOException{
            this.img = ImageIO.read(new File(img));
        }
        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(this.img, 0, 0, this);
        }
    }