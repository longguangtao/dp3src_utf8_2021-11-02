package Interpreter.Sample;

import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        try {
            for (String text: Files.readAllLines(Path.of("C:\\Users\\Longguangtao\\Desktop\\dp3src_utf8_2021-11-02\\src\\Interpreter\\Sample\\program.txt"))) {
                System.out.println("text = \"" + text + "\"");
                Node node = new ProgramNode();
                node.parse(new Context(text));
                System.out.println("node = " + node);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
