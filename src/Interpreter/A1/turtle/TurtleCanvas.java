package Interpreter.A1.turtle;

import Interpreter.A1.language.Executor;
import java.awt.*;

public class TurtleCanvas extends Canvas {
    final static int UNIT_LENGTH = 30;    // 動くときの単位長さ
    final static int DIRECTION_UP = 0;    // 上向き
    final static int DIRECTION_RIGHT = 3; // 右向き
    final static int DIRECTION_DOWN = 6;  // 下向き
    final static int DIRECTION_LEFT = 9;  // 左向き
    final static int RELATIVE_DIRECTION_RIGHT = 3; // 右に向く
    final static int RELATIVE_DIRECTION_LEFT = -3; // 左に向く
    final static int RADIUS = 3; // 半径

    private int direction = 0;
    private Point position;
    private Executor executor = null;

    public TurtleCanvas(int width, int height) {
        setSize(width, height);
        initialize();
    }

    private void initialize() {
        Dimension size = getSize();
        position = new Point(size.width / 2, size.height / 2);
        direction = 0;
        setForeground(Color.red);
        setBackground(Color.white);
        Graphics g = getGraphics();
        if (g != null) {
            g.clearRect(0, 0, size.width, size.height);
        }
    }

    public void setExecutor(Executor executor) {
        this.executor = executor;
    }

    void setRelativeDirection(int relativeDirection) {
        setDirection(direction + relativeDirection);
    }

    void setDirection(int direction) {
        if (direction < 0) {
            direction = 12 - (-direction) % 12;
        } else {
            direction = direction % 12;
        }
        this.direction = direction % 12;
    }

    void go(int length) {
        int newx = position.x;
        int newy = position.y;
        switch (direction) {
        case DIRECTION_UP:
            newy -= length;
            break;
        case DIRECTION_RIGHT:
            newx += length;
            break;
        case DIRECTION_DOWN:
            newy += length;
            break;
        case DIRECTION_LEFT:
            newx -= length;
            break;
        default:
            break;
        }
        Graphics g = getGraphics();
        if (g != null) {
            g.drawLine(position.x, position.y, newx, newy);
            g.fillOval(newx - RADIUS, newy - RADIUS, RADIUS * 2 + 1, RADIUS * 2 + 1);
        }
        position.x = newx;
        position.y = newy;
    }

    @Override
    public void paint(Graphics g) {
        initialize();
        if (executor != null) {
            executor.execute();
        }
    }
}
