package myGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Board extends JPanel implements ActionListener {
    Player p;
    Image img;
    Timer time;
    Enemy en;
    Enemy en2;

    boolean lost = false;

    public Board(){
        p = new Player();
        addKeyListener(new AL());
        setFocusable(true);
        ImageIcon i = new ImageIcon("/Users/kyraedwards/Desktop/Game Design/Pacman3/board.png");
        img = i.getImage();
        time = new Timer(5, (ActionListener) this);
        time.start();

        en = new Enemy((p.x +500), 200,"/Users/kyraedwards/Desktop/Game Design/Pacman3/ghost1.png" );
        en2 = new Enemy(400,200,"/Users/kyraedwards/Desktop/Game Design/Pacman3/ghost2.png");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        checkCollisions();
        p.move();
        repaint();
        ArrayList fireballs = Player.getFireballs();
        for (int w = 0; w < fireballs.size(); w++) {
            Fireball m = (Fireball) fireballs.get(w);
            if (m.getVisible() == true) {
                m.move();
            } else {
            fireballs.remove(w);
            }
        }

    }

    public void paint(Graphics g){
        if (lost){
            System.exit(0);
        }
        // start character
        super.paint(g);
        Graphics2D g2g = (Graphics2D) g;
        g2g.drawImage(img,0,0,null);
        g2g.drawImage(p.getImage(),p.getX(),p.getY(),null);

        ArrayList fireballs = Player.getFireballs();
        for (int w =0; w < fireballs.size(); w++){
            Fireball m = (Fireball)fireballs.get(w);
            g2g.drawImage(m.getImg(),m.getX(),m.getY(), null);
        }
        g2g.setFont(font);
        g2g.setColor(Color.RED);
        g2g.drawString("Ammo left: " + p.ammo, 250,20);

        if (en.Alive() == true){
            g2g.drawImage(en.getImg(),en.getX(),en.getY(),null);
        }
        if (en2.Alive() == true){
            g2g.drawImage(en2.getImg(),en2.getX(),en2.getY(),null);
        }
    }

    private class AL extends KeyAdapter{
        public void keyPressed(KeyEvent e){
            p.keyPressed(e);
        }
    }

    static Font font = new Font("SanSerif", Font.BOLD,24);

    public void checkCollisions() {
        Rectangle r1 = en.getBounds();
        Rectangle r2 = en.getBounds();
        ArrayList fireballs = Player.getFireballs();
        for (int w = 0; w < fireballs.size(); w++) {
            Fireball m = (Fireball) fireballs.get(w);
            Rectangle m1 = m.getBounds();
            if (r1.intersects(m1) && en.Alive()){
                en.isAlive = false;
                m.visible = false;
            } else if (r2.intersects(m1) && en.Alive()) {
                en2.isAlive = false;
                m.visible = false;
            }
        }
        Rectangle d = p.getBounds();
        if (d.intersects(r1) || d.intersects(r2)){
            lost = true;
        }
    }
}


