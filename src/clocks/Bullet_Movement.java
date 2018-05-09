package clocks;

import chars.Bullet;
import chars.Player;
import gui.Gui;

public class Bullet_Movement {

    public static void move() {
        for (int i = 0; i < Bullet_Creation.bullets.size(); i++) {
            Bullet_Creation.bullets.get(i).setY(Bullet_Creation.bullets.get(i).getY() - Player.speed);
            if (Bullet_Creation.bullets.get(i).getY() > Gui.height) {
                Bullet_Creation.bullets.remove(i);
            }

        }
    }
}
