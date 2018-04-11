package draw;

import chars.Asteroid;
import chars.Bullet;
import chars.Player;
import clocks.Asteroid_Creation;
import clocks.Bullet_Creation;
import clocks.Star_Movement;
import game.Gamestate;
import game.Gamestate_e;
import gui.Button;
import gui.Button_angled;
import gui.Gui;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.text.DecimalFormat;

public class Draw_Main {

    private DecimalFormat df = new DecimalFormat("###,###,###");
    private Text text = new Text();

    public void draw(GraphicsContext g) {
        g.setFill(Color.BLACK);
        g.fillRect(0, 0, Gui.width, Gui.height);

        g.setFill(Color.WHITE);
        for (int i = 0; i < Star_Movement.stars.size(); i++) {
            g.fillOval(Star_Movement.stars.get(i).getX(), Star_Movement.stars.get(i).getY(), Star_Movement.stars.get
                    (i).getSize(), Star_Movement.stars.get(i).getSize());

        }

        if (!Player.isHit) {
            g.drawImage(IL.iplayer, Player.x - 5, Player.y - 5, Player.width + 10, Player.height + 10);

            //  g.setStroke(Color.RED);
            //  g.strokeRect(Player.x+5, Player.y+5, Player.width-10, Player.height-10);
        } else {
            g.drawImage(IL.iplayer_hit, Player.x - 5, Player.y - 5, Player.width + 10, Player.height + 10);
        }


        for (Asteroid a : Asteroid_Creation.asteroids) {
            if (a.containsIridium()) {
                g.drawImage(IL.iasteriod_i, a.getX(), a.getY(), a.getWidth(), a.getHeight());
            } else {
                g.drawImage(IL.iasteriod, a.getX(), a.getY(), a.getWidth(), a.getHeight());
            }

            if (a.isHit()) {
                g.setFill(Color.DARKRED);
                g.setStroke(Color.BLACK);
                g.fillRect(a.getX() + a.getWidth() / 4, a.getY() - 10, a.getWidth() / 2, 10);

                g.setFill(Color.RED);
                g.fillRect(a.getX() + a.getWidth() / 4, a.getY() - 10, a.getWidth() / 2 * ((double) a.getCurrenthealth() /
                        (double) a.getHealth()), 10);
            }

            g.setStroke(Color.BLUE);
            //g.strokeRect(a.getX()+15, a.getY()+15, a.getWidth()-30, a.getHeight()-30);
        }

        for (Bullet b : Bullet_Creation.bullets) {
            g.drawImage(IL.ischuss, b.getX(), b.getY(), b.getWidth(), b.getHeight());
        }


        if(Gamestate.state == Gamestate_e.shop){
            g.setFill(new Color(0,0,0,.5));
            g.fillRect(0,0,Gui.width, Gui.height);

            g.setStroke(Color.WHITE);
            g.strokeLine(Gui.width/2, 0, Gui.width/2, Gui.height);

            g.setFill(Color.WHITE);
            g.setFont(Font.font("Veranda", 20));


            for(Button_angled b : Gui.buttons_angled){
                if(b.isHover()){
                    g.setFill(new Color(1,1,1,.2));
                    double[] xpoints = {b.getX1(), b.getX2(), b.getX5(), b.getX1()};
                    double[] ypoints = {b.getY1(), b.getY1(), b.getY2(), b.getY2()};

                    g.fillPolygon(xpoints, ypoints, 4);

                    double[] xpoints2 = {b.getX3(), b.getX4(), b.getX4(), b.getX6()};
                    double[] ypoints2 = {b.getY1(), b.getY1(), b.getY2(), b.getY2()};

                    g.fillPolygon(xpoints2, ypoints2, 4);
                }


                //Links
                g.strokeLine(b.getX1(), b.getY1(), b.getX2(), b.getY1());
                g.strokeLine(b.getX1(), b.getY2(), b.getX5(), b.getY2());

                g.strokeLine(b.getX1(), b.getY1(), b.getX1(), b.getY2());
                g.strokeLine(b.getX2(), b.getY1(), b.getX5(), b.getY2());

                g.setFill(Color.WHITE);
                g.fillText(b.getText(), b.getX1() + 25, b.getY1() + 32);

                //Rechts
                g.strokeLine(b.getX3(), b.getY1(), b.getX4(), b.getY1());
                g.strokeLine(b.getX6(), b.getY2(), b.getX4(), b.getY2());

                g.strokeLine(b.getX4(), b.getY1(), b.getX4(), b.getY2());
                g.strokeLine(b.getX3(), b.getY1(), b.getX6(), b.getY2());

                g.drawImage(IL.iiridium, b.getX3(), b.getY1() +IL.iiridium.getHeight() / 4 + 3, 22, 22);

            }

            g.setStroke(Color.WHITE);
            g.setFill(new Color(39. / 255.,174. / 255.,96. / 255., 1));

            for(int i = 0; i< Gui.rectangles.length; i++){
                for(int j = 0; j< Gui.rectangles[i].length; j++){

                    g.strokeRect(Gui.rectangles[i][j].getX(), Gui.rectangles[i][j].getY(), Gui.rectangles[i][j]
                            .getWidth(), Gui.rectangles[i][j].getHeight());

                }
            }



        }


        g.setStroke(Color.WHITE);
        g.strokeLine(0, 50, 300, 50);
        g.strokeLine(300, 50, 325, 0);

        g.strokeLine(Gui.width - 300, 50, Gui.width, 50);
        g.strokeLine(Gui.width - 325, 0, Gui.width - 300, 50);

        g.drawImage(IL.iiridium, 15,15,20,20);

        g.setFill(Color.WHITE);
        g.setFont(Font.font("Veranda", 25));
        g.fillText(df.format(Player.iridium), 50, 34);

        g.drawImage(IL.ihealth, Gui.width -290, 12, 25, 25);
        g.fillText(df.format(Player.health), Gui.width-250, 34);


        if (Gamestate.state == Gamestate_e.pause) {
            g.setFill(new Color(0, 0, 0, 0.5));
            g.fillRect(0, 0, Gui.width, Gui.height);

            g.setStroke(Color.WHITE);
            g.setFill(Color.WHITE);

            for (Button b : Gui.buttons) {
                g.strokeRect(b.getX(), b.getY(), b.getWidth(), b.getHeight());

                g.setFill(new Color(1, 1, 1, 0.2));
                if (b.isHover()) {
                    g.fillRect(b.getX(), b.getY(), b.getWidth(), b.getHeight());
                }

                g.setFill(Color.WHITE);

                text.setText(b.getText());
                text.setFont(Font.font("Veranda", 25));

                g.fillText(b.getText(), b.getX() + b.getWidth() / 2 - text.getLayoutBounds().getWidth() / 2, b.getY() +
                        b.getHeight() / 2 + text.getLayoutBounds().getHeight() / 4);


            }
        }

    }
}
