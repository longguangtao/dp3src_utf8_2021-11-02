package Singleton.Q2b;

public class Main {
    
    public static void main(String[] args) {

        System.out.println(Triple.getInstance(0));
        System.out.println(Triple.getInstance(1));
        System.out.println(Triple.getInstance(2));
        
        System.out.println(Triple.getInstance(0));
        System.out.println(Triple.getInstance(1));
        System.out.println(Triple.getInstance(2));

    }

}
