import javax.swing.*;
import java.awt.event.*;

public class MyForm extends JFrame {
    private int firstTeamScore = 0, secondTeamScore = 0;

    MyForm() {
        super("Title");
        setVisible(true);
        setSize(600, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        add(panel);

        JTextField result = new JTextField("Результат матча", 100);
        panel.add(result);

        JButton add1 = new JButton("Прибавить первой команде");
        panel.add(add1);
        JButton add2 = new JButton("Прибавить второй команде");
        panel.add(add2);
        JButton showResult = new JButton("Показать результат");
        panel.add(showResult);

        add1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstTeamScore++;
            }
        });
        add2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                secondTeamScore++;
            }
        });
        showResult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                result.setText(firstTeamScore + " : " + secondTeamScore);
            }
        });

    }
}
