package com.company;

import java.util.Random;

public class Spawn {

    private final Handler handler;
    private final HUD hud;
    private final Random r = new Random();

    private int scoreKeep = 0;

    public Spawn(Handler handler, HUD hud){
        this.handler = handler;
        this.hud = hud;
    }

    public void tick(){
        scoreKeep++;

        if(scoreKeep >= 250){
            scoreKeep = 0;
            hud.setLevel(hud.getLevel() + 1);

            if(hud.getLevel() == 2)
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
            else if (hud.getLevel() == 3){
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
            } else if(hud.getLevel() == 4) {
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
            } else if(hud.getLevel() == 5) {
                handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SmartEnemy, handler));
            } else if(hud.getLevel() == 6){
                handler.addObject(new BossEnemy((Game.WIDTH / 2) -48 , -120, ID.BossEnemy, handler));
            } else if(HUD.HEALTH == 0) {
                System.exit(1);
            }
        }
    }
}
