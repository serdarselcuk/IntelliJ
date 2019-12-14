package pc1;

public class A extends C{
    String    a = "a";
    protected   String    b = "b";
    private     String    c = "c";
    public      String    d = "d";



    @Override
    public void setC(String c) {

    }
}
    abstract class  B{

        abstract public void setC(String c);



}abstract class C extends B{


    public C(){
        System.out.println("c");
    }

    public static void main(String[] args) {

    }

}