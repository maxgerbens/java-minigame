package com.company;

import java.awt.*;

public class HUD {

    public static int HEALTH = 100;
    private int greenValue = 255;

    private int score = 0;
    private int level = 1;
    private int speed = (int) -1.5;
    public int getSpeed(){
        final int speed = this.speed;
        return speed;
    }
    public int setSpeed(){
        return speed = (int) (this.speed -0.5);
    }

    public void tick(){
        HEALTH = Game.clamp(HEALTH, 0, 100);
        greenValue = Game.clamp(greenValue, 0, 255);
        greenValue = HEALTH * 2;
        if(HEALTH == 0){
            System.exit(1);
        }

        score++;

    }

    public void render(Graphics g){
        g.setColor(Color.gray);
        g.fillRect(15, 15, 200, 32);
        g.setColor(new Color(150, greenValue, 0));
        g.fillRect(15, 15, HEALTH * 2, 32);
        g.setColor(Color.white);
        g.drawRect(15, 15, 200, 32);

        g.drawString("Score: " + score, 15, 64);
        g.drawString("Level: " + level, 15, 80);
        g.drawString("Health: " + HEALTH, 15, 96);
        g.drawString("Next Level: " + (level + 1), 15, 112);
    }

    public void score(int score){
        this.score = score;
    }

    public int getScore(){
        return score;
    }
    public int getLevel(){
        return level;
    }
    public void setLevel(int level){
        this.level = level;
    }
}
