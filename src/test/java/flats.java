import java.util.Arrays;

public class flats {


    public static void main(String[] args) {

        int[][] arr = {{3,6,4,5},{8,5,7,3},{9,4,2,7},{4,7,2,8}};

        int [] [] arr2 = highestNorth(arr);
        System.out.println(Arrays.deepToString(arr2));
        System.out.println(calculate(arr,arr2));




    }public static int[][] highestNorth(int [][] arr ){

        int [] [] result = new int [2][4];
        int i = 0;
        int[] north = {0,0,0,0};
        for (  int [] each : arr ) {
            int j =0;
            int numE = 0;

            for ( int only : each){
                if( only > north [j]){
                    north[j] = only;
                }
                if (only > numE){
                    numE = only;
                }
                j++;

            }result[0][i] = numE;

            i++;
        }
        result [1] = north ;
        return result;
    }
    public static int calculate (int [][] arr, int [][] arr2){
        int i = 0;
        int result = 0;

        for (int [] each : arr  ) {
            int j = 0;
            for (int flat: each ) {
                int flatMax = (arr2[0][i] > arr2 [1][j])? arr2[1][j] :arr2[0][i];
                result += (flatMax - flat);
                j++;
            }
            i++;


            }
        return result;
        }



    }



