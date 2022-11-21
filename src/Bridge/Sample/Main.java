package Bridge.Sample;

public class Main {
    public static void main(String[] args) {
        Display d1 = new Display(new StringDisplayImpl("Hello, Japan."));
        Display d2 = new CountDisplay(new StringDisplayImpl("Hello, World."));
        CountDisplay d3 = new CountDisplay(new StringDisplayImpl("Hello, Universe."));
        RandomDisplay d4 = new RandomDisplay(new StringDisplayImpl("Hello, GOF"));
        Display d5 = new Display(new CustomDisplayImpl('<', '*', '>'));
        IncreaseDisplay d6 = new IncreaseDisplay(new CustomDisplayImpl('<', '*', '>'), 3);
        d1.display();
        d2.display();
        d3.display();
        d5.display();
        d4.randomDisplay(12);
        d3.multiDisplay(5);
        d6.increaseDisplay(5);
    }
}
