package Proxy.Sample;

public interface Printable {
    public abstract void setPrinterName(String name);
    public abstract String getPrinterName();            // 名前の取得
    public abstract void print(String string);          // 文字列表示(プリントアウト)
}
