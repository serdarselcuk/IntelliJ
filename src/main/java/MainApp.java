import java.util.ArrayList;

public class MainApp extends DataBank {

    public static void main(String[] args) {
        ArrayList<DataBank> list = new ArrayList<>();
        //Scanner scan = new Scanner(System.in);
        boolean onemore = false;


        do {
            Functions obj = new Functions();
            list.add(obj);
            System.out.println(" One more ? ");
            String ans = scan.nextLine();
            if (yesAnswer.contains(ans)) {
                onemore = true;
            }
        }while (onemore) ;


        System.out.println(list.get(0).name + " " + list.get(0).emergency+ "   "+ list.get(0).unwanted_days);


    }
}
