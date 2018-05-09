package data;

import chars.Player;

public class Upgrade {
    public static int[] cost = {150, 150, 150, 500, 300, 300};
    public static int[] ugCount = {0, 0, 0, 0, 0, 0};

    public static void upgrade(int i) {
        if (Player.iridium >= cost[i] && ugCount[i] < 5) {
            Player.iridium -= cost[i];
            cost[i] *= 2;
            ugCount[i]++;
            switch (i) {
                case 0: Player.damage += 5;
                    break;
                case 1: Player.speed += 3;
                    break;
                case 2:
                    break;
                case 3: Player.iridiumCollect -= 10;
                    break;
                case 4:
                    break;
                case 5:
                    break;
            }
        }


    }
}
