package myGame;

import javax.swing.*;
import java.awt.*;

public class Enemy {

    Image img ;
    int x, dx, y, dy;
    boolean isAlive = true;

    public Enemy (int startX, int startY, String location){
        x = startX;
        y = startY;
        ImageIcon l = new ImageIcon(location);
        img = l.getImage();
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public boolean Alive(){
        return isAlive;
    }

    public Image getImg(){
        return img;
    }

    public void move(int dx){
        x = x - dx;
    }

    public Rectangle getBounds(){
        // ghost 46w 51h
        return new Rectangle(x,y, 46,51);
    }

}


