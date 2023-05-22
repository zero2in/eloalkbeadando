import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
public class Game {
    //jatek logika osztaly
    private boolean exit = false;
    private Mage mage = new Mage();
    private int mageplace =  0;
    private Fighter fighter = new Fighter();
    private int fighterplace = 2;
    private final int gameBoardSize = 3;
    private NPC[] gameBoard = new NPC[gameBoardSize];
    private Random NPCJumpPointCalculation = new Random();
    private int gameState = 0;
    private int turncounter = 1;
    public void gameLoop(){
        while(this.exit == false){
            if(this.gameState!=13){
                CalcMove();
                this.turncounter++;
            } else {this.exit = true;}
        }
    }
    private void CalcMove(){
        this.gameBoard[this.mageplace] = null;
        this.gameBoard[this.fighterplace] = null;

        this.mageplace= NPCJumpPointCalculation.nextInt(1,3);
        this.fighterplace = NPCJumpPointCalculation.nextInt(1,3);

        if(this.mageplace == this.fighterplace){
            fight();
        }
        else{
            this.gameBoard[this.mageplace] = this.mage;
            this.gameBoard[this.fighterplace] = this.fighter;
            display_Board();
        }
    }
    private void fight(){
        int dmgtakenbymage = fighter.getDamage();
        this.mage.takeDamage(dmgtakenbymage);
        int dmgtakenbyfighter = mage.getDamage();
        this.fighter.takeDamage(dmgtakenbyfighter);
        displayFight(dmgtakenbyfighter,dmgtakenbymage,this.mageplace);
        if(isDead(this.fighter)){
            this.gameState=13;
            System.out.println("The fighter died!");
        } else if(isDead(this.mage)) {
            this.gameState=13;
            System.out.println("The mage died!");
        } else if(isDead(this.mage) && isDead(this.fighter)){
            this.gameState=13;
            System.out.println("Both of them died!");
        }
    }
    private void displayFight(int magedmg,int fighterdmg,int place){
        System.out.println(turncounter + ". turn.");
        System.out.print("|");
        for(int p = 0; p < this.gameBoardSize;p++){
            if(p == place){
                System.out.print("X");
            }else {
                System.out.print("_");
            }
            System.out.print("|");
        }
        System.out.println("\nThe mage damages: " +magedmg+"\nThe fighter damages: "+fighterdmg);
    }
    private boolean isDead(NPC toCheck){
        if(toCheck.getHealth()<= 0){
            return true;
        }else{
            return false;
        }
    }
    private void display_Board(){
        System.out.println(turncounter + ". turn.");
        System.out.print("|");
        for (NPC f : gameBoard) {
            if(f instanceof Fighter){
                System.out.print("F");
            }
            else if(f instanceof Mage){
                System.out.print("M");
            } else {
                System.out.print("_");
            }
            System.out.print("|");
        }
        System.out.print("\n Mage health:" + this.mage.getMageHealth() + "\t Fighter health:" + this.fighter.getFighterHealth());
        System.out.println();
    }
    public Game(){
        System.out.println("Mage health: " + this.mage.getHealth() + "\tFighter health: "+this.fighter.getHealth());
        this.gameBoard[this.mageplace] = this.mage;
        this.gameBoard[this.fighterplace] = this.fighter;
    }

}
