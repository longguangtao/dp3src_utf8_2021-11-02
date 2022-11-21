package FactoryMethod.A2;
import FactoryMethod.A2.framework.Factory;
import FactoryMethod.A2.framework.Product;
import FactoryMethod.A2.idcard.IDCardFactory;

public class Main {
    public static void main(String[] args) {
        Factory factory = new IDCardFactory();
        Product card1 = factory.create("Hiroshi Yuki");
        Product card2 = factory.create("Tomura");
        Product card3 = factory.create("Hanako Sato");
        card1.use();
        card2.use();
        card3.use();
    }
}
