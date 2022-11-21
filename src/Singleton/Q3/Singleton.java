package Singleton.Q3; 

public class Singleton {
    private static Singleton singleton = null;

    private Singleton() {
        System.out.println("インスタンスを生成しました。");
    }

    // 确保线程安全
    public synchronized static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}
