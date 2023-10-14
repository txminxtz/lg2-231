package bolsa;

import java.util.Scanner;

public class Menu 
{

    private Scanner l;
    private MenuAux menuAux;
    //private Bolsa bolsa;

    ////////////
    /////// CONSTRUTOR

    public Menu(Bolsa bolsa) 
    {

       // this.bolsa = bolsa;
        l = new Scanner(System.in);
        menuAux = new MenuAux(bolsa);

        System.out.println();
        System.out.println("BOLSA");

        Menu_Principal();

    }

    ////////////
    /////// MENU_PRINCIPAL

    public void Menu_Principal()
    {

        boolean bMenu = true;
        String sAux;
        String [] vet_sOpcoes = new String [10];     
        int iTam = 0;       

        vet_sOpcoes[iTam++] = "========= MENU PRINCIPAL ==========";
        vet_sOpcoes[iTam++] = "1 - Cadastros";
        vet_sOpcoes[iTam++] = "2 - Operacoes";
        vet_sOpcoes[iTam++] = "3 - Relatorios";
        vet_sOpcoes[iTam++] = "0 - Sair";

        //System.out.println("BOLSA DE VALORES");

        while (bMenu) {

            sAux = opcaoMenu(vet_sOpcoes, iTam);

            if (sAux.equalsIgnoreCase("0")) {
                bMenu = false;
            } 
            else if (sAux.equalsIgnoreCase("1")){
                Menu_Cadastros();

            } 
            else if (sAux.equalsIgnoreCase("2")) {
                Menu_Operacoes();

            } 
            else if (sAux.equalsIgnoreCase("3")) {
                Menu_Relatorios();

            } 
            else if (sAux.equalsIgnoreCase("0")) {
                bMenu = false;
            } 
            else {
                System.out.println("\nOpcao Invalida!");
            }
        }
    }


    ////////////
    /////// MENU DE CADASTROS

    public void Menu_Cadastros()
    {

        boolean bMenu = true;
        String sAux;
        String [] vet_sOpcoes = new String [10]; 
        int iTam = 0;       

        vet_sOpcoes[iTam++] = "========= CADASTROS ==========";
        vet_sOpcoes[iTam++] = "1 - Ativos";
        vet_sOpcoes[iTam++] = "2 - Corretoras";
        vet_sOpcoes[iTam++] = "3 - Investidores";
        vet_sOpcoes[iTam++] = "4 - Contas";
        vet_sOpcoes[iTam++] = "0 - Voltar";

        while (bMenu) {

            sAux = opcaoMenu(vet_sOpcoes, iTam);

            if (sAux.equalsIgnoreCase("0")) {
                bMenu = false;
            } 
            // CADASTRO DE ATIVOS
            else if (sAux.equalsIgnoreCase("1")) {
                menuAux.dadosInput_Ativo();

            } 
            // CADASTRO DE CORRETORAS
            else if (sAux.equalsIgnoreCase("2")) {
                menuAux.dadosInput_Corretora();

            } 
            // CADASTRO DE INVESTIDORS
            else if (sAux.equalsIgnoreCase("3")){
                menuAux.dadosInput_Investidor();

            } 
            // CADSTRO DE CONTAS
            else if (sAux.equalsIgnoreCase("4")){
                menuAux.dadosInput_Conta();

            } 
            else {
                System.out.println("\nOpcao Invalida!");
            }
        }

    }

    ////////////
    /////// MENU DE OPERACOES

    public void Menu_Operacoes()
    {

        boolean bMenu = true;
        String sAux;
        String [] vet_sOpcoes = new String [10]; 
        int iTam = 0;       

        vet_sOpcoes[iTam++] = "========= OPERACOES ==========";
        vet_sOpcoes[iTam++] = "1 - Oferta Publica de Acoes (OPA)";
        vet_sOpcoes[iTam++] = "2 - Deposito em Conta";
        vet_sOpcoes[iTam++] = "3 - Compra de OPA";
        vet_sOpcoes[iTam++] = "4 - Ordens";
        vet_sOpcoes[iTam++] = "0 - Voltar";

        l = new Scanner(System.in);

        while (bMenu) {

            sAux = opcaoMenu(vet_sOpcoes, iTam);

            if (sAux.equalsIgnoreCase("0")) {
                bMenu = false;
            } 
            // OPA
            else if (sAux.equalsIgnoreCase("1")) {
                menuAux.op_OPA();

            } 
            // DEPOSITO EM CONTA
            else if (sAux.equalsIgnoreCase("2")) {
                menuAux.op_Deposito_Conta();

            }
            // COMPRA DE OPA
            else if (sAux.equalsIgnoreCase("3")) {
                menuAux.op_Compra_OPA();

            }  
            // ORDENS
            else if (sAux.equalsIgnoreCase("4")) {
                Menu_Ordens();

            } 
            else {
                System.out.println("\nOpcao Invalida!");
            }
        }
    }

    ////////////
    /////// MENU DE ORDENS

    public void Menu_Ordens()
    {

        boolean bMenu = true;
        String sAux;
        String [] vet_sOpcoes = new String [10]; 
        int iTam = 0;       

        vet_sOpcoes[iTam++] = "========= ORDENS ==========";
        vet_sOpcoes[iTam++] = "1 - Inclusao";
        vet_sOpcoes[iTam++] = "2 - Edicao";
        vet_sOpcoes[iTam++] = "3 - Exclusao";
        vet_sOpcoes[iTam++] = "0 - Voltar";

        l = new Scanner(System.in);

        while (bMenu) {

            sAux = opcaoMenu(vet_sOpcoes, iTam);

            if (sAux.equalsIgnoreCase("0")) {
                bMenu = false;
            } 
            // INCLUSAO
            else if (sAux.equalsIgnoreCase("1")) {
                menuAux.dadosInput_Ordem();

            } 
            // EDICAO
            else if (sAux.equalsIgnoreCase("2")) {
                menuAux.dadosEdicao_Ordem();

            }
            // EXCLUSAO
            else if (sAux.equalsIgnoreCase("3")) {
                menuAux.dadosExclusao_Ordem();

            }  
            else {
                System.out.println("\nOpcao Invalida!");
            }
        }
    }


    ////////////
    /////// MENU DE RELATORIOS

    public void Menu_Relatorios()
    {

        boolean bMenu = true;
        String sAux;
        String [] vet_sOpcoes = new String [10]; 
        int iTam = 0;       

        vet_sOpcoes[iTam++] = "========= RELATORIOS ==========";
        vet_sOpcoes[iTam++] = "1 - Ativos";
        vet_sOpcoes[iTam++] = "2 - Corretoras";
        vet_sOpcoes[iTam++] = "3 - Investidores";
        vet_sOpcoes[iTam++] = "4 - Contas";
        vet_sOpcoes[iTam++] = "5 - Investimentos";
        vet_sOpcoes[iTam++] = "6 - Ordens";
        vet_sOpcoes[iTam++] = "7 - Negociacoes";
        vet_sOpcoes[iTam++] = "0 - Voltar";

        l = new Scanner(System.in);

        while (bMenu) {

            sAux = opcaoMenu(vet_sOpcoes, iTam);

            if (sAux.equalsIgnoreCase("0")) {
                bMenu = false;
            } 
            // RELATORIO DE ATIVOS
            else if (sAux.equalsIgnoreCase("1")) {
                menuAux.relatorio("ATIVOS");
            
            } 
            // RELATORIO DE CORRETORAS
            else if (sAux.equalsIgnoreCase("2")) {
                menuAux.relatorio("CORRETORAS");

            } 
            // RELATORIO DE INVESTIDORES
            else if (sAux.equalsIgnoreCase("3")) {
                menuAux.relatorio("INVESTIDORES");

            } 
            // RELATORIO DE CONTAS
            else if (sAux.equalsIgnoreCase("4")) {
                menuAux.relatorio("CONTAS");

            } 
            // RELATORIO DE IMVESTIMENTOS
            else if (sAux.equalsIgnoreCase("5")) {
                menuAux.relatorio("IMVESTIMENTOS");

            } 
            // RELATORIO DE ORDENS
            else if (sAux.equalsIgnoreCase("6")) {
                menuAux.relatorio("ORDENS");

            } 
            // RELATORIO DE NEGOCIACOES
            else if (sAux.equalsIgnoreCase("7")) {
                menuAux.relatorio("NEGOCIACOES");

            } 
            else {
                System.out.println("Opcao Invalida!");
            }
        }
    }

    private String opcaoMenu(String [] vet_sOpcoes, int iTam) {

        System.out.println();
        System.out.println(vet_sOpcoes[0]);
        System.out.println();
        System.out.println("Selecione uma Opcao:");
        System.out.println();

        for (int i=1;i<iTam;i++) System.out.println(vet_sOpcoes[i]);

        return l.nextLine();

    }

}

