package Command.Sample;

import java.awt.event.*;
import java.awt.event.MouseMotionAdapter;
import javax.swing.*;

import Command.Sample.command.Command;
import Command.Sample.command.MacroCommand;
import Command.Sample.drawer.DrawCanvas;
import Command.Sample.drawer.DrawCommand;

public class Main extends JFrame {
    // 描画履歴
    private MacroCommand history = new MacroCommand();
    // 描画領域
    private DrawCanvas canvas = new DrawCanvas(400, 400, history);
    // 消去ボタン
    private JButton clearButton = new JButton("clear");

    // コンストラクタ
    public Main(String title) {
        super(title);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        canvas.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
            }

            @Override
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

    // MouseMotionListener用
    // @Override
    // public void mouseMoved(MouseEvent e) {
    // }

    // @Override
    // public void mouseDragged(MouseEvent e) {
    // Command cmd = new DrawCommand(canvas, e.getPoint());
    // history.append(cmd);
    // cmd.execute();
    // }

    // WindowListener用
    // @Override
    // public void windowClosing(WindowEvent e) {
    // System.exit(0);
    // }

    // @Override public void windowActivated(WindowEvent e) {}
    // @Override public void windowClosed(WindowEvent e) {}
    // @Override public void windowDeactivated(WindowEvent e) {}
    // @Override public void windowDeiconified(WindowEvent e) {}
    // @Override public void windowIconified(WindowEvent e) {}
    // @Override public void windowOpened(WindowEvent e) {}

    public static void main(String[] args) {
        new Main("Command Pattern Sample");
    }
}
