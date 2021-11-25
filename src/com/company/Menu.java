package com.company;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Menu extends MouseAdapter  {

    private Game game;
    private Handler handler;
    private Random r = new Random();
    private HUD hud;
    public Menu(Game game, Handler handler, HUD hud){
        this.game = game;
        this.handler = handler;
        this.hud = hud;
    }


    public void mousePressed(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();

        //Play button

        if(game.gameState == Game.STATE.Menu) {

            if (mouseOver(mx, my, 325, 200, 250, 64)) {
                handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.player, handler));

                game.gameState = Game.STATE.Game;
                //Adds player to the game
                handler.clearEnemies();
                //Adds level 1 enemy to the game
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
            }

            //Help button
            if (mouseOver(mx, my, 325, 300, 250, 64)) {
                game.gameState = Game.STATE.Help;
            }
            //Quit button
            else if (mouseOver(mx, my, 325, 400, 250, 64)) {
                System.exit(1);
            }
        }

        //Back button
        if(game.gameState == Game.STATE.Help){
            if(mouseOver(mx, my, 325, 400, 250, 64)){
                game.gameState = Game.STATE.Menu;
                return;
            }
        }

        if(game.gameState == Game.STATE.End){
            if(mouseOver(mx, my, 325, 400, 250, 64)) {
                hud.setLevel(0);
                hud.setScore(0);
                handler.clearEnemies();
                game.gameState = Game.STATE.Game;
                handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.player, handler));
                return;
            }

            if(mouseOver(mx, my, 325, 500, 250, 64)){
                hud.setLevel(0);
                hud.setScore(0);
                handler.clearEnemies();
                game.gameState = Game.STATE.Menu;
                return;
            }
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



        if(game.gameState == Game.STATE.Menu) {

            g.setColor(Color.white);

            Font fnt2 = new Font("Arial", 1, 30);

            g.setFont(fnt2);

            g.drawRect(325, 200, 250, 64);
            g.drawString("Play", 420, 240);

            g.drawRect(325, 300, 250, 64);
            g.drawString("Help", 420, 340);

            g.drawRect(325, 400, 250, 64);
            g.drawString("Quit", 420, 440);
        } else if(game.gameState == Game.STATE.Help){
            g.setColor(Color.white);
            Font fnt = new Font("Arial", 1, 50);
            Font fnt2 = new Font("Arial", 1, 30);

            g.setFont(fnt);
            g.drawString("Help", 400, 125);

            g.setFont(fnt2);
            g.drawString("Use WASD keys to move your player and dodge enemies.", 40, 300);
            g.drawRect(325, 400, 250, 64);
            g.drawString("Back", 420, 440);

        } else if(game.gameState == Game.STATE.End){

            g.setColor(Color.white);
            Font fnt = new Font("Arial", 1, 50);
            Font fnt2 = new Font("Arial", 1, 30);

            g.setFont(fnt);
            g.drawString("Game Over", 325, 125);

            g.setFont(fnt2);
            g.drawString("You lost with a score of:", 275, 300);
            g.drawString("" + hud.getScore(), 425, 350);
            g.drawRect(325, 400, 250, 64);
            g.drawString("Try Again", 385, 442);
            g.drawRect(325, 500, 250, 64);
            g.drawString("Menu", 385, 542);

        }

    }
}
