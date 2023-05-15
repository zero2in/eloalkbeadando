import java.util.Random;
//Kocka osztaly
public class Dice {
    private Random randomDiceSide = new Random();
    private final int LOWESTNUM = 1;
    private final int SIDE = 6;
    public Dice(){
    }
    public int throw_Dice(){
        int d_Throw = this.randomDiceSide.nextInt(LOWESTNUM,SIDE);
        return d_Throw;
    }
}
