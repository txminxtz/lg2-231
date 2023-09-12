package bolsa;

import java.time.LocalDateTime;

//import java.util.List;
//import java.util.ArrayList;

public class Main 
{
    
    public static void main(String[] args) {


        Bolsa bolsa = new Bolsa();

        ////////////
        /////// Lista de Ativos

        Lista l_Ativos = bolsa.getAtivos();
        Ativo ativo, at_petr4, at_vale3, at_itub4, at_bbdc4;

        ativo = new Ativo("PETR4", "Petrobras PN", 1000, 33.40);
        l_Ativos.inserirPilhaCrescente(ativo, ativo.getCod());

        at_petr4 = ativo;

        ativo = new Ativo("VALE3", "Vale ON", 5000, 66.71);
        l_Ativos.inserirPilhaCrescente(ativo, ativo.getCod());

        at_vale3 = ativo;

        ativo = new Ativo("ITUB4", "Itau PN", 1500, 13.70);
        l_Ativos.inserirPilhaCrescente(ativo, ativo.getCod());

        at_itub4 = ativo;

        ativo = new Ativo("BBDC4", "Bradesco PN", 1500, 13.70);
        l_Ativos.inserirPilhaCrescente(ativo, ativo.getCod());

        at_bbdc4 = ativo;

        ////////////
        /////// Lista de Corretoras

        Lista l_Corretoras = bolsa.getCorretoras();
        Corretora corretora, cr_xp, cr_rico;

        //l_Corretoras = new Lista();

        corretora = new Corretora("001", "XP");
        l_Corretoras.inserirPilhaCrescente(corretora, corretora.getCod());

        cr_xp = corretora;

        corretora = new Corretora("002", "Rico");
        l_Corretoras.inserirPilhaCrescente(corretora, corretora.getCod());

        cr_rico = corretora; 

        ////////////
        /////// Lista de Investidores

        Lista l_Investidores = bolsa.getInvestidores();
        Investidor investidor, iv_bruno, iv_carla, iv_claudio;

        investidor = new Investidor("003", "Claudio", "003.263.877-90", cr_rico, 2000.00);
        l_Investidores.inserirPilhaCrescente(investidor, investidor.getCod());

        iv_claudio = investidor;

        investidor = new Investidor("001", "Bruno", "427.266.758-08", cr_xp,  900.00);
        l_Investidores.inserirPilhaCrescente(investidor, investidor.getCod());

        iv_bruno = investidor;

        investidor = new Investidor("002", "Carla", "212.478.638-59", cr_xp, 1500.00);
        l_Investidores.inserirPilhaCrescente(investidor, investidor.getCod());

        iv_carla = investidor;


        ////////////
        /////// Lista de Investidores

        Lista l_Investimentos = bolsa.getInvestimentos();
        Investimento investimento;

        investimento = new Investimento("001", iv_carla, at_petr4 , 50, 33.50, LocalDateTime.now());
        l_Investimentos.inserirPilhaCrescente(investimento, investimento.getCod());

        investimento = new Investimento("002", iv_bruno, at_vale3 , 30, 66.49, LocalDateTime.now());
        l_Investimentos.inserirPilhaCrescente(investimento, investimento.getCod());

        investimento = new Investimento("003", iv_bruno, at_itub4 , 15, 11.24, LocalDateTime.now());
        l_Investimentos.inserirPilhaCrescente(investimento, investimento.getCod());

        investimento = new Investimento("004", iv_claudio, at_bbdc4 , 30, 30.15, LocalDateTime.now());
        l_Investimentos.inserirPilhaCrescente(investimento, investimento.getCod());

/* 
        System.out.println("Corretoras: "+ bolsa.getCorretoras().getQuantidade() );
        System.out.println("Investidores: "+ bolsa.getInvestidores().getQuantidade() );
        System.out.println("Ativos: "+ bolsa.getAtivos().getQuantidade() );
        System.out.println("Investimentos: "+ bolsa.getInvestimentos().getQuantidade() );
        System.out.println();
*/

        ////////////
        /////// MENU


        //new Menu(l_Corretoras, l_Investidores, l_Ativos, l_Investimentos);
        new Menu(bolsa);

    }
    
}

