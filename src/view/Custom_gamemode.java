package view;
import controller.Image_Panel_class;
import controller.Sound;
import javax.swing.*;
import java.awt.*;
import model.cell;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import java.util.Timer;
import java.util.TimerTask;

public class Custom_gamemode extends JFrame {
    
    private final Font font = new Font("Comic Sans MS", Font.PLAIN, 19);
    private String current_val = "x";
    private cell[][] arrcell;
    private int n, m, dkwin, sizeBlank=45;
    Title_sc title;
    private Image_Panel_class background;
    
    private int time=0;
    private Timer timer;
    
    private JLabel timeLabel = new JLabel("Time: 00:00");
    
    public Custom_gamemode(Title_sc title) throws IOException{
        
        // Setting cơ bản của frame chứa classic mode
        background = new Image_Panel_class("bg.png");
        background.setBackground(Color.white);
        this.setContentPane(background);
        
        n=10;
        m=15;
        dkwin=5;
        arrcell = new cell[n][m];
        
        this.title = title;
        
        Dimension size = new Dimension(m*sizeBlank+100, n*sizeBlank+200+50);
        setPreferredSize(size);
        setMaximumSize(size);
        setMinimumSize(size);
        setTitle("custom mode");
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        // Panel chứa 9 ô cho chế độ classic 
        JPanel enviPanel = new JPanel();
        enviPanel.setBounds(40, 25, m*sizeBlank, n*sizeBlank);
        enviPanel.setLayout(new GridLayout(n,m,0,0));
        enviPanel.setOpaque(false);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                cell tmp = new cell(j, i);
                tmp.setFont(font);
                tmp.addActionListener(event ->{
                    Sound.soundClick();
                    // Xử lý các nước đi của người chơi
                    if(tmp.isBlank()){
//                        System.out.println(tmp.getValue());
                        tmp.changeValue(current_val);
                        try {
                            checkwin(tmp);
                            update_current_val();
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
        bottomPanel.setBounds(0, n*sizeBlank, m*sizeBlank+100, 200);
        bottomPanel.setLayout(null);
        
        
        JButton returnButton = new JButton("Return");
        returnButton.setBounds(40, 75, 150, 50);
        returnButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        returnButton.addActionListener(event ->{
            timer.cancel();
            Sound.soundClick();
            title.playBGSound();
            Return();
        });
        bottomPanel.add(returnButton);
        bottomPanel.setOpaque(false);
        
//        timeLabel.setBounds((m*sizeBlank+100)/2-28, 130, 150, 50);
        timeLabel.setBounds(40+m*sizeBlank-110, 75, 150, 50);
        timeLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        timeLabel.setForeground(Color.white);
        //Đếm ngược
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                time++;
                String value = String.format("%02d", time / 60) + ":" + String.format("%02d", time % 60);
                timeLabel.setText("Time: "+value);
            }
        }, 1000, 1000);
        
        bottomPanel.add(timeLabel);
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
            timer.cancel();
            Sound.soundVictory();
            win = true;
            JOptionPane.showMessageDialog(null, current_val+" thang roi");
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
            timer.cancel();
            Sound.soundVictory();
            win = true;
            JOptionPane.showMessageDialog(null, current_val+" thang roi");
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
            timer.cancel();
            Sound.soundVictory();
            win = true;
            JOptionPane.showMessageDialog(null, current_val+" thang roi");
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
            timer.cancel();
            Sound.soundVictory();
            win = true;
            JOptionPane.showMessageDialog(null, current_val+" thang roi");
        }
        
        if(win == true){
            String winner_name = JOptionPane.showInputDialog(null, "Nhap ten nguoi thang cuoc", "Winner", JOptionPane.INFORMATION_MESSAGE);
            if(winner_name!=null && !winner_name.equals("")){
                layTen(winner_name+" "+String.format("%02d", time / 60) + ":" + String.format("%02d", time % 60)+" "+ java.time.LocalDate.now());
            }
            else{
                layTen("Player"+" "+String.format("%02d", time / 60) + ":" + String.format("%02d", time % 60) +" "+ java.time.LocalDate.now());
            }
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
        timer.cancel();
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
