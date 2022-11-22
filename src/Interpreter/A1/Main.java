package Interpreter.A1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Interpreter.A1.language.InterpreterFacade;
import Interpreter.A1.language.ParseException;
import Interpreter.A1.turtle.TurtleCanvas;
import Interpreter.A1.turtle.TurtleExecutorFactory;

public class Main extends JFrame {
    private TurtleCanvas canvas = new TurtleCanvas(400, 400);
    private InterpreterFacade facade = new InterpreterFacade(new TurtleExecutorFactory(canvas));
    private TextField programTextField = new TextField("program repeat 3 go right go left end end");

    // コンストラクタ
    public Main(String title) {
        super(title);

        canvas.setExecutor(facade);

        setLayout(new BorderLayout());

        programTextField.addActionListener(e -> parseAndExecute());

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        add(programTextField, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);
        pack();
        setVisible(true);

        parseAndExecute();
    }

    private void parseAndExecute() {
        String programText = programTextField.getText();
        System.out.println("programText = " + programText);
        try {
            facade.parse(programText);
            canvas.repaint();
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new Main("Interpreter Pattern Sample");
    }
}
