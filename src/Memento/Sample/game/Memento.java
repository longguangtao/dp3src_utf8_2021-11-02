package Memento.Sample.game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Memento implements Serializable{
    private int money;            // 所持金
    private List<String> fruits;  // フルーツ
    private int number;

    int getNumber() {
        return this.number;
    }

    private void setNumber(int number) {
        this.number = number;
    }

    // 所持金を得る(narrow interface)
    public int getMoney() {
        return money;
    }

    // コンストラクタ(wide interface)
    Memento(int money) {
        this.money = money;
        setNumber(++number);
        this.fruits = new ArrayList<>();
    }

    // フルーツを追加する(wide interface)
    void addFruit(String fruit) {
        fruits.add(fruit);
    }

    

    // フルーツを得る(wide interface)
    List<String> getFruits() {
         return new ArrayList<>(fruits);
    }
}
