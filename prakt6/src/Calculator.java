import javax.swing.*;
import java.awt.*;
import java.util.regex.Pattern;

public class Calculator extends JFrame {
    private JLabel label;
    private boolean wasCounted = false;


    public Calculator() {
        super("Калькулятор");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Pattern pattern = Pattern.compile("\\s");

        setLayout(new BorderLayout());
        label = new JLabel("0");
        add(label, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        GridLayout grid = new GridLayout(4, 3);
        panel.setLayout(grid);

        JButton button0 = new JButton("0");
        JButton button1 = new JButton("1");
        JButton button2 = new JButton("2");
        JButton button3 = new JButton("3");
        JButton buttonSum = new JButton("+");
        JButton button4 = new JButton("4");
        JButton button5 = new JButton("5");
        JButton button6 = new JButton("6");
        JButton buttonSubtraction = new JButton("-");
        JButton button7 = new JButton("7");
        JButton button8 = new JButton("8");
        JButton button9 = new JButton("9");
        JButton buttonMultiplication = new JButton("*");
        JButton buttonEquals = new JButton("=");
        JButton buttonDivision = new JButton("/");
        JButton buttonClear = new JButton("D");

        panel.add(button7);
        panel.add(button8);
        panel.add(button9);
        panel.add(buttonDivision);

        panel.add(button4);
        panel.add(button5);
        panel.add(button6);
        panel.add(buttonMultiplication);

        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(buttonSubtraction);
        panel.add(button0);
        panel.add(buttonEquals);
        panel.add(buttonClear);
        panel.add(buttonSum);


        add(panel, BorderLayout.CENTER);
        setVisible(true);

        button0.addActionListener(e -> numberButton(button0));
        button1.addActionListener(e -> numberButton(button1));
        button2.addActionListener(e -> numberButton(button2));
        button3.addActionListener(e -> numberButton(button3));
        button4.addActionListener(e -> numberButton(button4));
        button5.addActionListener(e -> numberButton(button5));
        button6.addActionListener(e -> numberButton(button6));
        button7.addActionListener(e -> numberButton(button7));
        button8.addActionListener(e -> numberButton(button8));
        button9.addActionListener(e -> numberButton(button9));
        buttonSum.addActionListener(e -> operatorButton(buttonSum));
        buttonSubtraction.addActionListener(e -> operatorButton(buttonSubtraction));
        buttonMultiplication.addActionListener(e -> operatorButton(buttonMultiplication));
        buttonDivision.addActionListener(e -> operatorButton(buttonDivision));
        buttonClear.addActionListener(e -> label.setText("0"));
        buttonEquals.addActionListener(e -> {
            String[] strings = pattern.split(label.getText(), 3);
            int a = Integer.parseInt(strings[0]);
            int b = Integer.parseInt(strings[2]);
            String op = strings[1];
            switch (op) {
                case "+" -> label.setText(Integer.toString(a + b));
                case "-" -> label.setText(Integer.toString(a - b));
                case "*" -> label.setText(Integer.toString(a * b));
                case "/" -> label.setText(Integer.toString(a / b));
            }
            wasCounted = true;
        });
    }

    private void numberButton(JButton b) {
        if (label.getText() == "0" || wasCounted) {
            label.setText(b.getText());
            wasCounted = false;
        }
        else
            label.setText(label.getText() + b.getText());
    }

    private void operatorButton(JButton b) {
        String[] strings = label.getText().split("\\s");
        if (strings.length < 2)
            label.setText(label.getText() + " " + b.getText() + " ");
    }
}
