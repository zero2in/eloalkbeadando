class NPC {
   private int health;
    public NPC(){
        Dice dice = new Dice();
        this.health = dice.getRandomHealthPoints();
    }
    public int getHealth() {
        return this.health;
    }
    public void takeDamage(int dmg){
        this.health = this.health - dmg;
    }

}

