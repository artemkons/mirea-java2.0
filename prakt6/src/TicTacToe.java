import javax.swing.*;
import java.awt.*;

public class TicTacToe extends JFrame {
    private boolean isCrossNext = true;
    private final JButton[][] buttons;
    private int moveNum = 0;
    private JLabel label;

    TicTacToe() {
        super("Крестики-нолики");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());
        label = new JLabel();
        add(label, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        GridLayout grid = new GridLayout(3, 3);
        panel.setLayout(grid);
        add(panel, BorderLayout.CENTER);

        JButton button1 = new JButton("");
        JButton button2 = new JButton("");
        JButton button3 = new JButton("");
        JButton button4 = new JButton("");
        JButton button5 = new JButton("");
        JButton button6 = new JButton("");
        JButton button7 = new JButton("");
        JButton button8 = new JButton("");
        JButton button9 = new JButton("");

        buttons = new JButton[][]{
                {button1, button2, button3},
                {button4, button5, button6},
                {button7, button8, button9}};

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                panel.add(buttons[i][j]);
                int finalI = i;
                int finalJ = j;

                buttons[i][j].addActionListener(
                        e -> buttonLogic(buttons[finalI][finalJ], finalI, finalJ));
            }
        }

        add(panel);
        setVisible(true);

    }

    private void buttonLogic(JButton button, int x, int y) {
        if (button.getText().equals("")) {
            if (isCrossNext) {
                button.setText("X");

                if (isRowFull(x, "X")) {
                    label.setText("Первый игрок заполнил строку и победил!");
                    clearField();
                }
                if (isColumnFull(y, "X")) {
                    label.setText("Первый игрок заполнил колонку и победил!");
                    clearField();
                }
                if (isDiagonalFull(x, y, "X")) {
                    label.setText("Первый игрок заполнил диагональ и победил!");
                    clearField();
                }

            } else {
                button.setText("O");

                if (isRowFull(x, "O")) {
                    label.setText("Второй заполнил строку игрок победил!");
                    clearField();
                }
                if (isColumnFull(y, "O")) {
                    label.setText("Второй игрок заполнил колонку и победил!");
                    clearField();
                }
                if (isDiagonalFull(x, y, "O")) {
                    label.setText("Второй игрок заполнил диагональ и победил!");
                    clearField();
                }
            }
            moveNum++;
            if (moveNum == 9) {
                System.out.println("Игра окончена!");
            }
        }
        isCrossNext = !isCrossNext;
    }

    private boolean isRowFull(int x, String sign) {
        for (int i = 0; i < 3; i++) {
            if (buttons[x][i].getText() != sign)
                return false;
        }
        return true;
    }

    private boolean isColumnFull(int y, String sign) {
        for (int i = 0; i < 3; i++) {
            if (buttons[i][y].getText() != sign)
                return false;
        }
        return true;
    }

    private boolean isDiagonalFull(int x, int y, String sign) {

        if (x == y) {
            for (int i = 0; i < 3; i++) {
                if (buttons[i][i].getText() != sign)
                    return false;
            }

            return true;
        } else if (x + y == 2) {
            int j = 2;

            for (int i = 0; i < 3; i++) {
                if (buttons[i][j--].getText() != sign)
                    return false;
            }

            return true;
        }

        return false;
    }

    private void clearField() {
        moveNum = 0;
        isCrossNext = false;
        for (JButton[] a : buttons) {
            for (JButton b : a) {
                b.setText("");
            }
        }
    }
}

