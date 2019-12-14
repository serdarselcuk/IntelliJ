package com.selcuk;

import java.util.ArrayList;
import java.util.Arrays;

public class Graphic {


    String empty = " ";
    String oblique_line = "_";
    String horizondal_line = "|";
    static int x;
    static int y;

    public Graphic() {

        this.x = 1;
        this.y = 1;

        }

    public Graphic(int a) {

        this.x = a;
        this.y = a;

    }


    public void writer(){

        for (int i = x+1; i < x * 14; i++) {

            System.out.println();

            for (int j = y; j< y * 24 ; j++) {

                System.out.print(structure(i,j));

            }

        }
    }
    private String structure(int i, int j){

        if ((i > x   && i < x * 12) && (j == y * 8  || j == y * 16)) {

            return horizondal_line;

        } else if ((i == x * 4 || i == x * 8) && (j < y * 24 && j > y )) {
            return oblique_line;

        }else {
            return sign_place(i,j);
        }
    }

    private String sign_place(int i, int j) {


        int player = 0;
        for (int[][] each : logic.arr  ) {
            player ++;  // first loop will turn for 2 times. At first player will be 1 and it will look to first players movements
            for (int[] each1 : each ) {
                if (j == (each1[1]*(y*8)-(8*y/2) )&& i ==  each1[0]*(x*4)-(4*x/2)){
                    if (player == 1)
                        return "X";
                    else
                        return "O";
                }
            }
        }
        return empty;
    }

    public static void main(String[] args) {

        Graphic obj = new Graphic();
        obj.writer();
    }

}


