package view;

import model.EnqueteEvent;
import model.EnqueteListener;

import javax.swing.*;

public class TelaResultado extends JFrame implements EnqueteListener {
    private JTextArea textArea;

    public TelaResultado() {
        setTitle("Resultados");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);

        textArea = new JTextArea();
        textArea.setEditable(false);
        add(new JScrollPane(textArea));

        setLocationRelativeTo(null);
    }

    @Override
    public void novoVoto(EnqueteEvent event) {
        StringBuilder resultado = new StringBuilder();
        resultado.append("Novo voto para: ").append(event.getOpcao()).append("\n");

        for (int i = 0; i < event.getEnquete().getOpcoes().length; i++) {
            resultado.append(event.getEnquete().getOpcoes()[i])
                    .append(": ")
                    .append(event.getEnquete().getVotos(i))
                    .append(" votos\n");
        }

        textArea.setText(resultado.toString());
    }

    @Override
    public void novaOpcao(EnqueteEvent event) {
    }
}

