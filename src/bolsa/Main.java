package bolsa;

//import java.time.LocalDateTime;

//import java.util.List;
//import java.util.ArrayList;

public class Main 
{
    
    public static void main(String[] args) {


        Bolsa bolsa = new Bolsa();
        int i, iNivel;

        iNivel = 8;

        if (iNivel >= 1) {

        ////////////
        /////// CADASTRO DE ATIVOS

        Lista l_Ativos = bolsa.getAtivos();
        Ativo ativo, at_petr4;//, at_vale3, at_itub4, at_bbdc4;

        ativo = new Ativo("PETR4", "Petrobras PN");
        l_Ativos.inserirPilhaCrescente(ativo, ativo.getCod());

        at_petr4 = ativo;

        if (iNivel >= 2){

        ////////////
        /////// CADASTRO DE CORRETORAS

        Lista l_Corretoras = bolsa.getCorretoras();
        Corretora corretora, cr_xp, cr_rico;

        i = 0;

        corretora = new Corretora(String.format("%03d", ++i), "XP");
        l_Corretoras.inserirPilhaCrescente(corretora, corretora.getCod());

        cr_xp = corretora;
        
        corretora = new Corretora(String.format("%03d", ++i), "Rico");
        l_Corretoras.inserirPilhaCrescente(corretora, corretora.getCod());

        cr_rico = corretora; 
    
        if (iNivel >= 3){

        ////////////
        /////// CADASTRO DE INVESTIDORES

        Lista l_Investidores = bolsa.getInvestidores();
        Investidor investidor, iv_bruno, iv_claudio; // iv_carla, 

        i = 0;

        investidor = new Investidor(String.format("%03d", ++i), "Claudio", "003.263.877-90");
        l_Investidores.inserirPilhaCrescente(investidor, investidor.getCod());

        iv_claudio = investidor;

        investidor = new Investidor(String.format("%03d", ++i), "Bruno", "427.266.758-08");
        l_Investidores.inserirPilhaCrescente(investidor, investidor.getCod());

        iv_bruno = investidor;

        if (iNivel >= 4){

        ////////////
        /////// CADASTRO DE CONTAS

        Lista l_Contas = bolsa.getContas();
        Conta conta, conta_xp_claudio, conta_rico_bruno; //conta_xp_carla, 

        i = 0;
        
        conta = new Conta(String.format("%03d", ++i), cr_xp, iv_claudio, 0.00);
        l_Contas.inserirPilhaCrescente(conta, conta.getCod());

        conta_xp_claudio = conta;

        conta = new Conta(String.format("%03d", ++i), cr_rico, iv_bruno, 0.00);
        l_Contas.inserirPilhaCrescente(conta, conta.getCod());

        conta_rico_bruno = conta;

        if (iNivel >= 5){

        ////////////
        /////// DEPOSITO EM CONTA
        
        conta_rico_bruno.depositaValor(5000.00);
        conta_xp_claudio.depositaValor(10000.00);
        
        if (iNivel >= 6){

        ////////////
        /////// OPA

        at_petr4.addQt(20000);
        at_petr4.setPreco(33.40); 
        
        if (iNivel >= 7){

        ////////////
        /////// COMPRA DE OPA

        Investimento investimento;

        int iQt_disponivel, iQt;
        double dPreco, dTotal;
        String sCod;

        iQt = 200;

        iQt_disponivel = at_petr4.getQt_disponivel();
        dPreco = at_petr4.getPreco();

        iQt = 200;

        dTotal = iQt * dPreco;        

        iQt_disponivel -= iQt;


        i = 0;
        sCod = String.format("%03d", ++i);

        investimento = new Investimento(
            "Investimento",
            sCod, 
            conta_xp_claudio, 
            at_petr4 , 
            iQt, 
            dPreco);

        at_petr4.getInvestimentos().inserirPilhaCrescente(investimento , sCod);
        at_petr4.setQt_disponivel(iQt_disponivel);

        conta_xp_claudio.resgataValor(dTotal);

        bolsa.getInvestimentos().inserirPilhaCrescente(investimento, investimento.getCod());

        if (iNivel >= 8){

        ////////////
        /////// INCLUSAO DE ORDENS

        i = 0;

        bolsa.cadastraOrdem(
            "V", 
            ++i, 
            conta_xp_claudio, 
            at_petr4, 
            200,  
            35.00);

        bolsa.cadastraOrdem(
            "C", 
            ++i, 
            conta_rico_bruno, 
            at_petr4, 
            100,  
            33.00);

        }}}}}}}}
        
        ////////////
        /////// MENU

        new Menu(bolsa);

    }    

}

