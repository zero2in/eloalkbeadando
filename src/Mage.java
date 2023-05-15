public class Mage implements NPC{
    private Dice mageDice = new Dice();
    private int mageHealth = mageDice.throw_Dice()+3;
    public int getHealth(){
        return this.mageHealth;
    }
    public void takeDamage(int dmg){
        this.mageHealth -= dmg;
    }
    public int getMageHealth() {
        return this.mageHealth;
    }
    public int getDamage(){
        return mageDice.throw_Dice();
    }
    public Mage(){
        getHealth();
    }
}
