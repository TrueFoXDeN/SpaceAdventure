package data;

public class CustomMath {

    public static int limit(int x, int min, int max){
        return (x > max) ? max : (x < min ? min : x);
    }

}
