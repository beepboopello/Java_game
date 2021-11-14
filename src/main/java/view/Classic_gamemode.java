package view;

import javax.swing.*;
import java.awt.*;

public class Classic_gamemode extends JFrame {
    private final Font font = new Font("Comic Sans MS", Font.PLAIN, 40);
    public Classic_gamemode(Title_sc title){
        // Setting cơ bản của frame chứa classic mode
        Dimension size = new Dimension(600,900);
        setPreferredSize(size);
        setMaximumSize(size);
        setMinimumSize(size);
        setTitle("Tic Tac Toe");
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        JPanel enviPanel = new JPanel();
        enviPanel.setBounds(0, 0, 600, 600);
        enviPanel.setBackground(Color.BLUE);
        JButton [][]square = new JButton[3][3];
        enviPanel.setLayout(new GridLayout(3,3,0,0));
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++){
                JButton tmp = new JButton("X");
                tmp.setFont(font);
                square[i][j] = tmp;
                enviPanel.add(square[i][j]);
            }
        add(enviPanel);
    }
}
