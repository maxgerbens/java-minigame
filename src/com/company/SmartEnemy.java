package com.company;

import java.awt.*;

public class SmartEnemy extends GameObject {

    private Handler handler;
    private GameObject player;
    private HUD hud;


    public SmartEnemy(int x, int y, ID id, Handler handler){
        super(x, y, id);
        this.handler = handler;

        for(int i = 0; i < handler.object.size(); i++){
            if(handler.object.get(i).getId() == ID.player) {
                player = handler.object.get(i);
            }
        }

    }

    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 16, 16);
    }

    public void tick() {
        x += velX;
        y += velY;

        float diffx = x - player.getX() - 8;
        float diffy = y - player.getY() - 8;
        float speed = (float) -1.5;

        float distance = (float) Math.sqrt((x-player.getX())*(x-player.getX()) + (y-player.getY())*(y-player.getY()));

        velX = (float) ((speed/distance) * diffx);
        velY = (float) ((speed/distance) * diffy);

        if(y <= 0 || y >= Game.HEIGHT - 32 ) velY *= -1;
        if(x <= 0 || x >= Game.WIDTH - 16 ) velX *= -1;

        handler.addObject(new Trail((int)x, (int)y, ID.Trail, Color.green, 16, 16, 0.02f, handler   ));

    }

    public void render(Graphics g) {

        g.setColor(Color.green);
        g.fillRect((int)x, (int)y, 16, 16);
    }

}
