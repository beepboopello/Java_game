package view;
import java.awt.*;
import javax.swing.*;
//import java.awt.event.ActionListener; // Bỏ dấu chú thích khi cần implement interface "ActionListener"

public class Title_sc extends JFrame //implements ActionListener 
{
    private Highscore_JPanel highscore;
    private Gamemode_JPanel gamemode;
    private Image_Panel_class background;
    public Title_sc(){
         // Thêm background từ file ảnh có sẵn - lớp image_panel - chưa hoàn thiện 
        background = new Image_Panel_class("view/bg.png");
        background.setBackground(Color.white);
        this.setContentPane(background);

         // Khởi tạo select pane chứa các lựa chọn của title screen
        this.add(new Select_JPanel(this));

        // Background của select pane 
        JPanel selectbackground = new JPanel(); 
        selectbackground.setBounds(0,0,500,720);
        selectbackground.setBackground(Color.lightGray);
        this.add(selectbackground);

        //Panel chứa thông tin điểm cao của top 10 người chơi - mặc định visible = false 
        highscore = new Highscore_JPanel();
        highscore.setVisible(false);
        this.add(highscore);

        gamemode = new Gamemode_JPanel(this);
        gamemode.setVisible(false);
        this.add(gamemode);

        //Setting cơ bản của frame
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
    //Thay đổi khả năng hiển thị của panel điểm cao 
    public void changeVisible_highscore(boolean val){
        highscore.setVisible(val);
    }
    public boolean getVisible_highscore(){
        return highscore.isVisible();
    }
    //Thay đổi khả năng hiển thị của panel gamemode
    public void changeVisible_gamemode(boolean val){
        gamemode.setVisible(val);
    }

    public boolean getVisible_gamemode(){
        return gamemode.isVisible();
    }
     
}
