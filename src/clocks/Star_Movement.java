package clocks;

import game.Star;
import gui.Gui;

import java.util.ArrayList;

public class Star_Movement {

    public static ArrayList<Star> stars = new ArrayList<>();

    public Star_Movement() {
        for(int i = 0; i<100; i++) {
            stars.add(new Star((int) (Math.random() * Gui.width), (int) (Math.random() * Gui.height), (int) (Math.random
                    () * 2) + 1));
        }
    }

    public static void move(){
        for(int i = 0; i<100; i++) {
            stars.get(i).setY(stars.get(i).getY()+1);

            if(stars.get(i).getY() >= Gui.height){
                stars.get(i).setY(0);
            }

        }
    }

}
