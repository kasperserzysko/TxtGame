package com.kasperserzysko;



import Characters.Hero;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {
        //VARIABLES
        boolean check = true; //first while loop
        Hero hero = new Hero();
        //GAME SETUP

        while (check){
            System.out.println("***************************");
            System.out.println("***************************");
            System.out.println("       Select a class      ");
            System.out.println("       1) - Warrior        ");
            System.out.println("       2) - Rogue          ");
            System.out.println("       3) - Mage           ");
            System.out.println("***************************");
            System.out.println("***************************");

            switch (Util.scanner()) {
                case 1:
                    hero.setHero_class(1);
                    check = false;
                    break;
                case 2:
                    hero.setHero_class(2);
                    check = false;
                    break;
                case 3:
                    hero.setHero_class(3);
                    check = false;
                    break;
                default:
                    Util.error();
                    break;

            }
        }
        //Util.write("You have woken up in your bed in your village");
        while (true) {
            System.out.println("***************************");
            System.out.println("***************************");
            System.out.println("What do you want to do?:\n1) - Check status\n2) - Move\n3) - Actions\n0) - Exit");
            switch (Util.scanner()){
                case 1:
                    hero.checkStatus();
                    Util.placeholder();
                    break;
                case 2:
                    hero.move();
                    break;
                case 3:
                    hero.actions();
                    break;
                case 0:
                    System.exit(1);
                    break;
                default:
                    Util.error();
                    break;
            }

        }
    }
}
