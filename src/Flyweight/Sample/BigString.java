package Flyweight.Sample;

public class BigString {
    // 「大きな文字」の配列
    private BigChar[] bigchars;

    // コンストラクタ
    public BigString(String string, boolean shared) {
        BigCharFactory factory = BigCharFactory.getInstance();
        bigchars = new BigChar[string.length()];
        for (int i = 0; i < bigchars.length; i++) {
            char chr = string.charAt(i);
            if (shared) {
                bigchars[i] = factory.getBigChar(chr);
            } else {
                bigchars[i] = new BigChar(chr);
            }
        }
    }

    // 表示
    public void print() {
        for (BigChar bc : bigchars) {
            bc.print();
        }
    }
}
