import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Functions extends DataBank {

    static ArrayList<Integer>days = new ArrayList<>();
    static int [] howManyDays = new int[31];


    public Functions(){
        EnterName();
    }

    public void EnterDay() {

        String cont = "";

        System.out.println("Enter the day numbers that is not wanted by this person (press enter for each days) :");
        do {
            cont = this.scan.nextLine().trim().toLowerCase();
            if (cont.isBlank()) {
                cont = "true";
            } else {
                if (if_num(cont)) {                                                     // if num checker
                    if (Integer.parseInt(cont) > 31 || Integer.parseInt(cont) == 0) {   // mount checker
                        System.out.println("there is NOT a number in this month!");
                        cont = "true";
                        if(day) else {
                        unwanted_days.add(Integer.parseInt(cont));
                        cont = "true";
                    }

                } else {
                    if (finish(cont)) {

                    } else {
                        cont = "true";
                        System.out.println("You can add numbers or you can quit.");
                    }
                }

            }


        } while (!finish(cont));
    }

    public void EnterName() {

        String cont = "";

        System.out.println("Enter the name of doctors that will attend shift :");

        cont = this.scan.nextLine().trim().toLowerCase();
        if (cont.isBlank()) {

            cont = "true";
        } else {
            if (!if_num(cont)) {
//
                this.name = cont;
                System.out.println("Is he/she working on emergency service");
                cont = this.scan.nextLine().trim().toLowerCase();
                setTitle(cont);
                EnterDay();
                cont = "true";
            } else {
                cont = "true";
                System.out.println("you pushed number do you want to pass(for other doc names) or continue (for days)?");
                cont = this.scan.nextLine().trim().toLowerCase();
                if (cont.equalsIgnoreCase("pass")) {
                    EnterDay();
                }

            }

        }


    }

    public static boolean if_num(@NotNull String cont) {

        for (int i = 0; i < cont.length(); i++) {

            if ((cont.charAt(i) < 48) || (cont.charAt(i) > 57)) {

                return false;
            }
        }
        return true;
    }

    public static boolean finish(String cont) {

        if (cont == "true") {
            return false;
        } else if (finish.contains(cont)) {

            return true;

        } else {
            finish.add(cont);
            return false;
        }
    }

    public void setTitle(String title) {
        if (yesAnswer.contains(title)) {
            this.emergency = true;
        } else {
            this.emergency = false;
        }
    }

    public static boolean dayChecker(ArrayList<DataBank> arr){
//        ArrayList<Integer>days = new ArrayList<>();
//        int [] howManyDays = new int[31];
        for (int i = 0; i< arr.size(); i++){
            days.addAll((arr.get(i).unwanted_days));
        }
        for (int each : days ){
            howManyDays[each] += 1;
            if(howManyDays[each] >= arr.size()){
                return false;
            }
        }return true;
    }

    public static void main(String[] args) {

    }

}
