package model;

public class EnqueteEvent {
    private String opcao;
    private EnqueteSimples enquete;

    public EnqueteEvent(String opcao, EnqueteSimples enquete) {
        this.opcao = opcao;
        this.enquete = enquete;
    }

    public String getOpcao() {
        return opcao;
    }

    public EnqueteSimples getEnquete() {
        return enquete;
    }
}

