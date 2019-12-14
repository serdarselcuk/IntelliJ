package com.selcuk;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("to play first press \"x\", for second \"O\" please.");

        String player = scan.nextLine();
        int[] playerMove = new int[2];

        logic.computer = (player == "o")? true : false;
        logic.computer_first = logic.computer;

        for(int i =1; i <= 9; i++) {

            if (logic.computer) {
                logic.playMachine(i);
            } else {
                System.out.println("Play a num that contains 2 digits first for row second for column: ");
                playerMove[0] = scan.nextInt();
                playerMove[1] = scan.nextInt();

                if((playerMove[0] < 0 && playerMove[0] > 3)&&(playerMove[1] < 0 && playerMove[1] > 3)){
            // be sure that the input was vald!
                    System.out.println("there is a problem the place that you want to play !");
                }else {
                    logic.logics(i % 2 == 0 ? 1 : 0, (i % 2 == 0 ? i / 2 : (i + 1) / 2), playerMove);
                }
            }logic.computer = !logic.computer;
        }
    }
}
