package bolsa;

//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.Scanner;

public class Conta extends Elemento {

    private Corretora corretora;
    private Investidor investidor;
    private Double saldo;
    private Lista ordens;
    private Lista investimentos;
    private Lista negociacoes;

    //public Conta() {}

    public Conta(
        String cod, 
        Corretora corretora, 
        Investidor investidor,
        Double saldo) {

        super ("Conta", cod);

        this.corretora = corretora;
        this.investidor = investidor;
        this.saldo = saldo;

        this.ordens = new Lista ("ORDENS");
        this.investimentos = new Lista ("INVESTIMENTOS");
        this.negociacoes = new Lista ("NEGOCIACOES");

        investidor.getContas().inserirPilhaCrescente(this , cod);
        corretora.getContas().inserirPilhaCrescente(this , cod);

    }    

    public Lista getOrdens() {
        return this.ordens;
    }

    public Lista getInvestimentos() {
        return this.investimentos;
    }

    public Lista getNegociacoes() {
        return this.negociacoes;
    }

    public Corretora getCorretora() {
        return this.corretora;
    }

    public Investidor getInvestidor() {
        return this.investidor;
    }

    public Double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void depositaValor(double valor) {
        this.saldo += valor;
    }

    public void resgataValor(double valor) {
        this.saldo -= valor;
    }

/*

    @Override 
    public void mostraDados(int iTab){ 

        int i;

        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Cod: " + this.getCod());
 
        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Corretora: " + this.corretora.getNome());
 
        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Investidor: " + this.investidor.getNome());

        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Saldo: " + this.saldo);   

        System.out.println();
        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Ordens: ");
        this.ordens.exibeComponentes(iTab + 1);        

        System.out.println();
        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Investimentos: ");
        this.investimentos.exibeComponentes(iTab + 1);        

        System.out.println();
        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Negociacoes: ");
        this.negociacoes.exibeComponentes(iTab + 1);        


    }

*/

    @Override 
    public void mostraCabecalho(int iTab){ 

        int i;

        System.out.println();

        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println(
            "Cod       " + " " + 
            "Corretora " + " " + 
            "Investidor" + " " + 
            "Saldo     " 
            );

        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println(
            "----------" + " " +
            "----------" + " " +
            "----------" + " " +
            "----------" 
            );

    }

    @Override 
    public int mostraDados(int iTab){ 

        int i, iTam, iNivel;   
        double dAux;
        String sAux;     

        iTam = 10;
        iNivel = 0;

        for (i=1; i<=iTab; i++) System.out.print("\t");

        // Cod
        sAux = this.getCod();
        sAux = this.completaString(sAux, iTam);
        System.out.print(sAux + " ");

        // Corretora
        sAux = this.corretora.getNome();
        sAux = this.completaString(sAux, iTam);
        System.out.print(sAux + " ");

        // Investidor
        sAux = this.investidor.getNome();
        sAux = this.completaString(sAux, iTam);
        System.out.print(sAux + " ");

        // Saldo
        dAux =  this.saldo;
        sAux = Double.toString(dAux);
        sAux = this.completaString(sAux, iTam);
        System.out.print(sAux + " ");

        System.out.println();

        iTab += 1;

        if (this.ordens.getQt() > 0) {
 
            System.out.println();
            for (i=1; i<=iTab; i++) System.out.print("\t");
            System.out.println("Ordens: ");
            this.ordens.exibeComponentes(iTab, true);        
            
            iNivel = 1;

        }

        if (this.investimentos.getQt() > 0) {

            System.out.println();
            for (i=1; i<=iTab; i++) System.out.print("\t");
            System.out.println("Investimentos: ");
            this.investimentos.exibeComponentes(iTab, true);        

            iNivel = 1;

        }

        if (this.negociacoes.getQt() > 0) {

            System.out.println();
            for (i=1; i<=iTab; i++) System.out.print("\t");
            System.out.println("Negociacoes: ");
            this.negociacoes.exibeComponentes(iTab, true);    

            iNivel = 1;

        }
                        
       // if (iNivel==0) System.out.println();

        return iNivel;

    }


}


