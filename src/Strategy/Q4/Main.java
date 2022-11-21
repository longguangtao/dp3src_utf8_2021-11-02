package Strategy.Q4;

import java.util.*;

class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("D", "B", "C", "E", "A");

        // 辞書式順序で小さい順
        list.sort((a, b) -> a.compareTo(b) /* 未実装 */ );
        System.out.println(list);

        // 辞書式順序で大きい順
        list.sort((a,b) -> b.compareTo(a) /* 未実装 */ );
        System.out.println(list);
    }
}
