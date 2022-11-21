package AbstractFactory.A2.listfactory;

import AbstractFactory.A2.factory.Factory;
import AbstractFactory.A2.factory.Link;
import AbstractFactory.A2.factory.Page;
import AbstractFactory.A2.factory.Tray;

public class ListFactory extends Factory {
    @Override
    public Link createLink(String caption, String url) {
        return new ListLink(caption, url);
    }

    @Override
    public Tray createTray(String caption) {
        return new ListTray(caption);
    }

    @Override
    public Page createPage(String title, String author) {
        return new ListPage(title, author);
    }
}
