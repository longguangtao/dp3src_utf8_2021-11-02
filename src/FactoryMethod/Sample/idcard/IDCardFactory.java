package FactoryMethod.Sample.idcard;

import FactoryMethod.Sample.framework.Factory;
import FactoryMethod.Sample.framework.Product;

public class IDCardFactory extends Factory {
    @Override
    protected Product createProduct(String owner) {
        return new IDCard(owner);
    }

    @Override
    protected void registerProduct(Product product) {
        System.out.println(product + "を登録しました。");
    }
}
