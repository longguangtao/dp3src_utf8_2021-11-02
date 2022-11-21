package Visitor.Sample;

import java.util.Iterator;

public class SizeVisitor extends Visitor{
    private int entrySize;

    @Override
    public void visit(File file) {
        entrySize += file.getSize();
    }

    @Override
    public void visit(Directory directory) {
        Iterator<Entry> iterator = directory.iterator();
        while (iterator.hasNext()) {
            Entry entry = iterator.next();
            entry.accept(this);
        }
    }
    

    public int getEntrySize() {
        return this.entrySize;
    }
}
