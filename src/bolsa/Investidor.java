package bolsa;

//import java.util.Scanner;

public class Investidor  extends Elemento {

    //private String cod;
    private String nome;
    private String cpf;
    private Lista contas;
    //private Corretora corretora;
    //private Double saldo;
    //private Lista carteira;

    //public Investidor(){}

    //public Investidor() {}

    public Investidor(String cod, String nome, String cpf) {

        super("Investidor", cod);         

        //this.cod =  cod;
        this.nome = nome;
        this.cpf = cpf;
        //this.corretora = corretora;
        //this.saldo = saldo;

        this.contas = new Lista ("CONTAS");

        //corretora.getInvestidores().inserirPilhaCrescente(this , cod);

    }


    public Lista getContas() {
        return this.contas;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String name) {
        this.nome = name;
    }

    public String getCPF() {
        return this.cpf;
    }

    public void setCPF(String cpf) {
        this.cpf = cpf;
    }

/* 
    @Override 
    public void mostraDados(int iTab){ 

        int i;

        //System.out.println();
 
        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Cod: " + this.getCod());
 
        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Nome: " + this.nome);
 
        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("CPF: " + this.cpf);

        System.out.println();

        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Contas: ");
        this.getContas().exibeComponentes(iTab + 1);

    }

*/


    @Override 
    public void mostraCabecalho(int iTab){ 

        int i;

        System.out.println();

        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println(
            "Cod       " + " " + 
            "Nome      " + " " + 
            "CPF       " 
            );

        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println(
            "----------" + " " +
            "----------" + " " +
            "--------------"
            );

    }

    @Override 
    public int  mostraDados(int iTab){ 

        int i, iTam, iNivel = 0;   
        String sAux;     

        iTam = 10;

        for (i=1; i<=iTab; i++) System.out.print("\t");

        // Cod
        sAux = this.getCod();
        sAux = this.completaString(sAux, iTam);
        System.out.print(sAux + " ");

        // Nome
        sAux = this.getNome();
        sAux = this.completaString(sAux, iTam);
        System.out.print(sAux + " ");

        // CPF
        sAux = this.getCPF();
        sAux = this.completaString(sAux, 14);
        System.out.print(sAux + " ");

        System.out.println();

        iTab += 1;

        if (this.getContas().getQt() > 0) {  
                
            System.out.println();        
            for (i=1; i<=iTab; i++) System.out.print("\t");
            System.out.println("Contas: ");
            this.getContas().exibeComponentes(iTab, true);

            iNivel = 1;

        }

        //if (iNivel==0) System.out.println();

        return iNivel;

    }



}


