package chars;

import game.Gamestate;
import game.Gamestate_e;
import gui.Gui;

public class Player {

    public static int x, y, width = 56, height = 152;
    public static boolean isShooting = false, isHit = false;
    public static int health = 3;
    public static long iridium = 0L;
    public static int damage = 25, speed = 20, iridiumCollect = 400;

    public Player() {
        x = Gui.width / 2 - width / 2;
        y = Gui.height - 200;
    }

    public static void move(int xMouse) {

        if (Gamestate.state == Gamestate_e.ingame) {
            if (xMouse >= width && xMouse <= Gui.width - width) {
                x = xMouse - width / 2;
            }
        }


    }

    public static void decrementHealth() {
        if (health > 1) {
            health--;
        } else {
            health = 3;
        }
    }

}
