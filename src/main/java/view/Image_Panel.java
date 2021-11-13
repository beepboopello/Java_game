/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author khangiguess
 */
    public class Image_Panel extends JPanel{
        private final Image img;
        public Image_Panel(String img){
            ImageIcon bg = new ImageIcon(img);
            this.img = bg.getImage();
        }
        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(this.img, 1280, 720, this);
        }
    }