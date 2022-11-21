package Visitor.Sample;

import java.util.ArrayList;

public class ElementArrayList extends ArrayList<Entry> implements Element {
    // private ArrayList<Entry> elementList = new ArrayList<>();

    @Override
    public void accept(Visitor v) {
        for (Entry entry : this) {
            entry.accept(v);
        }
    }

    // public void add(Entry element) {
    //     elementList.add(element);
    // }

}
