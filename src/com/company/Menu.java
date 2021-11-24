package com.company;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Menu extends MouseAdapter  {

    private Game game;
    private Handler handler;
    private Random r = new Random();
    public Menu(Game game, Handler handler){
        this.game = game;
        this.handler = handler;
    }
    public void mousePressed(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();

        //Play button
        if(mouseOver(mx, my, 325, 200, 250, 64)){
            game.gameState = Game.STATE.Game;
            //Adds player to the game
            handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.player, handler));
            //Adds level 1 enemy to the game
            handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
        }

        //Quit button

        if(mouseOver(mx, my, 325, 400, 250, 64)) {
            System.exit(1);
        }
    }

    public void mouseReleased(MouseEvent e){

    }

    private boolean mouseOver(int mx, int my, int x, int y, int width, int height){
        if(mx > x && mx < x + width){
            if(my > y && my < y + height){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    };

    public void tick(){

    }

    public void render(Graphics g){
        g.setColor(Color.white);

        Font fnt = new Font("Arial", 1, 50);
        Font fnt2 = new Font("Arial", 1, 30);

        g.setFont(fnt);
        g.drawString("Menu", 400, 125);
        g.setFont(fnt2);

        g.drawRect(325, 200, 250, 64);
        g.drawString("Play", 420, 240);

        g.drawRect(325, 300, 250, 64);
        g.drawString("Help", 420, 340);

        g.drawRect(325, 400, 250, 64);
        g.drawString("Quit", 420, 440);

    }
}
