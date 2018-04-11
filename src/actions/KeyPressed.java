package actions;

import game.Gamestate;
import game.Gamestate_e;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;


public class KeyPressed implements EventHandler<KeyEvent> {

    @Override
    public void handle(KeyEvent e) {

        switch (e.getCode()) {


            case ESCAPE:
                if (Gamestate.state == Gamestate_e.pause) {
                    Gamestate.state = Gamestate_e.ingame;
                } else {
                    Gamestate.state = Gamestate_e.pause;
                }
                break;
        }

    }
}
