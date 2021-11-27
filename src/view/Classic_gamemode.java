package view;
import controller.Image_Panel_class;
import controller.Sound;
import javax.swing.*;
import java.awt.*;
import model.cell;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Classic_gamemode extends JFrame {
    private final Font font = new Font("Comic Sans MS", Font.PLAIN, 40); //font chữ
    
    private String current_val = "x"; //người đi trước
    
    private cell[][] arrcell; //mảng quản lý các ô đánh
    
    private int n, m, dkwin; //số hàng, số cột, số ô để thắng
    
    Title_sc title;
    
    private Image_Panel_class background;//ảnh background
    
    public Classic_gamemode(Title_sc title) throws IOException{
        
        // Setting cơ bản của frame chứa classic mode
        background = new Image_Panel_class("bg.png");
        background.setBackground(Color.white);
        this.setContentPane(background);
        
        n=3;
        m=3;
        dkwin=3;
        arrcell = new cell[n][m];
        this.title = title;
        
        Dimension size = new Dimension(400,600);
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
        enviPanel.setBounds(0, 0, 400, 400);
        enviPanel.setLayout(new GridLayout(3,3,0,0));

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                cell tmp = new cell(j, i);
                tmp.setFont(font);
                tmp.addActionListener(event ->{
                    
                    // Xử lý các nước đi của người chơi
                    if(tmp.isBlank()){
                        Sound.soundClick();
//                        System.out.println(tmp.getValue());
                        tmp.changeValue(current_val);
                        try {
                            checkwin(tmp);
                            update_current_val();
                        } catch (FileNotFoundException ex) {
                            System.out.println("file ko ton tai");
                        } catch (IOException ex) {
                            Logger.getLogger(Classic_gamemode.class.getName()).log(Level.SEVERE, null, ex);
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
        bottomPanel.setBounds(0, 400, 400, 100);
        bottomPanel.setLayout(null);
        JButton returnButton = new JButton("Return");
        returnButton.setBounds(125, 50, 150, 50);
        returnButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        returnButton.addActionListener(event ->{
            Sound.soundClick();
            title.playBGSound();
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
        }
        
        if(win == true){
            Sound.soundVictory();
            JOptionPane.showMessageDialog(null, current_val+" thang roi");
//            String winner_name = JOptionPane.showInputDialog(null, "Nhap ten nguoi thang cuoc", "Winner", JOptionPane.INFORMATION_MESSAGE);
//            if(winner_name!=null && !winner_name.equals("")){
//                layTen(winner_name);
//            }
//            else{
//                layTen("Player");
//            }
            Return();
            return;
        }
        
        for(int i=0; i<n; ++i){
            for(int j=0; j<m; ++j){
                if(arrcell[i][j].isBlank()){
                    return;
                }
            }
        }
        Sound.soundGameOver();
        JOptionPane.showMessageDialog(null, "het nuoc roi");
        Return();
        
    }
    
    private void Return(){
        title.setVisible(true);
        title.playBGSound();
        this.dispose();
    }
    
    private void layTen(String name) throws FileNotFoundException, IOException{
        FileWriter outt = new FileWriter("HighScore.txt", true);
        outt.write(name+"\n");
        outt.close();
        title.highscore.update();
    }
}
