package view;

import model.EnqueteEvent;
import model.EnqueteListener;

import javax.swing.*;

public class TelaResultadoPercentual extends JFrame implements EnqueteListener {
    private JTextArea textArea;

    public TelaResultadoPercentual() {
        setTitle("Resultados Percentuais");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);

        textArea = new JTextArea();
        textArea.setEditable(false);  // O usuário não pode editar o texto
        add(new JScrollPane(textArea));  // Adiciona uma área de rolagem para o JTextArea

        setLocationRelativeTo(null);  // Centraliza a janela na tela
    }

    @Override
    public void novoVoto(EnqueteEvent event) {
        StringBuilder resultado = new StringBuilder();
        int totalVotos = event.getEnquete().getTotalVotos();
        resultado.append("Novo voto para: ").append(event.getOpcao()).append("\n");

        for (int i = 0; i < event.getEnquete().getOpcoes().length; i++) {
            double percentual = ((double) event.getEnquete().getVotos(i) / totalVotos) * 100;
            resultado.append(event.getEnquete().getOpcoes()[i])
                    .append(": ")
                    .append(String.format("%.2f", percentual))
                    .append("% dos votos\n");
        }

        textArea.setText(resultado.toString());
    }

    @Override
    public void novaOpcao(EnqueteEvent event) {
    }
}

