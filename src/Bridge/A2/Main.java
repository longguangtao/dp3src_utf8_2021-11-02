package Bridge.A2;

public class Main {
    public static void main(String[] args) {
        CountDisplay d = new CountDisplay(new FileDisplayImpl("C:\\Users\\Longguangtao\\Desktop\\dp3src_utf8_2021-11-02\\src\\Bridge\\A2\\star.txt"));
        d.multiDisplay(3);
    }
}
