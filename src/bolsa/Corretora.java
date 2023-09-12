package bolsa;

//import java.util.Scanner;

public class Corretora extends Elemento {

    //private String cod;
    private String nome;
    private Lista investidores;
    private Lista custodia;

    public Corretora(){}

    public Corretora(String cod, String nome) {

        super ("Corretora",cod);

        //this.cod =  cod;
        this.nome = nome;
        this.investidores = new Lista();
        this.custodia = new Lista();

    }

    /* 

    public String getCod() {
        return this.cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    */

    public String getNome() {
        return this.nome;
    }

    public void setNome(String name) {
        this.nome = name;
    }

    public Lista getInvestidores() {
        return this.investidores;
    }

    public Lista getCustodia() {
        return this.custodia;
    }

    @Override 
    public void mostraDados(int iTab){ 

        int i;

        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Cod: " + this.getCod());

        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Nome: " + this.getNome());

        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Investidores: ");
        System.out.println();
        this.getInvestidores().exibeComponentes(iTab + 1);
        System.out.println();

        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Custodia: ");
        System.out.println();
        this.getCustodia().exibeComponentes(iTab + 1);
        System.out.println();
        
    }



/* 
    public boolean dadosInput(Scanner l){ 

        String sCod, sNome;
        String sAux; 

        System.out.println("Cadastro de Corretoras");

        sCod = textInput("Cod: ",l);
        sNome = textInput("Nome:",l);

        sAux = textInput("Adicionar Corretora (S/N) ?",l);

        if  (sAux.equalsIgnoreCase("s")==false){
            return false;
        }

        //this.setIndexador(sCod);
        this.setCod(sCod);
        this.setNome(sNome);

        return true;

    }

*/

}


