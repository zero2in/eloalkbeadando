import java.util.Random;
public class Dice {
    private int randomHealtPoints;
    private int randomAttackDamagePoints;
    private final int LOWESTNUM = 1;
    private final int SIDE = 6;
    public Dice(){
        calculateHealth();
        calculateDamage();
    }
    private int throw_Dice(){
        Random randomDiceSide = new Random();
        int d_Throw = randomDiceSide.nextInt(LOWESTNUM,SIDE);
        return d_Throw;
    }
    private void calculateHealth(){
        this.randomHealtPoints = throw_Dice()+3;
    }
    private void calculateDamage(){
        this.randomAttackDamagePoints = throw_Dice();
    }
    public int getRandomHealtPoints(){
        calculateHealth();
        return this.randomHealtPoints;
    }
    public int getRandomAttackDamagePoints(){
        calculateDamage();
        return this.randomAttackDamagePoints;
    }
}
