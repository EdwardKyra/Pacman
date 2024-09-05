package myGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Fireball {
    int x,y, dx,dy;
    Image img;
    boolean visible;


    public Fireball(int startX, int startY){
        x = startX;
        y = startY;
        ImageIcon newFireball = new ImageIcon("/Users/kyraedwards/Desktop/Game Design/Pacman3/Fireball 3.png");
        img = newFireball.getImage();
        visible = true;
    }

    public void move(){
        up();
        if (x > 600 ){
            visible = false;

        }
        if(y > 400){
            visible = false;
        }
    }

    public void up(){
        y = y + 2;
    }

    public void down(){
       y = y - 2;
    }

    public void left(){
       x = x - 2;
    }

    public void right(){
      x = x + 2;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public boolean getVisible(){
        return visible;
    }

    public Image getImg(){
        return img;
    }

    public Rectangle getBounds(){
    // fireball 41w 42h
        return new Rectangle(x,y, 41,21);
    }

}

