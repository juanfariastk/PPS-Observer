package view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class TelaVotacao extends JFrame {
    public TelaVotacao(String[] opcoes, ActionListener controller) {
        setTitle("Votação");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Escolha sua opção:");
        panel.add(label);

        for (int i = 0; i < opcoes.length; i++) {
            JButton button = new JButton(opcoes[i]);
            button.setActionCommand(String.valueOf(i));
            button.addActionListener(controller);
            panel.add(button);
        }

        add(panel);
        setLocationRelativeTo(null);
    }
}

