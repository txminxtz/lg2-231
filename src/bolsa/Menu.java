package bolsa;

import java.time.LocalDateTime;
//import java.util.List;
import java.util.Scanner;
//import java.util.ArrayList;

public class Menu 
{

    private Scanner l;

     //public Menu(Lista l_Corretoras, Lista l_Investidores, Lista l_Ativos, Lista l_Investimentos)
     public Menu(Bolsa bolsa)
    {

        String sAux;
        boolean bMenu = true;

        l = new Scanner(System.in);

        System.out.println("BOLSA DE VALORES");

        while (bMenu) {

            sAux = opcaoMenu_Principal();

            if (sAux.equalsIgnoreCase("1")){
                //Menu_Cadastros(l_Corretoras, l_Investidores, l_Ativos, l_Investimentos);
                Menu_Cadastros(bolsa);

            } else if (sAux.equalsIgnoreCase("2")) {
                //Menu_Relatorios(l_Corretoras, l_Investidores, l_Ativos, l_Investimentos);
                Menu_Relatorios(bolsa);

            } else if (sAux.equalsIgnoreCase("9")) {
                bMenu = false;
            } else {
                System.out.println("\nOpcao Invalida!");
            }
        }
    }

    ////////////
    /////// MENUS

    private String opcaoMenu_Principal() {

        System.out.println("========= MENU PRINCIPAL ==========");
        System.out.println();
        System.out.println("Selecione uma opcao:");
        System.out.println();
        System.out.println("1 - Cadastros");
        System.out.println("2 - Relatorios");
        System.out.println("9 - Sair");
        
        return l.nextLine();

    }

    private String opcaoMenu_Cadastros() {

        System.out.println("========= CADASTROS ==========");
        System.out.println();
        System.out.println("Selecione uma opcao:");
        System.out.println();
        System.out.println("1 - Ativos");
        System.out.println("2 - Corretoras");
        System.out.println("3 - Investidores");
        System.out.println("4 - Investimentos");
        System.out.println("9 - Voltar");

        return l.nextLine();

    }

    private String opcaoMenu_Relatorios() {

        System.out.println("========= RELATORIOS ==========");
        System.out.println();
        System.out.println("Selecione uma opcao:");
        System.out.println();
        System.out.println("1 - Ativos");
        System.out.println("2 - Corretoras");
        System.out.println("3 - Investidores");
        System.out.println("4 - Investimentos");
        System.out.println("9 - Voltar");

        return l.nextLine();

    }

    ////////////
    /////// CADASTROS

    //public void Menu_Cadastros(Lista l_Corretoras, Lista l_Investidores, Lista l_Ativos, Lista l_Investimentos)
    public void Menu_Cadastros(Bolsa bolsa)
    {

        String sAux;
        boolean bMenu = true;

        l = new Scanner(System.in);

        while (bMenu) {

            sAux = opcaoMenu_Cadastros();

            if (sAux.equalsIgnoreCase("1")) {
                //bolsa.getAtivos().cadastro("Ativo",l);
                this.dadosInput_Ativo(bolsa, l);

            } 
            else if (sAux.equalsIgnoreCase("2")) {
                //bolsa.getCorretoras().cadastro("Corretora",l);
                this.dadosInput_Corretora(bolsa, l);

            } 
            else if (sAux.equalsIgnoreCase("3")){
                //bolsa.getInvestidores().cadastro("Investidor",l);
                this.dadosInput_Investidor(bolsa, l);

            } 
            else if (sAux.equalsIgnoreCase("4")) {
                //bolsa.getInvestimentos().cadastro("Investimento", l);
                this.dadosInput_Investimento(bolsa, l);

            } else if (sAux.equalsIgnoreCase("9")) {
                bMenu = false;
            } else {
                System.out.println("\nOpcao Invalida!");
            }
        }

    }

    ////////////
    /////// RELATORIOS

    //public void Menu_Relatorios(Lista l_Corretoras, Lista l_Investidores, Lista l_Ativos, Lista l_Investimentos)
    public void Menu_Relatorios(Bolsa bolsa)
    {

        String sAux;
        boolean bMenu = true;

        l = new Scanner(System.in);

        while (bMenu) {

            sAux = opcaoMenu_Relatorios();

            if (sAux.equalsIgnoreCase("1")) {
                sAux = "Ativos";
                System.out.println("\nLista de " + sAux + ":\n");
                bolsa.getAtivos().exibeComponentes(0);
            
            } 
            else if (sAux.equalsIgnoreCase("2")) {
                sAux = "Corretoras";
                System.out.println("\nLista de " + sAux + ":\n");
                bolsa.getCorretoras().exibeComponentes(0);

            } 
            else if (sAux.equalsIgnoreCase("3")) {
                sAux = "Investidores";
                System.out.println("\nLista de " + sAux + ":\n");
                bolsa.getInvestidores().exibeComponentes(0);

            } 
            else if (sAux.equalsIgnoreCase("4")) {
                sAux = "Investimentos";
                System.out.println("\nLista de " + sAux + ":\n");
                bolsa.getInvestimentos().exibeComponentes(0);

            } 
            else if (sAux.equalsIgnoreCase("9")) {
                bMenu = false;
            } else {
                System.out.println("\nOpcao Invalida!");
            }
        }
    }

    ////////////
    /////// ENTRADA DE DADOS


    public boolean dadosInput_Ativo(Bolsa bolsa, Scanner l){ 

        String sCod, sNome, sQt, sPreco;
        double dPreco;
        int iQt;
        String sAux; 

        System.out.println("Cadastro de Ativos");
        System.out.println();

        sCod = this.NaoQuero_Elemento(
            bolsa.getAtivos(), 
            "Codigo: ",  
            l);

        if (sCod == "") return false;
    
        sCod = sCod.toUpperCase();

        //sCod = textInput("Codigo: ",l);
        sNome = textInput("Nome: ",l);
        sQt = textInput("Quantidade: ",l);
        sPreco = textInput("Preco: ",l);

        iQt = Integer.parseInt(sQt);
        dPreco = Double.parseDouble(sPreco);

        sAux = textInput("Adicionar Ativo (S/N) ? ",l);

        if  (sAux.equalsIgnoreCase("s")==false){
            return false;
        }

        Ativo ativo;

        ativo = new Ativo(sCod, sNome, iQt, dPreco);
 
        bolsa.getAtivos().inserirPilhaCrescente(ativo, ativo.getCod());

        return true;

    }

    public boolean dadosInput_Corretora(Bolsa bolsa, Scanner l){ 

        String sCod, sNome;
        String sAux;

        System.out.println("Cadastro de Corretoras");
        System.out.println();

        int iAux = bolsa.getCorretoras().getQt();
        iAux++;

        sCod = String.format("%03d", iAux);

        System.out.println("Codigo: "+sCod);

        //sCod = textInput("Cod: ",l);
        sNome = textInput("Nome: ",l);

        sAux = textInput("Adicionar Corretora (S/N) ? ",l);

        if  (sAux.equalsIgnoreCase("s")==false){
            return false;
        }

        Corretora corretora;

        corretora = new Corretora(sCod, sNome);
 
        bolsa.getCorretoras().inserirPilhaCrescente(corretora, corretora.getCod());

        return true;

    }

    public boolean dadosInput_Investidor(Bolsa bolsa, Scanner l){ 

        String sCod, sNome, sCPF, sSaldo;
        double dSaldo;
        String sAux; 
        Elemento corretora;

        System.out.println("Cadastro de Investidores");
        System.out.println();

        int iAux = bolsa.getInvestidores().getQt();
        iAux++;

        sCod = String.format("%03d", iAux);

        System.out.println("Codigo: "+sCod);

        //sCod = textInput("Cod: ",l);

        sNome = textInput("Nome: ",l);
        sCPF = textInput("CPF: ",l);

        //sCorretora = textInput("Corretora: ",l);

        corretora = this.Quero_Elemento(
            bolsa.getCorretoras(), 
            "Corretora: ",  
            l);

        if (corretora==null) return false;


        sSaldo = textInput("Saldo: ",l);

        dSaldo = Double.parseDouble(sSaldo);

        sAux = textInput("Adicionar Investidor (S/N) ? ",l);

        if  (sAux.equalsIgnoreCase("s")==false){
            return false;
        }

        Investidor investidor;

        investidor = new Investidor(sCod, sNome, sCPF, (Corretora) corretora, dSaldo);
 
        bolsa.getInvestidores().inserirPilhaCrescente(investidor, investidor.getCod());

        return true;

    }

    private boolean dadosInput_Investimento(Bolsa bolsa, Scanner l){ 

        String sCod, sQt, sPreco;
        double dPreco;
        int iQt;
        String sAux; 

        Elemento investidor, ativo;

        System.out.println("Cadastro de Investimentos");
        System.out.println();

        int iAux = bolsa.getInvestimentos().getQt();
        iAux++;

        sCod = String.format("%03d", iAux);

        System.out.println("Codigo: "+sCod);

        investidor = this.Quero_Elemento(
            bolsa.getInvestidores(), 
            "Investidor: ",  
            l);

        if (investidor==null) return false;

        ativo = this.Quero_Elemento(
            bolsa.getAtivos(), 
            "Ativo: ",  
            l);

        if (ativo==null) return false;

        //sAtivo = textInput("Ativo: ",l);

        sQt = textInput("Quantidade: ",l);
        sPreco = textInput("Preco: ",l);

        iQt = Integer.parseInt(sQt);
        dPreco = Double.parseDouble(sPreco);

        sAux = textInput("Adicionar Investimento (S/N) ? ",l);

        if  (sAux.equalsIgnoreCase("s")==false){
            return false;
        }

        Investimento investimento;

        investimento = new Investimento(sCod, (Investidor) investidor, (Ativo) ativo , iQt, dPreco, LocalDateTime.now());
        bolsa.getInvestimentos().inserirPilhaCrescente(investimento, investimento.getCod());

        return true;

    }

    ////////////
    /////// FUNÇÕES AUXILIARES

    private String NaoQuero_Elemento(Lista lista, String sLabel, Scanner l){ 

        Elemento elemento; 

        String sAux="S", sCod;

        while (sAux.equalsIgnoreCase("s")) {

            sCod = textInput(sLabel,l);

            elemento =  lista.pesquisaElemento(sCod);

            if (elemento == null) return sCod;

            sAux = this.textInput("Codigo Invalido. Deseja Continuar (S/N) ? ", l);

        }

        return "";

    }


    private Elemento Quero_Elemento(Lista lista, String sLabel, Scanner l){ 

        Elemento elemento=null; 

        String sAux="S", sCod;

        while (sAux.equalsIgnoreCase("s")) {

            sCod = textInput(sLabel, l);

            elemento =  lista.pesquisaElemento(sCod);

            if (elemento != null) return elemento;

            sAux = this.textInput("Codigo Invalido. Deseja Continuar (S/N) ? ", l);

        }

        return null;

    }


    public String textInput(String label, Scanner l) {
        System.out.print(label);
        return l.nextLine();
    }

}

