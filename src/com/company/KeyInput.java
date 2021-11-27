package com.company;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private Handler handler;
    private Boolean[] keyDown = new Boolean[4];
    private Game game;



    public KeyInput(Handler handler) {

        this.handler = handler;
        this.game = game;

        keyDown[0] = false;
        keyDown[1] = false;
        keyDown[2] = false;
        keyDown[3] = false;
    }


    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        for(int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getId() == ID.player){

                if(key == KeyEvent.VK_W) {tempObject.setVelY(-5); keyDown[0] = true;}
                if(key == KeyEvent.VK_S) {tempObject.setVelY(5); keyDown[1] = true;}
                if(key == KeyEvent.VK_D) {tempObject.setVelX(5); keyDown[2] = true;}
                if(key == KeyEvent.VK_A) {tempObject.setVelX(-5); keyDown[3] = true;}
            }
        }

        if(key == KeyEvent.VK_ESCAPE) {
            if(Game.gameState == Game.STATE.Game) {
                if (Game.paused) {
                    Game.paused = false;
                } else {
                    Game.paused = true;
                }
            }
        }
    }

    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        for(int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getId() == ID.player){

                if(key == KeyEvent.VK_W) keyDown[0] = false;//tempObject.setVelY(0);
                if(key == KeyEvent.VK_S) keyDown[1] = false;//tempObject.setVelY(0);
                if(key == KeyEvent.VK_D) keyDown[2] = false;//tempObject.setVelX(0);
                if(key == KeyEvent.VK_A) keyDown[3] = false;//tempObject.setVelX(0);

                //vertical movement
                if(!keyDown[0] && !keyDown[1]) tempObject.setVelY(0);
                //horizontal movement
                if(!keyDown[2] && !keyDown[3]) tempObject.setVelX(0);
            }
        }
    }
}
