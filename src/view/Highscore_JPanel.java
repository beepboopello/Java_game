package view;
import controller.Sound;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import javax.swing.*;
import model.Player;

public class Highscore_JPanel extends JPanel {
    private final Font font = new Font("Comic Sans MS", Font.PLAIN, 18);
    private JButton[] playerinfo;
    public Highscore_JPanel() throws FileNotFoundException{

        setBounds(530, 90, 700, 550);
        setLayout(new GridLayout(11,1,0,0));
        
        JPanel top = new JPanel();
        top.setBounds(0,0,700,550);
        top.setOpaque(false);
        JLabel text_mode = new JLabel("Top 10 Player");
        text_mode.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        text_mode.setForeground(Color.white);
        top.add(text_mode);
        
        top.setOpaque(false);
        add(top);
        
        
        playerinfo = new JButton[10];
        // Sử dụng 1 file text để lưu tên người chơi / điểm cao, đọc ra khi panel đóng / mở 
        Scanner in = new Scanner(new File("HighScore.txt"));
        ArrayList<Player> ds = new ArrayList<>();
        while(in.hasNextLine()){
            ds.add(new Player(in.nextLine()));
        }
        int j=ds.size()-1;
        for(int i=0;i<10;i++){
            String name = "";
            if(j>=0){
                name = ds.get(j).toString();
            }
            else{
                name = "";
            }
            --j;
            JButton x = new JButton(name); // Những thông tin hiển thị trên bảng điểm 
            
            x.addActionListener(event ->{
                Sound.soundClick();
                JOptionPane.showMessageDialog(null,"Insert player additional info"); // Hiển thị thêm thông tin về 1 người chơi qua 1 cửa sổ msg
                // Lấy thông tin người chơi từ file text, xử lý thành xâu -> thay cho xâu "Player additional info" như trên
            });
            playerinfo[i] = x;
            
        }
        
        for(int i=0; i<10; ++i){
            playerinfo[i].setFont(font);
            add(playerinfo[i]);
        }
        setOpaque(false);
    }
    public void update() throws FileNotFoundException{
        Scanner in = new Scanner(new File("HighScore.txt"));
        ArrayList<Player> ds = new ArrayList<>();
        while(in.hasNextLine()){
            ds.add(new Player(in.nextLine()));
        }
        int j=ds.size()-1;
        for(int i=0;i<10;i++){
            String name = "";
            if(j>=0){
                name = ds.get(j).toString();
            }
            else{
                name = "";
            }
            --j;
            playerinfo[i].setText(name);
        }
    }
}
