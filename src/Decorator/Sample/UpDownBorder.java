package Decorator.Sample;

public class UpDownBorder extends Border{

    private char customChar;

    protected UpDownBorder(Display display, char customChar) {
        super(display);
        this.customChar = customChar;
    }

    @Override
    public int getColumns() {
        return display.getColumns();
    }

    @Override
    public int getRows() {
        return 1 + display.getRows() + 1;
    }

    @Override
    public String getRowText(int row) {
        if (row == 0 || row == getRows() - 1) {
            StringBuffer buf = new StringBuffer();
            for (int i = 0; i < display.getColumns(); i++) {
                buf.append(customChar);
            }
            return buf.toString();
        }
        return display.getRowText(row - 1);
    }
    
}
