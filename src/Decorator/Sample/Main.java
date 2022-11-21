package Decorator.Sample;


public class Main {
    public static void main(String[] args) {
        // Display b1 = new StringDisplay("Hello, world.");
        // Display b2 = new SideBorder(b1, '#');
        // Display b3 = new FullBorder(b2);
        // b1.show();
        // b2.show();
        // b3.show();
        // Display b4 = new SideBorder(
        //         new FullBorder(
        //                 new FullBorder(
        //                         new SideBorder(
        //                                 new FullBorder(
        //                                         new StringDisplay("Hello, world.")),
        //                                 '*'))),
        //         '/');
        // b4.show();

        // Display d5 = new UpDownBorder(new StringDisplay("Hello, W"), '$');
        // d5.show();

        Display d6 = new FullBorder(new UpDownBorder(
                new SideBorder(
                        new UpDownBorder(
                                new SideBorder(
                                        new StringDisplay("Hello, Longguangtao"), '*'),
                                '='),
                        '|'),
                '/'));

        d6.show();

        // MultiStringDisplay md = new MultiStringDisplay();
        // md.add("Hello");
        // md.add("Anlice");
        // md.add("Good morning!");
        // md.show();

        // SideBorder da = new SideBorder(md, '#');
        // da.show();

        // FullBorder db = new FullBorder(md);
        // db.show();

    }
}
