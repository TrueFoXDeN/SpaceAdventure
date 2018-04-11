package chars;

import data.CustomMath;
import gui.Gui;

public class Asteroid {

    private int x, y, width, height, health, currenthealth, speed;
    private boolean isHit = false, containsIridium;
    private int value = 0;

    public Asteroid(){
        int ratio = CustomMath.limit((int)(Math.random()*200)+50, 50, 200);

        int rnd = (int)(Math.random()*10)+1;

        if(rnd % 5 == 0){
            containsIridium = true;
        }else{
            containsIridium = false;
        }

        width = ratio;
        height = ratio;

        health = (width * height) / 200;
        currenthealth = health;

        speed = (int)(Math.random()*6)+1;

        x = CustomMath.limit((int)(Math.random()* Gui.width), width+Player.width/2, Gui.width-width-Player.width/2);

        y = -height;

        if(containsIridium){
            value = (width * height) / 400;
        }

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getCurrenthealth() {
        return currenthealth;
    }

    public void setCurrenthealth(int currenthealth) {
        this.currenthealth = currenthealth;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isHit() {
        return isHit;
    }

    public void setHit(boolean hit) {
        isHit = hit;
    }

    public boolean containsIridium() {
        return containsIridium;
    }

    public void setContainsIridium(boolean containsIridium) {
        this.containsIridium = containsIridium;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
