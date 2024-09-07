import model.EnqueteSimples;
import view.TelaResultado;
import view.TelaResultadoPercentual;
import view.TelaVotacao;
import view.TelaVotacaoControllerView;

public class Main {
    public static void main(String[] args) {

        String[] opcoes = {"Opção 1", "Opção 2", "Opção 3"};
        EnqueteSimples enquete = new EnqueteSimples(opcoes);


        TelaVotacaoControllerView controller = new TelaVotacaoControllerView(enquete);


        TelaVotacao telaVotacao = new TelaVotacao(opcoes, controller);
        telaVotacao.setVisible(true);


        TelaResultado telaResultado = new TelaResultado();
        telaResultado.setVisible(true);

        TelaResultadoPercentual telaResultadoPercentual = new TelaResultadoPercentual();
        telaResultadoPercentual.setVisible(true);


        enquete.addEnqueteListener(telaResultado);
        enquete.addEnqueteListener(telaResultadoPercentual);
    }
}
