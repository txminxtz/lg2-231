package bolsa;

//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.Scanner;

public abstract class Negocio extends Elemento {

    private Conta conta;
    private Ativo ativo;
    private int qt;
    private Double preco;

    public Negocio(
        String sTipo,
        String cod, 
        Conta conta,
        Ativo ativo, 
        int qt, 
        Double preco) {

        super (sTipo, cod);

        this.conta = conta;
        this.ativo = ativo;
        this.qt = qt;
        this.preco = preco;

    }    

    public double getPreco(){
        return this.preco;
    }

    public void setPreco(double preco){
        this.preco = preco;
    }

    public int getQt(){
        return this.qt;
    }

    public void  setQt(int qt){
        this.qt = qt;
    }

    public Conta getConta(){
        return this.conta;

    }
    public Ativo getAtivo(){
        return this.ativo;
    }

/*
    @Override 
    public void mostraDados(int iTab){ 

        int i;

        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Tipo: " + this.getTipo());
 
        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Cod: " + this.getCod());
 
        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Corretora: " + this.conta.getCorretora().getNome());
 
        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Investidor: " + this.conta.getInvestidor().getNome());
 
        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Ativo: " + this.ativo.getCod());
 
        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Preco: " + this.preco);   

        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Qt Total: " + this.qt);
 
    }
*/

    @Override 
    public void mostraCabecalho(int iTab){ 

        int i;

        System.out.println();

        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println(
            "Cod" + " " + 
            "Cor" + " " + 
            "Inv" + " " + 
            "Ativo" + " " + 
            "Preco     " + " " + 
            "Qt        " + " " + 
            "Total     "  
            );

        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println(
            "---" + " " +
            "---" + " " +
            "---" + " " +
            "-----" + " " +
            "----------" + " " +
            "----------" + " " +
            "----------" 
            );

    }

    @Override 
    public int mostraDados(int iTab){ 

        int i, iTam, iAux, iNivel = 0;   
        double dAux;
        String sAux;     

        iTam = 10;

        for (i=1; i<=iTab; i++) System.out.print("\t");

        // Cod
        sAux = this.getCod();
        sAux = this.completaString(sAux, 3);
        System.out.print(sAux + " ");

        // Corretora
        sAux = this.conta.getCorretora().getNome();
        sAux = this.completaString(sAux, 3);
        System.out.print(sAux + " ");

        // Investidor
        sAux = this.conta.getInvestidor().getNome();
        sAux = this.completaString(sAux, 3);
        System.out.print(sAux + " ");

        // Ativo
        sAux = this.ativo.getCod();
        sAux = this.completaString(sAux, 5);
        System.out.print(sAux + " ");

        // Preco
        dAux =  this.preco;
        sAux = Double.toString(dAux);
        sAux = this.completaString(sAux, iTam);
        System.out.print(sAux + " ");

        // Qt
        iAux = this.qt;
        sAux = Integer.toString(iAux);
        sAux = this.completaString(sAux, iTam);
        System.out.print(sAux + " ");

        // Total
        dAux =  this.preco * this.qt;
        sAux = Double.toString(dAux);
        sAux = this.completaString(sAux, iTam);
        System.out.print(sAux + " ");

        System.out.println();

        //if (iNivel==0) System.out.println();

        return iNivel;

    }

}


