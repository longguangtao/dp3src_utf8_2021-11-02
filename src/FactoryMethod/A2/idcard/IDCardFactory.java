package FactoryMethod.A2.idcard;

import FactoryMethod.A2.framework.Factory;
import FactoryMethod.A2.framework.Product;

public class IDCardFactory extends Factory {
    private int serial = 100;

    protected synchronized Product createProduct(String owner) {
        return new IDCard(owner, serial++);
    }

    @Override
    protected void registerProduct(Product product) {
        System.out.println(product + "を登録しました。");
    }
}
