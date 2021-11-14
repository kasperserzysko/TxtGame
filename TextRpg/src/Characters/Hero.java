package Characters;

import Areas.Area;
import Enemies.Enemy;
import com.kasperserzysko.Util;

import java.util.HashMap;

public class Hero {

    private int exp_points = 1;
    private int level = (int)Math.floor(Math.log(exp_points));
    private String hero_class = null;
    private int strength = 1;
    private int dexterity = 1;
    private int vitality = 1;
    private int intelligence = 1;
    private int hp = 10 + 5*level + 4*vitality;
    private String current_area = "Home";
    private HashMap<Integer, String> abilities = new HashMap<>();


    //GETTERS
    public int getHp(){return this.hp;}

    //SETTERS
    public void setHeroHp(int hp){
        this.hp = hp;
    }

    //CLASS SELECT
    public void setHero_class(int i){
        switch (i){
            case 1:
                System.out.println("You have chosen Warrior");
                this.hero_class = "Warrior";
                this.strength = 4;
                this.vitality = 3;
                this.dexterity = 2;
                break;
            case 2:
                System.out.println("You have chosen Rogue");
                this.hero_class = "Rogue";
                this.strength = 2;
                this.vitality = 2;
                this.dexterity = 5;
                break;
            case 3:
                System.out.println("You have chosen Mage");
                this.hero_class = "Mage";
                this.vitality = 1;
                this.dexterity = 3;
                this.intelligence = 5;
                break;
        }
    }

    //***********
    //STATUS CHECK
    //***********

    public void checkStatus(){
        System.out.println("***************************");
        System.out.println("***************************");
        System.out.println("LVL: " + this.level);
        System.out.println("Class: " + this.hero_class);
        System.out.println("Current location: " + this.current_area);
        System.out.println("Strength: " + this.strength);
        System.out.println("Dexterity: " + this.dexterity);
        System.out.println("Inteligence: " + this.intelligence);
        System.out.println("Vitality: " + this.vitality);
        System.out.println("HP: " + this.hp + "/" +(10 + 5*level + 4*vitality));
    }

    //***********
    //CREATING LOCATIONS
    //***********

    Area home = new Area("Home", "Village");
    Area village = new Area("Village", "Forest", "Home", "Meadow");
    Area forest = new Area("Forest", "Village", "Cave");
    Area cave = new Area("Cave", "Forest");
    Area meadow = new Area("Meadow", "Village");

    private Area current_location(){
        if (this.current_area.equals("Meadow")) return meadow;
        if (this.current_area.equals("Forest")) return forest;
        if (this.current_area.equals("Cave")) return cave;
        if (this.current_area.equals("Home")) return home;
        else return village;
    }

    //***********
    //ACTIONS
    //***********

    public void move(){
        while(true){

            System.out.println("***************************");
            System.out.println("***************************");
            System.out.println("Available locations: ");
            for (int i = 0; i < current_location().getSurrounding_areas().size(); i++){
                System.out.println(i + ") - " + current_location().getSurrounding_areas().get(i));
            }
            int ans = Util.scanner();
            if(current_location().getSurrounding_areas().containsKey(ans)){
                this.current_area = current_location().getSurrounding_areas().get(ans);
                System.out.println("You moved to: " + this.current_area);
                break;
            }
                else System.out.println("Wrong input! Try again");
        }
        System.out.println("***************************");
        System.out.println("***************************");
    }


    public void actions(){

        boolean check = true;

        switch (this.current_area){
            case "Home":
                System.out.println("This is Your home and place to sleep. Nothing really entertaining here.");
                while (check) {
                    System.out.println("1) - Sleep\n2) - Back");
                    switch (Util.scanner()) {
                        case 1:
                            sleep();
                            check = false;
                            break;
                        case 2:
                            check = false;
                            break;
                        default:
                            System.out.println("Wrong argument! Type again");
                            break;
                    }
                }
                break;
            case "Village":
                System.out.println("The village where You have been raised, such a nice view!");
                break;
            case "Meadow":
                System.out.println("You see farmers harvesting.");
                break;
            case "Forest":
                System.out.println("Wind shakes trees...");
                break;
            case "Cave":
                System.out.println("Keep Your eyes open. It might be dangerous inside");
                break;
        }
    }
    private void sleep(){
        this.hp = 10 + 5*level + 4*vitality;
        System.out.println("You sleep well. Your hp has been regenerated!");
    }
    private void search(){

    }

    //***********
    //BATTLE
    //***********
    public void battle(Enemy enemy){

    }
}
