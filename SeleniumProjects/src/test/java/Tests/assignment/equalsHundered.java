package Tests.assignment;

import java.util.ArrayList;

public class equalsHundered {

    static int[] b = {2,3,4,5,6,7,8,9};
    static String[] operators = {"", "+", "-"};

    public static void main(String[] args) {

        ArrayList<String>temp= new ArrayList<>();   // will be the last list


        temp.add("1");                      // it can be assigned directly because there is only 1 variation for it

        for (int   each  :  b   ) {     // will change the nums
            ArrayList<String> temp1 = new ArrayList<>(); // will store variations of operator applied strings
            for (String operator:operators ) {      // change the operators

                for (String tempStr : temp) {       // will take the string which in temp and concatenate with operator and the new num

                    temp1.add(tempStr+operator+each);        // for 1sth loop => 2  / for 2th loop=> "" / for last loop => 1  ==>tempStr = 1+""+2
                }

            }
            temp = temp1;       // assign them all to temp folder for next turn
        }
        for (String each : temp   ) {  // this loop will send the string to check if it is equals 100 or not
            if(check(each))
            System.out.println(each);
        }

    }
    public static boolean check(String arg){// 12-3+45-6+789 given string' ll taken and after spliting from +/-
                                            // I 'll check (if it is == 100)

        int sum = 0;
        for (String pos_split :   arg.split("\\+")) {// given string'll be split on "+" sign=> [12-3,45-6,789]
            int n=0;
            for (String neg_split : pos_split.split("-")) {  // [12,3],[45,6],[789]

                int splitedInt = n!=0? Integer.parseInt(neg_split)*(-1):Integer.parseInt(neg_split);
                n++;    // if it is not first string after negative number spliting it will multiply with -1 after parsed to Integer

                sum += splitedInt; // it will be added to sum

            }
        }
        return sum==100  ;  // true / false
    }
}

