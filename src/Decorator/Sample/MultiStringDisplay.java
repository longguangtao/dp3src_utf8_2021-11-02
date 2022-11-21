package Decorator.Sample;

import java.util.ArrayList;

public class MultiStringDisplay extends Display{
    private ArrayList<String> string = new ArrayList<>();
    private int maxStringLength = 0;


    @Override
    public int getColumns() {
        return maxStringLength;
    }

    @Override
    public int getRows() {
        return string.size();
    }

    @Override
    public String getRowText(int row) {
        StringBuffer buf = new StringBuffer();
        String str = this.string.get(row);
        buf.append(str);
        for (int i = str.getBytes().length; i < getColumns(); i++) {
            buf.append(" ");
        }
        return buf.toString();
    }

    public void add(String string) {
        if (string.getBytes().length > maxStringLength) {
            maxStringLength = string.getBytes().length;
        }
        this.string.add(string);
    }
    
}
