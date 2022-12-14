package Command.A1.drawer;

import java.awt.Color;

import Command.A1.command.Command;

public class ColorCommand implements Command {
    // 描画対象
    protected Drawable drawable;
    // 描画色
    private Color color;

    // コンストラクタ
    public ColorCommand(Drawable drawable, Color color) {
        this.drawable = drawable;
        this.color = color;
    }

    // 実行
    @Override
    public void execute() {
        drawable.setColor(color);
    }
}
