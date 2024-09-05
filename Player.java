package myGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Player {
int x, dx, y, dy;
int ammo = 10;
Image still;
    ImageIcon r = new ImageIcon("/Users/kyraedwards/Desktop/Game Design/Pacman3/right.png");
    ImageIcon l = new ImageIcon("/Users/kyraedwards/Desktop/Game Design/Pacman3/left.png");
    ImageIcon u = new ImageIcon("/Users/kyraedwards/Desktop/Game Design/Pacman3/up.png");
    ImageIcon d = new ImageIcon("/Users/kyraedwards/Desktop/Game Design/Pacman3/down.png");

    static ArrayList fireballs;

public Player() {
    still = r.getImage();
    still = l.getImage();
    still = u.getImage();
    still = d.getImage();
    x = 0;
    y=0;
    fireballs = new ArrayList();
    }

    public void move(){
    x = x + dx;
    y = y + dy;

        if (x < 0 ) {
            dx = 0;
            x= 0;
        } else if (x > 550){
            dx = 0;
            x = 550;
        }
        if (y < 0){
            dy = 0;
            y = 0;
        } else if (y > 350){
            dy = 0;
            y = 350;
        }
    }

    public void up(){
        dy = -1;
        dx = 0;
    }

    public void down(){
        dy = 1;
        dx = 0;
    }

    public void left(){
        dx = -1;
        dy = 0;
    }

    public void right(){
        dx = 1;
        dy =0;
    }

    public int getX() {
        return x;
    }

    public int getY(){
        return y;
    }

    public int getDx(){
        return dx;
    }

    public Image getImage(){
        return still;
    }

    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_UP){
            up();
            still = u.getImage();
        }
        if (key == KeyEvent.VK_DOWN){
            down();
            still = d.getImage();
        }
        if (key == KeyEvent.VK_RIGHT){
            right();
            still = r.getImage();
        }
        if (key == KeyEvent.VK_LEFT){
            left();
            still = l.getImage();
        }
        if (key == KeyEvent.VK_SPACE){
            fire();
        }
    }

    // shoot fireballs placement
    public void fire() {
        if (ammo > 0) {
        ammo --;
            Fireball z = new Fireball((x + 45/2), (y + 20/2)); // get current position
            fireballs.add(z);
        }
    }

    public static  ArrayList getFireballs(){
        return fireballs;
    }

    public Rectangle getBounds(){
        // player 94w 100h
        return new Rectangle(x,y, 94,100);
    }

}

