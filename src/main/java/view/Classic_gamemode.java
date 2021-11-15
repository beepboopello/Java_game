package view;
import javax.swing.*;
import java.awt.*;

public class Classic_gamemode extends JFrame {
    private final Font font = new Font("Comic Sans MS", Font.PLAIN, 40);
    public Classic_gamemode(Title_sc title){
        // Setting cơ bản của frame chứa classic mode
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
        JButton [][]square = new JButton[3][3];
        enviPanel.setLayout(new GridLayout(3,3,0,0));
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++){
                JButton tmp = new JButton("X");
                tmp.setFont(font);
                tmp.addActionListener(event ->{
                    // Xử lý các nước đi của người chơi 
                });
                square[i][j] = tmp;
                enviPanel.add(square[i][j]);
            }
        add(enviPanel);

        //Panel thuộc không gian còn lại của frame chứa các button điều kiển ,etc...
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBounds(0, 400, 400, 200);
        bottomPanel.setLayout(null);
        JButton returnButton = new JButton("Return");
        returnButton.setBounds(50, 25, 100, 50);
        returnButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        returnButton.addActionListener(event ->{
            title.setVisible(true);
            this.dispose();
        });
        bottomPanel.add(returnButton);
        add(bottomPanel);
    }
}
