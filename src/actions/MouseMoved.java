package actions;

import chars.Player;
import gui.Gui;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;


public class MouseMoved implements EventHandler<MouseEvent>{

    @Override
    public void handle(MouseEvent e) {

        Player.move((int)e.getX());

        for(int i = 0; i< Gui.buttons.length; i++){
            if(Collision.cButton(Gui.buttons[i], (int) e.getX(), (int)e.getY())){
                Gui.buttons[i].setHover(true);
            }else{
                Gui.buttons[i].setHover(false);
            }
        }

        for(int i = 0; i< Gui.buttons_angled.length; i++){
            if(Collision.cButton_angled(Gui.buttons_angled[i], (int) e.getX(), (int)e.getY())){
                Gui.buttons_angled[i].setHover(true);
            }else{
                Gui.buttons_angled[i].setHover(false);
            }
        }

    }
}
