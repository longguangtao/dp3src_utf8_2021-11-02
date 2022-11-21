package Memento.Sample;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Memento.Sample.game.Gamer;
import Memento.Sample.game.Memento;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        Gamer gamer = new Gamer(100); // 最初の所持金は100
        Memento memento;
        String fileName = "C:\\Users\\Longguangtao\\Desktop\\dp3src_utf8_2021-11-02\\game.dat";

        FileInputStream fileInputStream = null;
        ObjectInputStream inputStream = null;
        try {
            fileInputStream = new FileInputStream(fileName);
            inputStream = new ObjectInputStream(fileInputStream);
        } catch (EOFException e) {
            if (fileInputStream != null) {
                fileInputStream.close();
            }
        } finally {
            if (inputStream == null) {
                memento = gamer.initMemento(); // 最初の状態を保存しておく
            } else {
                Object readObject = inputStream.readObject();
                memento = (Memento) readObject;
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }

        

        // ゲームスタート
        for (int i = 0; i < 100; i++) {
            System.out.println("==== " + i); // 回数表示
            System.out.println("現状:" + gamer); // 現在の主人公の状態表示

            // ゲームを進める
            gamer.bet();

            System.out.println("所持金は" + gamer.getMoney() + "円になりました。");

            // Mementoの取り扱いの決定
            if (gamer.getMoney() > memento.getMoney()) {
                System.out.println("※だいぶ増えたので、現在の状態を保存しておこう！");
                memento = gamer.createMemento();
                ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(fileName));
                output.writeObject(memento);
                output.close();
            } else if (gamer.getMoney() < memento.getMoney() / 2) {
                System.out.println("※だいぶ減ったので、以前の状態を復元しよう！");
                gamer.restoreMemento(memento);
            }

            // 時間待ち
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println();
        }
    }
}
