package Visitor.Q1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QFileFindVisitor extends Visitor {
    private String appointPostfix;
    private List<File> files = new ArrayList<>();

    public QFileFindVisitor(String appointPostfix) {
        this.appointPostfix = appointPostfix;
    }


    @Override
    public void visit(File file) {
        if (file.getName().endsWith(appointPostfix)) {
            files.add(file);
        }
    }

    @Override
    public void visit(Directory directory) {
        Iterator<Entry> iterator = directory.iterator();
        while (iterator.hasNext()) {
            Entry entry = iterator.next();
            entry.accept(this);
        }
    }

    public List<File> getFoundFiles() {
        return files;
    }
    
}
