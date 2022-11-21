package Proxy.A1;

public class Main {
    public static void main(String[] args) {
        Printable p = new PrinterProxy("Alice", "Proxy.A1.Printer");
        System.out.println("名前は現在" + p.getPrinterName() + "です。");
        p.setPrinterName("Bob");
        System.out.println("名前は現在" + p.getPrinterName() + "です。");
        p.print("Hello, world.");
    }
}
