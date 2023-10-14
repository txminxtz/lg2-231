package bolsa;

public class Investimento extends Negocio {

    public Investimento (
        String sTipo,
        String cod, 
        Conta conta,
        Ativo ativo, 
        int qt, 
        Double preco) {

        super (sTipo, cod, conta, ativo, qt, preco);

        String sIndexador = 
            conta.getCorretora().getCod() + "-" +
            conta.getInvestidor().getCod() + "-" +
            ativo.getCod();

        conta.getInvestimentos().inserirPilhaCrescente(this , sIndexador);

    }    

}


