package com.kasperserzysko;

import java.io.IOException;
import java.util.Scanner;

public class Util {

    public static void write(String text) {
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            System.out.print(c);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void placeholder(){
        System.out.println("Type anything to back");
        Scanner in = new Scanner(System.in);
        while (true){
            if(in.hasNext()){
                break;
            }
        }
    }
    public static void error() throws InterruptedException, IOException {
        System.out.println("Wrong argument! Type again!");
        Thread.sleep(2000);
        Runtime.getRuntime().exec("clear");

    }
    public static int scanner(){
        Scanner in = new Scanner(System.in);
        System.out.print(">");
        return in.nextInt();

    }
}
