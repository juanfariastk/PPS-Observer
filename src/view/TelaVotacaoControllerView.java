package view;

import model.EnqueteSimples;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaVotacaoControllerView implements ActionListener {
    private EnqueteSimples enquete;

    public TelaVotacaoControllerView(EnqueteSimples enquete) {
        this.enquete = enquete;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int opcaoIndex = Integer.parseInt(e.getActionCommand());
        enquete.votar(opcaoIndex);
    }
}
