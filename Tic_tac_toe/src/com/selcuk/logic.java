package com.selcuk;

import java.util.ArrayList;
import java.util.Arrays;

public class logic {
    static int[][] wins = {{1,2,3},{4,5,6},{7,8,9},{1,4,7},{2,5,8},{3,6,9},{1,5,9},{3,5,7}};
    static int[][][] arr = {{{0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}}, {{0, 0}, {0, 0}, {0, 0}, {0, 0}}};
    static int[][] p_movements = {{0, 1, 1, 1}, {0, 2, 1, 2}, {0, 3, 1, 3}, {0, 4, 2, 1}, {0, 5, 2, 2}, {0, 6, 2, 3}, {0, 7, 3, 1}, {0, 8, 3, 2}, {0, 9, 3, 3}};
    static boolean computer ;
    static boolean computer_first ;
    static ArrayList<Integer> def_move = new ArrayList<>();
    static ArrayList<Integer> min_move = new ArrayList<>();
    public static void logics(int a, int b, int[] arr) {
//this will set the inputs to arr

        logic.arr[a][b][0] = arr[0];
        logic.arr[a][b][1] = arr[1];
        p_movements[translator(arr)][0] = 1;
//        System.out.println((logic.arr[a][b][0]));

    }


    public static void main(String[] args) {
    computer = false;
    computer_first = false;
        System.out.println(howMany(computer));


    }


//    public int howMany(int[] arr,int i){
//
//
//    }
    public static int howMany(boolean computer){
        int[][] moves = {{1,0},{2,0},{3,0},{4,0},{5,0},{6,0},{7,0},{8,0},{9,0}}; // 1. place , 2.how many move need
        boolean ListSide = computer_first ^ computer;
        int i =0;

        for (int[] each : arr[ListSide?1:0] ) {
            if(each[0]==0){
                break;
            }else{
                for (int j = 0; j < 8; j++) {
                    int position = translator(each);
                    if (wins[j][0] == position || wins[j][1] == position|| wins[j][2]== position){
                        i++;
                    }

                }
                translator(each)
            }
        }
        while(arr[ListSide?1:0][i][0] > 0){

        }

        return 3;
    }
    public boolean you_win(int arr1[], int arr2[], int arr3[]) {

        int[] nums ={ translator(arr1), translator(arr2),translator(arr3)};;
        Arrays.sort(nums);

        for (int[] each : wins) {

            if (each[0] == nums[0]) {
                if(each[1] == nums[1]){
                    if(each[2]== nums[2])
                        return true;
                }
            }
        }
        return false;
    }



    public static void playMachine(int turn) {

//        if (howMany(computer) < howMany(!computer)){
//            play(min_move);
//        }else{
//            play(def_move);
//        }
//
//        return minimum(howMany());



    }public static int translator(int[] arr){

        if ( arr[0] == 1){

            return (arr[0]+arr[1]-1);

        }else  if ( arr[0] == 1){

            return (arr[0]+arr[1]+1);

        }else{

            return (arr[0]+arr[1]+3);
        }

    }
    public static int[] translator(int a){

        int[] result =new int[2];

        for (int[] each : p_movements){
           if(each[1] == a ){
               result[0] = each[2];
               result[1] = each[3];
               return result;
           }

        }return null;
    }
    public static int minimum(int a, int b){
        return a> b? b:a;
    }

}

