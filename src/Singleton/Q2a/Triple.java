package Singleton.Q2a;

import java.util.HashMap;
import java.util.Map;

public class Triple {
    
    private static Map<Integer, Triple> tripleMap = new HashMap<>();

    private static Triple triple0 = new Triple();
    private static Triple triple1 = new Triple();
    private static Triple triple2 = new Triple();

    static {
        tripleMap.put(0, triple0);
        tripleMap.put(1, triple1);
        tripleMap.put(2, triple2);
    }

    
    private  Triple() {

    }

    public static Triple getInstance(int num) {
        
        return tripleMap.get(num);
    }
    
}
