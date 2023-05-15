import java.util.Random;
public class Dice {
    private Random randomDiceSide = new Random();
    private int randomHealtPoints;
    private int randomAttackDamagePoints;
    private final int LOWESTNUM = 1;
    private final int SIDE = 6;
    public Dice(){
        calculateHealth();
    }
    private int throw_Dice(){
        int d_Throw = this.randomDiceSide.nextInt(LOWESTNUM,SIDE);
        return d_Throw;
    }
    private void calculateHealth(){
        this.randomHealtPoints = throw_Dice()+3;
    }
    public void calculateDamage(){
        this.randomAttackDamagePoints = throw_Dice();
    }
    public int getRandomHealthPoints(){
        calculateHealth();
        return this.randomHealtPoints;
    }
    public int getRandomAttackDamagePoints(){
        calculateDamage();
        return this.randomAttackDamagePoints;
    }
}
