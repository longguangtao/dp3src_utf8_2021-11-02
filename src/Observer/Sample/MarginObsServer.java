package Observer.Sample;

public class MarginObsServer implements Observer{
    private int number;

    @Override
    public void update(NumberGenerator generator) {
        int newNum = generator.getNumber();
        System.out.println("MarginObserver:" + Math.abs(number - generator.getNumber()));
        number = newNum;
    }
    
}
