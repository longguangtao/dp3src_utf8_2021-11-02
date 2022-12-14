package Proxy.Sample;

public class PrinterProxy implements Printable {
    private String name;            // 名前
    private Printer real;           // 「本人」

    // コンストラクタ
    public PrinterProxy() {
        this.name = "No Name";
        this.real = null;
    }

    // コンストラクタ（名前指定）
    public PrinterProxy(String name) {
        this.name = name;
        this.real = null;
    }

    // 名前の設定
    @Override
    public synchronized void setPrinterName(String name) {
        if (real != null) {
            // 「本人」にも設定する
            real.setPrinterName(name);
        }
        this.name = name;
    }

    // 名前の取得
    @Override
    public String getPrinterName() {
        return name;
    }

    // 表示
    @Override
    public void print(String string) {
        realize();
        real.print(string);
    }

    // 「本人」を生成
    private synchronized void realize() {
        if (real == null) {
            real = new Printer(name);
        }
    }
}
