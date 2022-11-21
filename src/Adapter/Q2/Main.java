package Adapter.Q2;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FileIO f = new FilePropertiesQ();
        try {
            f.readFromFile("C:\\Users\\Longguangtao\\Desktop\\dp3src_utf8_2021-11-02\\src\\Adapter\\Q2\\file.txt");
            f.setValue("width", "1024");
            f.setValue("height", "512");
            f.setValue("depth", "32");
            f.writeToFile("C:\\Users\\Longguangtao\\Desktop\\dp3src_utf8_2021-11-02\\src\\Adapter\\Q2\\newfile.txt");
            System.out.println("newfile.txt is created.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
