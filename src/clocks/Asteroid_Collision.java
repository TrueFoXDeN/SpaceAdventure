package clocks;

import actions.Collision;
import chars.Asteroid;
import chars.Player;

public class Asteroid_Collision {

    public static void collide() {

        try {

            for (int i = 0; i < Asteroid_Creation.asteroids.size(); i++) {
                for (int j = 0; j < Bullet_Creation.bullets.size(); j++) {
                    if (Collision.cBulletAsteroid(Bullet_Creation.bullets.get(j), Asteroid_Creation.asteroids.get(i))) {
                        Asteroid_Creation.asteroids.get(i).setHit(true);
                        Bullet_Creation.bullets.remove(j);
                        Asteroid_Creation.asteroids.get(i).setCurrenthealth(Asteroid_Creation.asteroids.get(i)
                                .getCurrenthealth() - Player.damage);

                        if (Asteroid_Creation.asteroids.get(i).getCurrenthealth() <= 0) {
                            if (Asteroid_Creation.asteroids.get(i).containsIridium()) {
                                if (Player.iridium < 9999999999999L) {
                                    Player.iridium += Asteroid_Creation.asteroids.get(i).getValue();
                                } else {
                                    Player.iridium = 9999999999999L;
                                }
                            }
                            Asteroid_Creation.asteroids.remove(i);
                        }

                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Asteroid collision error");
        }

        try {
            for (int i = 0; i < Asteroid_Creation.asteroids.size(); i++) {
                if (Collision.cPlayerAsteroid(Asteroid_Creation.asteroids.get(i))) {
                    Player.isHit = true;
                    Player_Hit.start();
                    Asteroid_Creation.asteroids.remove(i);
                    Player.decrementHealth();
                    System.out.println(Player.health);
                }
            }
        } catch (Exception e) {
            System.out.println("Player hit error");
        }
    }
}
