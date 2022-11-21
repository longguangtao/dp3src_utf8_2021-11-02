package Singleton.Q2b;

public class Triple {
    private static Triple[] triples = new Triple[]{new Triple(0), new Triple(1), new Triple(2)};
    private int id;

    private Triple(int id) {
        this.id = id;
    }

    public static Triple getInstance(int id) {
        return triples[id];
    }

    public String toString() {
        return "-- triple" + "id: " + id;
    }

}
