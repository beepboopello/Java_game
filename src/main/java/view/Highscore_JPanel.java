package view;
import java.awt.*;
import javax.swing.*;

public class Highscore_JPanel extends JPanel {
    private final Font font = new Font("Comic Sans MS", Font.PLAIN, 18);
    private JButton[] playerinfo;
    public Highscore_JPanel(){

        setBounds(500, -15, 780, 720);
        setLayout(new GridLayout(10,1));

        playerinfo = new JButton[10];
        // Sử dụng 1 file text để lưu tên người chơi / điểm cao, đọc ra khi panel đóng / mở 
        for(int i=0;i<10;i++){
            JButton x = new JButton("Player "+String.valueOf(i+1)); //Những thông tin hiển thị trên bảng điểm 
            x.setFont(font);
            x.addActionListener(event ->{
                JOptionPane.showMessageDialog(null,"Insert player additional info"); // Hiển thị thêm thông tin về 1 người chơi qua 1 cửa sổ msg
                // Lấy thông tin người chơi từ file text, xử lý thành xâu -> thay cho xâu "Player additional info" như trên 
            });
            playerinfo[i] = x;
            add(playerinfo[i]);
        }
    }
}
