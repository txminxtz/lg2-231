package bolsa;

//import java.time.LocalDate;
//import java.time.LocalDateTime;

public class Bolsa  {

    private Lista l_Ativos;
    private Lista l_Corretoras;
    private Lista l_Investidores;
    private Lista l_Contas;
    private Lista l_Investimentos;
    private Lista l_Ordens;
    private Lista l_Negociacoes;

    public Bolsa() 
    {
        l_Ativos = new Lista("ATIVOS");
        l_Corretoras = new Lista("CORRETORAS");
        l_Investidores = new Lista("INVESTIDORES");
        l_Contas = new Lista("CONTAS");
        l_Investimentos = new Lista("INVESTIMENTOS");
        l_Ordens = new Lista("ORDENS");
        l_Negociacoes = new Lista("NEGOCIACOES");
 
    }

    public Lista getAtivos() {
        return l_Ativos;
    }

    public Lista getCorretoras() {
        return l_Corretoras;
    }

    public Lista getInvestidores() {
        return l_Investidores;
    }

    public Lista getContas() {
        return l_Contas;
    }

    public Lista getInvestimentos() {
        return l_Investimentos;
    }

    public Lista getOrdens() {
        return l_Ordens;
    }

    public Lista getNegociacoes() {
        return l_Negociacoes;
    }

    public void cadastraOrdem( 
        String sTipo,
        int iCod, 
        Conta conta,
        Ativo ativo, 
        int iQt, 
        Double dPreco) {

        Ordem ordem;
        String sCod, sAtivo, sPreco, sIndexador, sAux;
        int iQt_I;
        No no;
        Investimento investimento;
        Lista lista;

        sAux = "CV";

        if (!sAux.contains(sTipo)) return;

////////////////////////////////////
        
        if (sTipo == "V") {
        
            lista = conta.getInvestimentos();

            if (lista == null) {
                System.out.println("O vendedor nao possui Investimentos");
                return;
            }

            // Procura o investimento no vendedor

            sIndexador = 
                conta.getCorretora().getCod() + "-" +
                conta.getInvestidor().getCod() + "-" +
                ativo.getCod();

            no = lista.procuraNo(sIndexador, "<>");

            if (no == null) {
                System.out.println(
                    "Investimento nao encontrado: " + 
                    sIndexador);
                return;
            }

            investimento = (Investimento)no.getElemento();
            
            iQt_I = investimento.getQt();

            if (iQt > iQt_I){
                System.out.println("Quantidade Indisponível para Venda: " + iQt);
                return;
            }

        }


//////////////////////////////////////////        
        // Cria a ordem

        sCod = String.format("%03d", iCod);
        sAtivo = ativo.getCod();
        sPreco = String.format("%05d", (int)(dPreco*100));

        sIndexador = sTipo+sAtivo+sPreco;

        ordem = new Ordem(sTipo, sCod, conta, ativo , iQt, dPreco);

	    if (sTipo=="C") {
            l_Ordens.inserirFilaCrescente(ordem, sIndexador);
        }
        else {
            l_Ordens.inserirPilhaCrescente(ordem, sIndexador);
        }

        verificaNegociacao(ativo);

    }

    public void verificaNegociacao(Ativo ativo) {

        No no_C, no_V, no_I;
        Ordem ordem_C, ordem_V;
        Conta conta;
        Investimento investimento;
        Negociacao negociacao;
        Lista lista;

        String sCod, sCod_C, sCod_V, sAtivo, sIndexador;
        double dPreco_C, dPreco_V, dPreco, dTotal;
        int iQt_C_executada, iQt_V_executada, iAux, iQt_C_restante, iQt_V_restante, iQt_I, iQt;

        // Veriafica se é possível haver negociação

        sAtivo = ativo.getCod();

        if (l_Ordens == null) return;

        no_C = l_Ordens.procuraNo("C"+sAtivo, ">");
        no_V = l_Ordens.procuraNo("V"+sAtivo, "<");

        while (no_C!=null && no_V!= null) {

            ordem_V = (Ordem)no_V.getElemento();
            ordem_C = (Ordem)no_C.getElemento();

            dPreco_V = ordem_V.getPreco();
            dPreco_C = ordem_C.getPreco();

            if (dPreco_C < dPreco_V) break;

            // há condicao de negociacao

            sCod_V = ordem_V.getCod(); 
            iQt_V_executada = ordem_V.getQt_executada();
            iQt_V_restante = ordem_V.getQt_resante();

            sCod_C = ordem_C.getCod(); 
            iQt_C_executada = ordem_C.getQt_executada();
            iQt_C_restante = ordem_C.getQt_resante();

            if (sCod_C.compareTo(sCod_V)<0) dPreco = dPreco_C;
            else                            dPreco = dPreco_V;

            if (iQt_C_restante < iQt_V_restante)    iQt = iQt_C_restante;
            else                                    iQt = iQt_V_restante;

            dTotal = iQt * dPreco;        
    
            // Cria a negociacao

            iAux = l_Negociacoes.getQt();
            iAux++;

            sCod = String.format("%03d", iAux);

            negociacao = new Negociacao(
                "Negociacao",
                sCod, 
                ordem_C, 
                ordem_V, 
                iQt, 
                dPreco);

            l_Negociacoes.inserirFilaCrescente(negociacao, sCod);

            // Procura o investimento no vendedor

            conta = ordem_V.getConta();
            if (conta == null) return;

            conta.depositaValor(dTotal);

            lista = conta.getInvestimentos();

            if (lista == null) {
                System.out.println(
                        "O vendedor nao possui Investimentos");
                return;
            }

            sIndexador = 
                conta.getCorretora().getCod() + "-" +
                conta.getInvestidor().getCod() + "-" +
                ativo.getCod();

            no_I = lista.procuraNo(sIndexador, "<>");

            if (no_I == null) {
                System.out.println("Investimento nao encontrado: " + sIndexador);
                return;
            }

            investimento = (Investimento)no_I.getElemento();
            
            iQt_I = investimento.getQt();
            iQt_I -= iQt;
            investimento.setQt(iQt_I);

            
            // Procura o investimento no comprador
            
            conta = ordem_C.getConta();
            if (conta == null) return;
            
            conta.resgataValor(dTotal);

            lista = conta.getInvestimentos();

            if (lista == null) no_I = null;
            else
            {

                sIndexador = 
                    conta.getCorretora().getCod() + "-" +
                    conta.getInvestidor().getCod() + "-" +
                    ativo.getCod();

                no_I = lista.procuraNo(sIndexador, ">");

            }

            if (no_I != null) {

                // Atualiza a quantidade

                investimento = (Investimento)no_I.getElemento();
            
            	iQt_I = investimento.getQt();
            	iQt_I += iQt;
            	investimento.setQt(iQt_I);

            }
            else
            {

                // Cria o investimento para o comprador
                
                iAux = l_Investimentos.getQt();
                iAux++;

                sCod = String.format("%03d", iAux);

                investimento = new Investimento(
                    "Investimento",
                    sCod, 
                    ordem_C.getConta(), 
                    ativo , 
                    iQt, 
                    dPreco);
                
                l_Investimentos.inserirPilhaCrescente(investimento, investimento.getCod());

            }

            // Atualiza Ordens

            iQt_C_restante -= iQt;
            iQt_V_restante -= iQt;
            iQt_C_executada += iQt;
            iQt_V_executada += iQt;
            
            ordem_C.setQt_restante(iQt_C_restante);
            ordem_V.setQt_restante(iQt_V_restante);
            ordem_C.setQt_executada(iQt_C_executada);
            ordem_V.setQt_executada(iQt_V_executada);

            if (iQt_C_restante==0) l_Ordens.removeNo(no_C);
            if (iQt_V_restante==0) l_Ordens.removeNo(no_V);

            no_C = l_Ordens.procuraNo("C"+sAtivo, ">");
            no_V = l_Ordens.procuraNo("V"+sAtivo, "<");

        }

    }

    
}


