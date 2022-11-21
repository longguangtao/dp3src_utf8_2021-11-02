package Composite.Sample;

import java.util.ArrayList;
import java.util.List;


public class Directory extends Entry {
    private String currentEntryPath = "";
    private String name;
    private List<Entry> directory = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
        this.currentEntryPath += "/" + name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        int size = 0;
        for (Entry entry: directory) {
            size += entry.getSize();
        }
        return size;
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
        for (Entry entry: directory) {
            entry.printList(prefix + "/" + name);
        }
    }

    // ディレクトリエントリをディレクトリに追加する
    public Entry add(Entry entrys) {
        directory.add(entrys);
        entrys.setCurrentEntiryPath(this.currentEntryPath);
        return this;
    }

    public String getCurrentEntiryPath() {
        return this.currentEntryPath;
    }

    
    public void setCurrentEntiryPath(String parentPath) {
        this.currentEntryPath = parentPath + this.currentEntryPath;
    }
   
}
