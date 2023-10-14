package bolsa;

//import java.util.Scanner;

public class Ativo extends Elemento {

    //private String cod;
    private String nome;
    private int qt;
    private int qt_disponivel;
    private Double preco;
    private Lista investimentos;

    //public Ativo(String cod, String nome, int qt, Double preco) {
    public Ativo(String cod, String nome) {

        super ("Ativo",cod);

        this.nome = nome;
        this.qt = 0;
        this.qt_disponivel = 0;
        this.preco = 0.0;

        this.investimentos = new Lista ("INVESTIMENTOS");

    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String name) {
        this.nome = name;
    }

    public int getQt() {
        return this.qt;
    }

    public void setQt(int qt) {
        this.qt = qt;
    }

    public void addQt(int qt) {
        this.qt += qt;
        this.qt_disponivel += qt;
    }

    public int getQt_disponivel() {
        return this.qt_disponivel;
    }

    public void setQt_disponivel(int qt) {
        this.qt_disponivel = qt;
    }


    public Double getPreco() {
        return this.preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Lista getInvestimentos() {
        return this.investimentos;
    }
/* 
    @Override 
    public void mostraDados(int iTab){ 

        int i;

        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Cod: " + this.getCod());

        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Nome: " + this.getNome());

        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Qt: " + this.getQt());
        
        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Qt Disponível: " + this.getQt_disponivel());

        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Preco: " + this.getPreco());

        System.out.println();
        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Investimentos: ");
        this.investimentos.exibeComponentes(iTab + 1);   

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
            "Qt Total  " + " " +
            "Qt Disp   " + " " +
            "Preco     " + " " +
            "Total     " 
            );

        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println(
            "----------" + " " +
            "----------" + " " +
            "----------" + " " +
            "----------" + " " +
            "----------" + " " +
            "----------"
            );

    }

    @Override 
    public int mostraDados(int iTab){ 

        int i, iTam, iAux, iNivel=0;   
        double dAux;
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

        // Qt Total
        iAux = this.getQt();
        sAux = Integer.toString(iAux);
        sAux = this.completaString(sAux, iTam);
        System.out.print(sAux + " ");

        // Qt_disponivel
        iAux = this.getQt_disponivel();
        sAux = Integer.toString(iAux);
        sAux = this.completaString(sAux, iTam);
        System.out.print(sAux + " ");

        // Preco
        dAux = this.getPreco();
        sAux = Double.toString(dAux);
        sAux = this.completaString(sAux, iTam);
        System.out.print(sAux + " ");

        // Total
        dAux =  this.getPreco() * getQt_disponivel();
        sAux = Double.toString(dAux);
        sAux = this.completaString(sAux, iTam);
        System.out.print(sAux + " ");

        System.out.println();

        iTab += 1;

        if (this.investimentos.getQt() > 0) {        

            System.out.println();
            for (i=1; i<=iTab; i++) System.out.print("\t");
            System.out.println("Investimentos: ");
            this.investimentos.exibeComponentes(iTab, true);   

            iNivel = 1;

        }

        //if (iNivel==0) System.out.println();

        return iNivel;

    }


}


