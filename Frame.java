package myGame;

import javax.swing.*;

public class Frame {

    public static void main(String[] args){
        JFrame frame = new JFrame("Pac-Man");

        frame.add(new Board());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,430); // 30 more than the actual frame
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
    }
}
