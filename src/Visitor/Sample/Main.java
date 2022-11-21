package Visitor.Sample;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        System.out.println("Making root entries...");
        Directory rootdir = new Directory("root");
        Directory bindir = new Directory("bin");
        Directory tmpdir = new Directory("tmp");
        Directory usrdir = new Directory("usr");
        rootdir.add(bindir);
        rootdir.add(tmpdir);
        rootdir.add(usrdir);
        bindir.add(new File("vi", 10000));
        bindir.add(new File("latex", 20000));
        rootdir.accept(new ListVisitor());
        System.out.println();

        System.out.println("Making user entries...");
        Directory yuki = new Directory("yuki");
        Directory hanako = new Directory("hanako");
        Directory tomura = new Directory("tomura");
        usrdir.add(yuki);
        usrdir.add(hanako);
        usrdir.add(tomura);
        yuki.add(new File("diary.html", 100));
        yuki.add(new File("Composite.java", 200));
        hanako.add(new File("memo.tex", 300));
        tomura.add(new File("game.doc", 400));
        tomura.add(new File("junk.mail", 500));
        rootdir.accept(new ListVisitor());

        SizeVisitor sizeVisitor = new SizeVisitor();
        yuki.accept(sizeVisitor);
        System.out.println(sizeVisitor.getEntrySize());

        System.out.println("-------------");

        Directory root1 = new Directory("root1");
        root1.add(new File("diary.html", 10));
        root1.add(new File("index.html", 20));

        Directory root2 = new Directory("root2");
        root2.add(new File("diary.html", 1000));
        root2.add(new File("index.html", 2000));

        ElementArrayList list = new ElementArrayList();
        list.add(root1);
        list.add(root2);

        list.add(new File("etc.html", 1234));
        list.accept(new ListVisitor());

        List<? super Father> test = new ArrayList<>();
        test.add(new Father());
        // list.add(new Human());// compile error
        test.add(new Son());
        // Father person1 = list.get(0);// compile error
        // Son son = list.get(0);// compile error
        Object object1 = list.get(0);
        System.out.println(object1);

    }
}
