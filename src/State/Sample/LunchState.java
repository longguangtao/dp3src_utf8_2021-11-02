package State.Sample;

public class LunchState implements State {

    private static LunchState lunchState = new LunchState();

    private LunchState() {
    }

    public static LunchState getInstance() {
        return lunchState;
    }

    @Override
    public void doClock(Context context, int hour) {
        if (hour == 12) {
            context.changeState(LunchState.getInstance());
        }
    }

    @Override
    public void doUse(Context context) {
            
    }

    @Override
    public void doAlarm(Context context) {
        
    }

    @Override
    public void doPhone(Context context) {

    }
    
}
