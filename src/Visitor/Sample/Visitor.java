package Visitor.Sample;

public abstract class Visitor {
    public abstract void visit(File file);
    public abstract void visit(Directory directory);
    // public abstract void visit(ElementArrayList elementArrayList);
}
