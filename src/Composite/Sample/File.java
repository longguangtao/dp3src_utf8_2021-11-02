package Composite.Sample;

public class File extends Entry {
    private String currentEntryPath = "";
    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
        this.currentEntryPath = "/" + name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
    }

    public String getCurrentEntiryPath() {
        return this.currentEntryPath;
    }

    public void setCurrentEntiryPath(String parentPath) {
        this.currentEntryPath = parentPath + this.currentEntryPath;
    }

}
