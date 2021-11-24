package view;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
import javax.swing.*;
import java.awt.*;
import model.cell;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Custom_gamemode extends JFrame {
    private final Font font = new Font("Comic Sans MS", Font.PLAIN, 40);
    private String current_val = "x";
    private cell[][] arrcell;
    private int n, m, dkwin;
    Title_sc title;
    private Image_Panel_class background;
    public Custom_gamemode(Title_sc title) throws IOException{
        // Setting cơ bản của frame chứa classic mode
        background = new Image_Panel_class("bg.png");
        background.setBackground(Color.white);
        this.setContentPane(background);
        n=10;
        m=10;
        dkwin=5;
        arrcell = new cell[n][m];
        this.title = title;
        Dimension size = new Dimension(613,800);
        setPreferredSize(size);
        setMaximumSize(size);
        setMinimumSize(size);
        setTitle("Tic Tac Toe");
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        // Panel chứa 9 ô cho chế độ classic 
        JPanel enviPanel = new JPanel();
        enviPanel.setBounds(0, 0, 600, 600);
        enviPanel.setLayout(new GridLayout(n,m,0,0));

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                cell tmp = new cell(j, i);
                tmp.setFont(font);
                tmp.addActionListener(event ->{
                    // Xử lý các nước đi của người chơi
                    if(tmp.isBlank()){
//                        System.out.println(tmp.getValue());
                        tmp.changeValue(current_val);
                        update_current_val();
                        try {
                            checkwin(tmp);
                        } catch (IOException ex) {
                            Logger.getLogger(Custom_gamemode.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                arrcell[i][j] = tmp;
                enviPanel.add(arrcell[i][j]);
            }
        }
            
        add(enviPanel);

        //Panel thuộc không gian còn lại của frame chứa các button điều kiển ,etc...
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBounds(0, 600, 600, 200);
//        bottomPanel.setLayout(null);
        JButton returnButton = new JButton("Return");
//        returnButton.setBounds(50, 25, 100, 50);
        returnButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        returnButton.addActionListener(event ->{
            Return();
        });
        bottomPanel.add(returnButton);
        bottomPanel.setOpaque(false);
        add(bottomPanel);
    }
    
    private void update_current_val(){
        if(current_val.equals("x")){
            current_val="o";
        }
        else{
            current_val="x";
        }
    }
    
    private void checkwin(cell c) throws FileNotFoundException, IOException{
        
//        check hang ngang
        int cur_x = c.getIx(), cur_y = c.getIy();
        boolean win = false;
        int subx = cur_x, suby = cur_y;
        int countRow = 1;
        while(subx-1 >= 0 && arrcell[suby][subx-1].equals(c))
        {
            countRow++;
            subx--;
        }
        subx = cur_x;
        suby = cur_y;
        while(subx +1 <= m-1 && arrcell[suby][subx + 1].equals(c))
        {
            countRow ++;
            subx++;
        }
        if(countRow==dkwin){
            win = true;
            JOptionPane.showMessageDialog(null, "dm thang theo hang ngang roi");
        }
        
//        check hàng dọc
        subx = cur_x;
        suby = cur_y;
        countRow = 1;
        while(suby-1 >= 0 && arrcell[suby-1][subx].equals(c))
        {
            countRow++;
            suby--;
        }
        subx = cur_x;
        suby = cur_y;
        while(suby +1 <= n-1 && arrcell[suby+1][subx].equals(c))
        {
            countRow ++;
            suby++;
        }
        if(countRow==dkwin){
            win = true;
            JOptionPane.showMessageDialog(null, "dm thang theo hang doc roi");
        }
        
//        check theo hàng chéo l->r
        
        subx = cur_x;
        suby = cur_y;
        countRow = 1;
        while(suby-1 >= 0 && subx-1 >= 0 && arrcell[suby-1][subx-1].equals(c))
        {
            countRow++;
            suby--;
            subx--;
        }
        subx = cur_x;
        suby = cur_y;
        while(suby+1 <= n-1 && subx+1 <= m-1 && arrcell[suby+1][subx+1].equals(c))
        {
            countRow ++;
            suby++;
            subx++;
        }
        if(countRow==dkwin){
            win = true;
            JOptionPane.showMessageDialog(null, "dm thang theo hang cheo 1 roi");
        }
        
//        check theo hàng chéo l->r
        
        subx = cur_x;
        suby = cur_y;
        countRow = 1;
        while(suby-1 >= 0 && subx+1 <= m-1 && arrcell[suby-1][subx+1].equals(c))
        {
            countRow++;
            suby--;
            subx++;
        }
        subx = cur_x;
        suby = cur_y;
        while(suby+1 <= n-1 && subx-1 >= 0 && arrcell[suby+1][subx-1].equals(c))
        {
            countRow ++;
            suby++;
            subx--;
        }
        if(countRow==dkwin){
            win = true;
            JOptionPane.showMessageDialog(null, "dm thang theo hang cheo 2 roi");
        }
        
        if(win == true){
            String winner_name = JOptionPane.showInputDialog(null, "Nhap ten nguoi thang cuoc", "Winner", JOptionPane.INFORMATION_MESSAGE);
            layTen(winner_name);
            Return();
        }
        
        for(int i=0; i<n; ++i){
            for(int j=0; j<m; ++j){
                if(arrcell[i][j].isBlank()){
                    return;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "het nuoc roi");
        Return();
        
    }
    
    private void Return(){
        title.setVisible(true);
        this.dispose();
    }
    
    private void layTen(String name) throws FileNotFoundException, IOException{
        FileWriter outt = new FileWriter("HighScore.txt", true);
        outt.write(name+"\n");
        outt.close();
        title.highscore.update();
    }
}
