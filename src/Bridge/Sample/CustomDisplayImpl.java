package Bridge.Sample;

public class CustomDisplayImpl extends DisplayImpl {
    private char startChr;
    private char printChr;
    private char endChr;

    public CustomDisplayImpl(char startChr, char printChr, char endChr) {
        this.startChr = startChr;
        this.printChr = printChr;
        this.endChr = endChr;
    }

    @Override
    public void rawOpen() {
        System.out.print(startChr);
    }

    @Override
    public void rawPrint() {
        System.out.print(printChr);
    }

    @Override
    public void rawClose() {
        System.out.println(endChr);
    }


}
