package model;

import java.util.ArrayList;
import java.util.List;

public class EnqueteSimples {
    private String[] opcoes;
    private List<EnqueteListener> listeners;
    private int[] votos;

    public EnqueteSimples(String[] opcoes) {
        this.opcoes = opcoes;
        this.votos = new int[opcoes.length];
        this.listeners = new ArrayList<>();
    }

    public String[] getOpcoes() {
        return opcoes;
    }

    public int getTotalVotos() {
        int total = 0;
        for (int voto : votos) {
            total += voto;
        }
        return total;
    }

    public int getVotos(int opcaoIndex) {
        return votos[opcaoIndex];
    }

    public void addEnqueteListener(EnqueteListener listener) {
        listeners.add(listener);
    }

    public void disparaNovoVoto(int opcaoIndex) {
        EnqueteEvent event = new EnqueteEvent(opcoes[opcaoIndex], this);
        for (EnqueteListener listener : listeners) {
            listener.novoVoto(event);
        }
    }

    public void disparaNovaOpcao(String novaOpcao) {
        EnqueteEvent event = new EnqueteEvent(novaOpcao, this);
        for (EnqueteListener listener : listeners) {
            listener.novaOpcao(event);
        }
    }

    public void votar(int opcaoIndex) {
        votos[opcaoIndex]++;
        disparaNovoVoto(opcaoIndex);
    }
}

