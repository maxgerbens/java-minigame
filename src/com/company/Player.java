package com.company;

import java.awt.*;
import java.util.Random;

public class Player extends GameObject {

    Random r = new Random();
    Handler handler;
    public Player(int x, int y, ID id, Handler handler){
        super(x,y,id);
        this.handler = handler;
    }


    public Rectangle getBounds(){
        return new Rectangle((int) x, (int) y, 32, 32);
    }

    public void tick() {
        x += velX;
        y += velY;

        x = Game.clamp((int) x, 0, Game.WIDTH - 48);
        y = Game.clamp((int) y, 0, Game.HEIGHT - 72);
        handler.addObject(new Trail((int)x,(int) y, ID.Trail, Color.blue, 32, 32, 0.08f, handler));


        collision();
    }

    private void collision(){
        for(int i = 0; i < handler.object.size(); i++){

            GameObject tempObject = handler.object.get(i);

            if(tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy || tempObject.getId() == ID.SmartEnemy || tempObject.getId() == ID.BossEnemyBullet || tempObject.getId() == ID.BossEnemyBullet) {
                if(getBounds().intersects(tempObject.getBounds())){
                    HUD.HEALTH -= 2;
                }
            }
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect((int)x, (int) y, 32, 32);
    }


}
