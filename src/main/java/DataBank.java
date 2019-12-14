import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DataBank {


        protected String name;
        protected boolean emergency;
        public static int month;
        public  ArrayList<Integer> unwanted_days=new ArrayList<Integer>();
        static Scanner scan = new Scanner(System.in);
        static ArrayList<String> yesAnswer = new ArrayList<>(Arrays.asList("yes", "ok", "ya", "evet", "tmm", "dogru","right","y"));
        static ArrayList<String> finish = new ArrayList<String>(Arrays.asList("fin", "end", "stop", "enough", "finish", "exit", "yes", "ok", "pass","quit"));


    /*    public void EnterDay() {

            String cont = "";

            System.out.println("Enter the day numbers that is not wanted by this person (press enter for each days) :");
            do {
                cont = this.scan.nextLine().trim().toLowerCase();
                if(cont.isBlank()){
                    cont = "true";
                }else{
                    if (if_num(cont)) {
                        if(Integer.parseInt(cont)>31|| Integer.parseInt(cont)==0){
                            System.out.println("there is NOT a number in this month!");
                            cont = "true";
                        }else{
                            unwanted_days.add(Integer.parseInt(cont));
                            cont = "true";
                        }

                    }else {
                        if (finish(cont)) {

                        } else {
                            cont = "true";
                            System.out.println("You can add numbers or you can quit.");
                        }
                    }

                }


            }while (!finish(cont)) ;
        }*/

     /*   public void EnterName(){

            String cont = "";

            System.out.println("Enter the name of doctors that will attend shift :");

                cont = this.scan.nextLine().trim().toLowerCase();
                if(cont.isBlank()){

                    cont = "true";
                }else{
                    if (!if_num(cont)) {
//
                            this.name = cont;
                            System.out.println("Is he/she working on emergency service");
                            cont = this.scan.nextLine().trim().toLowerCase();
                            setTitle(cont);
                            EnterDay();
                            cont ="true";
                    }else {
                            cont = "true";
                            System.out.println("you pushed number do you want to pass(for other doc names) or continue (for days)?");
                            cont = this.scan.nextLine().trim().toLowerCase();
                            if(cont.equalsIgnoreCase("pass")){
                                EnterDay();
                            }

                    }

                }




        }

*/

     /*   public static boolean if_num(@NotNull String cont){

            for (int i = 0; i < cont.length(); i++) {

                if ((cont.charAt(i) < 48) || (cont.charAt(i) > 57)) {

                    return false;
                }
            }
            return true;
        }
*/
      /*  public static boolean finish(String cont){

            if(cont == "true"){
                return false;
            }
            else if (finish.contains(cont)){

                return true;

            }
            else{
                finish.add(cont);
                return false;
            }
        }
*/
   /*     public void setTitle(String title){
            if(yesAnswer.contains(title)){
                this.emergency =  true;
            }else{
                this.emergency =  false;
            }
}*/

   /* public static void main(String[] args) {
            ArrayList<DataBank>list = new ArrayList<>();
            System.out.println("Add a name : ");
            do {
                DataBank obj = new DataBank();
                list.add(obj);

            }while(true);

    }*/
}
