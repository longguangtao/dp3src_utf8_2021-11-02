package Facade.Q2.pagemaker;


import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.Map.Entry;

public class PageMaker {
    private PageMaker() {
    }

    public static void makeWelcomePage(String mailaddr, String filename) {
        try {
            Properties mailprop = Database.getProperties("maildata");
            String username = mailprop.getProperty(mailaddr);
            HtmlWriter writer = new HtmlWriter(new FileWriter(filename));
            writer.title(username + "'s web page");
            writer.paragraph("Welcome to " + username + "'s web page!");
            writer.paragraph("Nice to meet you!");
            writer.mailto(mailaddr, username);
            writer.close();
            System.out.println(filename + " is created for " + mailaddr + " (" + username + ")");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void makeLinkPage(String filename) throws IOException {
        HtmlWriter htmlWriter = new HtmlWriter(new FileWriter(filename));
        
        htmlWriter.title("Link page");

        Properties properties = Database.getProperties("C:\\Users\\Longguangtao\\Desktop\\dp3src_utf8_2021-11-02\\src\\Facade\\Sample\\maildata");
        Set<Entry<Object, Object>> entryies = properties.entrySet();
        for (Entry<Object, Object> entry : entryies) {
            htmlWriter.mailto((String)entry.getKey(), (String)entry.getValue()); 
        }

        htmlWriter.close();
    }
}
