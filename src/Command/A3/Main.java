package Command.A3;

import java.awt.event.*;
import javax.swing.*;

import Command.A3.command.Command;
import Command.A3.command.MacroCommand;
import Command.A3.drawer.DrawCanvas;
import Command.A3.drawer.DrawCommand;

public class Main extends JFrame {
    // 描画履歴
    private MacroCommand history = new MacroCommand();
    // 描画領域
    private DrawCanvas canvas = new DrawCanvas(400, 400, history);
    // 消去ボタン
    private JButton clearButton  = new JButton("clear");

    // コンストラクタ
    public Main(String title) {
        super(title);

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        canvas.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                Command cmd = new DrawCommand(canvas, e.getPoint());
                history.append(cmd);
                cmd.execute();
            }
        });

        clearButton.addActionListener(e -> {
            history.clear();
            canvas.repaint();
        });

        Box buttonBox = new Box(BoxLayout.X_AXIS);
        buttonBox.add(clearButton);
        Box mainBox = new Box(BoxLayout.Y_AXIS);
        mainBox.add(buttonBox);
        mainBox.add(canvas);
        getContentPane().add(mainBox);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main("Command Pattern Sample");
    }
}
