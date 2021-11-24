package view;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.*;

public class Highscore_JPanel extends JPanel {
    private final Font font = new Font("Comic Sans MS", Font.PLAIN, 18);
    private JButton[] playerinfo;
    public Highscore_JPanel() throws FileNotFoundException{

        setBounds(500, -15, 780, 720);
        setLayout(new GridLayout(10,1,0,0));

        playerinfo = new JButton[10];
        // Sử dụng 1 file text để lưu tên người chơi / điểm cao, đọc ra khi panel đóng / mở 
        Scanner in = new Scanner(new File("HighScore.txt"));
        for(int i=0;i<10;i++){
            String name = "";
            if(in.hasNextLine()){
                name = in.nextLine();
            }
            else{
                name = "";
            }
            JButton x = new JButton(name); // Những thông tin hiển thị trên bảng điểm 
            
            x.setFont(font);
            x.addActionListener(event ->{
                JOptionPane.showMessageDialog(null,"Insert player additional info"); // Hiển thị thêm thông tin về 1 người chơi qua 1 cửa sổ msg
                // Lấy thông tin người chơi từ file text, xử lý thành xâu -> thay cho xâu "Player additional info" như trên
            });
            playerinfo[i] = x;
            add(playerinfo[i]);
        }
    }
    public void update() throws FileNotFoundException{
        Scanner in = new Scanner(new File("HighScore.txt"));
        for(int i=0;i<10;i++){
            String name = "";
            if(in.hasNextLine()){
                name = in.nextLine();
            }
            else{
                name = "";
            }
            playerinfo[i].setText(name);
        }
    }
}
