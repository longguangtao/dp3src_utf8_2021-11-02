package Singleton.Q1;

public class TicketMaker {
    private static int ticket = 1000;

    private static TicketMaker ticketMaker = new TicketMaker();

    private TicketMaker() {
        
    }

    public static TicketMaker getInstance() {
        return ticketMaker;
    }

    public synchronized int getNextTicketNumber() {
        return ticket++;
    }
}
