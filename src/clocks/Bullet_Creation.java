package clocks;

import chars.Bullet;
import chars.Player;
import game.Gamestate;
import game.Gamestate_e;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Bullet_Creation {

    public static ArrayList<Bullet> bullets = new ArrayList<>();
    public static Timer timer;

    public Bullet_Creation(){
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(Gamestate.state == Gamestate_e.ingame){
                    if(Player.isShooting){
                        bullets.add(new Bullet(Player.x + Player.width/2-8, Player.y - 40, 15 , 50, 20));
                    }
                }
            }
        },200,200);
    }

}
