package bolsa;

//import java.util.Scanner;

public class Corretora extends Elemento {

    private String nome;
    private Lista contas;

    //public Corretora(){}

    public Corretora(String cod, String nome) {

        super ("Corretora",cod);

        this.nome = nome;
        
        this.contas = new Lista("CONTAS");

    }

    public String getNome() {
        return this.nome;
    }

    public Lista getContas() {
        return this.contas;
    }

    /*
    @Override 
    public void mostraDados(int iTab){ 

        int i;

        //System.out.println();

        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Cod: " + this.getCod());

        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Nome: " + this.getNome());

        System.out.println();
        
        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Contas: ");
        //System.out.println();
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
            "Nome      " 
            );

        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println(
            "----------" + " " +
            "----------"
            );

    }

    @Override 
    public int mostraDados(int iTab){ 

        int i, iTam, iNivel=0;   
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

        System.out.println();

        iTab += 1;

        if (this.getContas().getQt() > 0) {    

            System.out.println();
            for (i=1; i<=iTab; i++) System.out.print("\t");
            System.out.println("Contas: ");
            this.getContas().exibeComponentes(iTab, true);   

            iNivel = 1;

        }

       // if (iNivel==0) System.out.println();

        return iNivel;

    }



}


