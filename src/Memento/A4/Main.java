package Memento.A4;

import Memento.A4.game.Gamer;
import Memento.A4.game.Memento;

public class Main {
    public static final String SAVEFILENAME = "C:\\Users\\Longguangtao\\Desktop\\dp3src_utf8_2021-11-02\\game.dat";

    public static void main(String[] args) {
        Gamer gamer = new Gamer(100);         // 最初の所持金は100

        // ファイルから読み込む
        Memento memento = Memento.loadFromFile(SAVEFILENAME);
        if (memento == null) {
            System.out.println("新規にスタートします。");
            memento = gamer.createMemento();  // 最初の状態を保存しておく
        } else {
            System.out.println("前回保存した結果からスタートします。");
            gamer.restoreMemento(memento);
        }

        // ゲームスタート
        for (int i = 0; i < 100; i++) {
            System.out.println("==== " + i);        // 回数表示
            System.out.println("現状:" + gamer);    // 現在の主人公の状態表示

            // ゲームを進める
            gamer.bet();

            System.out.println("所持金は" + gamer.getMoney() + "円になりました。");

            // Mementoの取り扱いの決定
            if (gamer.getMoney() > memento.getMoney()) {
                System.out.println("※だいぶ増えたので、現在の状態を保存しておこう！");
                memento = gamer.createMemento();
                // ファイルへ書き込む
                if (Memento.saveToFile(SAVEFILENAME, memento)) {
                    System.out.println("現在の状態をファイルに保存しました。");
                }
            } else if (gamer.getMoney() < memento.getMoney() / 2) {
                System.out.println("※だいぶ減ったので、以前の状態を復元しよう！");
                gamer.restoreMemento(memento);
            }

            // 時間待ち
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
            System.out.println();
        }
    }
}
