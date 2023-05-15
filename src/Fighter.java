public class Fighter implements NPC{
    //harcos osztaly
    private Dice fighterDice = new Dice();
    public int getHealth(){
        return this.fighterHealth;
    }
    public void takeDamage(int dmg){
         this.fighterHealth-= dmg;
    }
    private int fighterHealth = fighterDice.throw_Dice()+3;;
    public int getFighterHealth(){
        return this.fighterHealth;
    }
    public int getDamage(){
        return fighterDice.throw_Dice();
    }
    public Fighter(){
        getHealth();
    }
}
