package bolsa;

import java.util.Scanner;

public class MenuAux 
{

    private Bolsa bolsa;
    private Scanner l;

    public MenuAux(Bolsa bolsa){

        this.bolsa = bolsa;
        l = new Scanner(System.in);

    }

    ////////////
    /////// RELATORIOS

    // RELATORIO
    public void relatorio(String sTipo) { 

        // Verifica se tipo valido

        switch(sTipo) {
        case "ATIVOS":
            break;
        case "CORRETORAS":
            break;
        case "INVESTIDORES":
            break;
        case "CONTAS":
            break;
        case "IMVESTIMENTOS":
            break;
        case "ORDENS":
            break;
        case "NEGOCIACOES":
            break;
        default:
            System.out.println("Opcao Invalida: " + sTipo);
            return;
        }

        System.out.println();
        System.out.println("RELATORIO DE " + sTipo);
        System.out.println();

        //Exibe os registros cadastrados

        switch(sTipo) {
        case "ATIVOS":
            this.bolsa.getAtivos().exibeComponentes(0, true);
            break;
        case "CORRETORAS":
            this.bolsa.getCorretoras().exibeComponentes(0, true);
            break;
        case "INVESTIDORES":
            this.bolsa.getInvestidores().exibeComponentes(0, true);
            break;
        case "CONTAS":
            this.bolsa.getContas().exibeComponentes(0, true);
            break;
        case "IMVESTIMENTOS":
            this.bolsa.getInvestimentos().exibeComponentes(0, true);
            break;
        case "ORDENS":
            this.bolsa.getOrdens().exibeComponentes(0, false);
            break;
        case "NEGOCIACOES":
            this.bolsa.getNegociacoes().exibeComponentes(0, true);
            break;
        default:
            System.out.println("Opcao Invalida: " + sTipo);
            return;
        }

        System.out.println();
        textInput("Precione <Enter> para continuar.");

    }


    ////////////
    /////// ENTRADA DE DADOS

    // CADASTRO DE ATIVOS
    public boolean dadosInput_Ativo(){ 

        String sCod, sNome;
        //double dPreco;
        //int iQt;
        String sAux; 

        System.out.println("Cadastro de Ativos");
        System.out.println();

        sCod = this.NaoQuero_Elemento(
            this.bolsa.getAtivos(), 
            "Codigo: ",  
            l);

        if (sCod == "") return false;
    
        sCod = sCod.toUpperCase();

        //sCod = textInput("Codigo: ",l);
        sNome = textInput("Nome: ");
        //sQt = textInput("Quantidade: ",l);
        //sPreco = textInput("Preco: ",l);

        //iQt = Integer.parseInt(sQt);
        //iQt = 0;
        //dPreco = Double.parseDouble(sPreco);

        sAux = textInput("Adicionar Ativo (S/N) ? ");

        if  (sAux.equalsIgnoreCase("s")==false){
            return false;
        }

        Ativo ativo;

        ativo = new Ativo(sCod, sNome);
 
        this.bolsa.getAtivos().inserirPilhaCrescente(ativo, ativo.getCod());

        return true;

    }

    // CADASTRO DE CORRETORAS
    public boolean dadosInput_Corretora(){ 

        String sCod, sNome;
        String sAux;

        System.out.println("Cadastro de Corretoras");
        System.out.println();

        int iAux = this.bolsa.getCorretoras().getQt();
        iAux++;

        sCod = String.format("%03d", iAux);

        System.out.println("Codigo: "+sCod);

        sNome = textInput("Nome: ");

        sAux = textInput("Adicionar Corretora (S/N) ? ");

        if  (sAux.equalsIgnoreCase("s")==false){
            return false;
        }

        Corretora corretora;

        corretora = new Corretora(sCod, sNome);
 
        this.bolsa.getCorretoras().inserirPilhaCrescente(corretora, corretora.getCod());

        return true;

    }

    // CADASTRO DE INVESTIDORES
    public boolean dadosInput_Investidor(){ 

        String sCod, sNome, sCPF;;
        String sAux; 

        System.out.println("Cadastro de Investidores");
        System.out.println();

        int iAux = this.bolsa.getInvestidores().getQt();
        iAux++;

        sCod = String.format("%03d", iAux);

        System.out.println("Codigo: "+sCod);

        //sCod = textInput("Cod: ",l);

        sNome = textInput("Nome: ");
        sCPF = textInput("CPF: ");

        sAux = textInput("Adicionar Investidor (S/N) ? ");

        if  (sAux.equalsIgnoreCase("s")==false){
            return false;
        }

        Investidor investidor;

        investidor = new Investidor(sCod, sNome, sCPF);
 
        this.bolsa.getInvestidores().inserirPilhaCrescente(investidor, investidor.getCod());

        return true;

    }


    // CADASTRO DE CONTAS
    public boolean dadosInput_Conta(){ 

        String sCod, sSaldo;
        double dSaldo;
        String sAux; 
        No no;
        Corretora corretora;
        Investidor investidor;

        System.out.println("Abertura de Contas");
        System.out.println();

        int iAux = this.bolsa.getContas().getQt();
        iAux++;

        sCod = String.format("%03d", iAux);

        System.out.println("Codigo: "+sCod);


        no = this.Quero_Elemento(
            this.bolsa.getCorretoras(), 
            "Corretora: ",  
            l);

        if (no==null) return false;

        corretora = (Corretora)no.getElemento();

        no = this.Quero_Elemento(
            this.bolsa.getInvestidores(), 
            "Investidor: ",  
            l);

        if (no==null) return false;

        investidor = (Investidor)no.getElemento();

        sSaldo = textInput("Saldo: ");

        dSaldo = Double.parseDouble(sSaldo);

        sAux = textInput("Adicionar Conta (S/N) ? ");

        if  (sAux.equalsIgnoreCase("s")==false){
            return false;
        }

        Conta conta;

        conta = new Conta(
            sCod, 
            corretora, 
            investidor, 
            dSaldo);

        this.bolsa.getContas().inserirPilhaCrescente(conta, conta.getCod());

        return true;

    }

    // OPA
    public boolean op_OPA(){ 

        String sQt;
        int iQt;
        Double dPreco;
        String sAux, sPreco;
        No no; 
        Ativo ativo;

        System.out.println("Oferta Publica de Acoes ");
        System.out.println();

        // Input: Ativo

        no = this.Quero_Elemento(
            this.bolsa.getAtivos(), 
            "Ativo: ",  
            l);

        if (no==null) return false;

        ativo= (Ativo)no.getElemento();

        // Input: Qt
        sQt = textInput("Quantidade: ");
        sPreco = textInput("Preco: ");

        iQt = Integer.parseInt(sQt);
        dPreco = Double.parseDouble(sPreco);

        // Input: Confirma (S/N)
        sAux = textInput("Confirma OPA (S/N) ? ");

        if  (sAux.equalsIgnoreCase("s")==false){
            return false;
        }

        ativo.addQt(iQt);
        ativo.setPreco(dPreco);

        return true;

    }

    // DEPOSITO EM CONTA
    public boolean op_Deposito_Conta(){ 

        String sValor;
        double dValor;
        String sAux;
        No no; 
        Conta conta;


        System.out.println("Deposito em Conta");
        System.out.println();

        // Input: Conta

        no = this.Quero_Elemento(
            this.bolsa.getContas(), 
            "Conta: ",  
            l);

        if (no==null) return false;

        conta = (Conta)no.getElemento();

        // Input: Valor
        sValor = textInput("Valor: ");
        dValor = Double.parseDouble(sValor);

        // Input: Confirma (S/N)
        sAux = textInput("Confirma Deposito (S/N) ? ");

        if  (sAux.equalsIgnoreCase("s")==false){
            return false;
        }

        conta.depositaValor(dValor);

        return true;

    }

    // COMPRA DE OPA
    public boolean op_Compra_OPA(){ 

        String sCod;
        double dPreco, dSaldo, dTotal;
        int iQt, iQt_disponivel;
        String sAux;
        No no; 
        Conta conta;
        Ativo ativo;

        System.out.println("Compra de OPA");
        System.out.println();

        // Input: Conta

        no = this.Quero_Elemento(
            this.bolsa.getContas(), 
            "Conta: ",  
            l);

        if (no==null) return false;

        conta = (Conta)no.getElemento();
	    dSaldo = conta.getSaldo();	

        System.out.println("Saldo em Conta: " + dSaldo);

        // Input: Ativo

        no = this.Quero_Elemento(
            this.bolsa.getAtivos(), 
            "Ativo: ",  
            l);

        if (no==null) return false;

        ativo = (Ativo)no.getElemento();
        iQt_disponivel = ativo.getQt_disponivel();
        dPreco = ativo.getPreco();

        System.out.println("Quantidade Disponivel: " + iQt_disponivel);
        System.out.println("Preco: " + dPreco);


        // Input: Qt
	    iQt = Quero_Qt_OPA(dSaldo, dPreco, iQt_disponivel, "Quantidade: ");

        if  (iQt == 0) return false;

        dTotal = iQt * dPreco;        

        System.out.println("Total: " + dTotal);


        // Input: Confirma (S/N)
        sAux = textInput("Confirma Compra de OPA (S/N) ? ");

        if  (sAux.equalsIgnoreCase("s")==false){
            return false;
        }

        iQt_disponivel -= iQt;

        int iAux = this.bolsa.getInvestimentos().getQt();
        iAux++;

        sCod = String.format("%03d", iAux);

        Investimento investimento;

        investimento = new Investimento(
            "Investimento",
            sCod, 
            (Conta) conta, 
            (Ativo) ativo , 
            iQt, 
            dPreco);

        ativo.getInvestimentos().inserirPilhaCrescente(investimento , sCod);
        ativo.setQt_disponivel(iQt_disponivel);

        conta.resgataValor(dTotal);

        this.bolsa.getInvestimentos().inserirPilhaCrescente(investimento, investimento.getCod());

        return true;

    }


    // CADASTRO DE ORDEM
    public boolean dadosInput_Ordem(){ 

        String sQt, sPreco, sTipo;
        double dPreco;
        int iQt, iCod;
        String sAux;
        No no; 
        Conta conta;
        Ativo ativo;


        System.out.println("Cadastro de Ordens");
        System.out.println();

        // Input: Tipo

        sTipo = this.Quero_Op();

        if (sTipo=="") return false;

        iCod = this.bolsa.getOrdens().getQt();
        iCod += 1;

        System.out.println("Codigo: "+iCod);

        // Input: Conta

        no = this.Quero_Elemento(
            this.bolsa.getContas(), 
            "Conta: ",  
            l);

        if (no==null) return false;

        conta = (Conta)no.getElemento();

        // Input: Ativo

        no = this.Quero_Elemento(
            this.bolsa.getAtivos(), 
            "Ativo: ",  
            l);

        if (no==null) return false;

        ativo = (Ativo)no.getElemento();

        // Input: Qt
        sQt = textInput("Quantidade: ");
        iQt = Integer.parseInt(sQt);

        // Input: Preco
        sPreco = textInput("Preco: ");
        dPreco = Double.parseDouble(sPreco);

        // Input: Confirma (S/N)
        sAux = textInput("Confirma Ordem de "+  sTipo + " (S/N) ? ");

        if  (sAux.equalsIgnoreCase("s")==false){
            return false;
        }

        bolsa.cadastraOrdem(
            sTipo, 
            iCod, 
            conta, 
            ativo, 
            iQt,  
            dPreco);

        return true;

    }

    // EDICAO DE ORDEM
    public boolean dadosEdicao_Ordem(){ 

        String sQt, sPreco;
        double dPreco;
        int iQt;
        String sAux;
        No no; 
        Conta conta;
        Ordem ordem;

        System.out.println("Edicao de Ordens");
        System.out.println();

        // Input: Conta

        no = this.Quero_Elemento(
            this.bolsa.getContas(), 
            "Conta: ",  
            l);

        if (no==null) return false;

        conta = (Conta)no.getElemento();

        // Input: Ordem

        no = this.Quero_Elemento(
            conta.getOrdens(), 
            "Ordem: ",  
            l);

        if (no==null) return false;

        ordem = (Ordem)no.getElemento();

        if (ordem.getQt_executada() > 0){
            textInput("Nao eh possivel editar a ordem. Tecle <enter>.");
            return false;
        }

        // Input: Qt
        sQt = textInput("Quantidade: ");
        iQt = Integer.parseInt(sQt);

        // Input: Preco
        sPreco = textInput("Preco: ");
        dPreco = Double.parseDouble(sPreco);

        // Input: Confirma (S/N)
        sAux = textInput("Confirma Edicao (S/N) ? ");

        if  (sAux.equalsIgnoreCase("s")==false){
            return false;
        }

        ordem.setQt(iQt);
        ordem.setQt_restante(iQt);
        ordem.setPreco(dPreco);

        this.bolsa.verificaNegociacao(ordem.getAtivo());

        return true;

    }


    // EXCLUSAO DE ORDEM
    public Boolean dadosExclusao_Ordem(){ 

        String sAux;
        No no; 
        Conta conta;
        Ordem ordem;
        Lista l_Ordens;

        System.out.println("Exclusao de Ordens");
        System.out.println();

        // Input: Conta

        no = this.Quero_Elemento(
            this.bolsa.getContas(), 
            "Conta: ",  
            l);

        if (no==null) return false;

        conta = (Conta)no.getElemento();

        // Input: Ordem

        no = this.Quero_Elemento(
            conta.getOrdens(), 
            "Ordem: ",  
            l);

        if (no==null) return false;

        ordem = (Ordem)no.getElemento();

        if (ordem.getQt_executada() > 0){
            textInput("Nao eh possivel excluir a ordem. Tecle <enter>.");
            return false;
        }

        // Input: Confirma (S/N)
        sAux = textInput("Confirma Exclusao (S/N) ? ");

        if  (sAux.equalsIgnoreCase("s")==false){
            return false;
        }

        //exclui da lista de ordens da bolsa

        l_Ordens = this.bolsa.getOrdens();

        no = l_Ordens.procuraNo_Ordem(ordem);
        
        if (no!=null) l_Ordens.removeNo(no);

        //exclui da lista de ordens da conta
        
        l_Ordens = conta.getOrdens();

        no = l_Ordens.procuraNo_Ordem(ordem);
        
        if (no!=null) l_Ordens.removeNo(no);

        return true;

    }

    ////////////
    /////// FUNÇÕES AUXILIARES

    public String NaoQuero_Elemento(Lista lista, String sLabel, Scanner l){ 

        No no; 

        String sAux="S", sCod;

        while (sAux.equalsIgnoreCase("s")) {

            sCod = textInput(sLabel);

            no =  lista.procuraNo(sCod, "<>");
            
            if (no == null) return sCod;

            sAux = this.textInput("Codigo Invalido. Deseja Continuar (S/N) ? ");

        }

        return "";

    }


    public No Quero_Elemento(Lista lista, String sLabel, Scanner l){ 

        No no;

        String sAux="S", sCod;

        while (sAux.equalsIgnoreCase("s")) {

            sCod = textInput(sLabel);

            no =  lista.procuraNo(sCod, "<>");

            if (no != null) return no;

            sAux = this.textInput(
                "Codigo Invalido. "+
                "Deseja Continuar (S/N) ? ");

        }

        return null;

    }


    public int Quero_Qt_OPA(
        double dSaldo, 
        double dPreco, 
        int iqt_disponivel, 
        String sLabel
        ){ 

        String sAux="S", sQt;
        int iQt;
        double dTotal;


        while (sAux.equalsIgnoreCase("s")) {

            sQt = textInput(sLabel);
        	iQt = Integer.parseInt(sQt);

            if (iQt > iqt_disponivel){
                sAux = this.textInput(
                    "Quantidade Superior a Disponivel. "+
                    "Deseja Continuar (S/N) ? ");
            }
            else 
            {

                dTotal = iQt * dPreco;

                if (dTotal > dSaldo) {
                    sAux = this.textInput(
                        "Saldo Insuficiente. "+
                        "Deseja Continuar (S/N) ? ");
                }
                else 
                {
                    return iQt;
                }

            }

        }

        return 0;

    }

    public String Quero_Op(){ 

        String sAux="S", sOp="";

        while (sAux.equalsIgnoreCase("s")) {

            sOp = textInput("Ordem de Compra ou de Venda (C/V)? ");

            sAux="N";

            switch(sOp) {
            case "C":
                break;
            case "c":
                break;
            case "V":
                break;
            case "v":
                break;
            default:
                sOp = "";
                sAux = this.textInput(
                    "Opcao Invalida. "+
                    "Deseja Continuar (S/N) ? ");
            }

        }

        return sOp;

    }

    private String textInput(String label) {
        System.out.print(label);
        return this.l.nextLine().toUpperCase();
    }

}

