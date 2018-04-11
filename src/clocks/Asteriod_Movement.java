package clocks;


import gui.Gui;

public class Asteriod_Movement {

    public static void move() {
        for (int i = 0; i < Asteroid_Creation.asteroids.size(); i++) {
            Asteroid_Creation.asteroids.get(i).setY(Asteroid_Creation.asteroids.get(i).getY() + Asteroid_Creation
                    .asteroids.get(i).getSpeed());

            if (Asteroid_Creation.asteroids.get(i).getY() > Gui.height) {
                Asteroid_Creation.asteroids.remove(i);
            }

        }
    }
}
