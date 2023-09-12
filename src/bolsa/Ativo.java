package bolsa;

//import java.util.Scanner;

public class Ativo extends Elemento {

    //private String cod;
    private String nome;
    private int qt;
    private Double preco;

    //private Corretora corretora;
    
    //private lista carteira;

    public Ativo(){}

    public Ativo(String cod, String nome, int qt, Double preco) {

        super ("Ativo",cod);

        //this.cod =  cod;
        this.nome = nome;
        this.qt = qt;
        this.preco = preco;

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

    public int getQt() {
        return this.qt;
    }

    public void setQt(int qt) {
        this.qt = qt;
    }

    public Double getPreco() {
        return this.preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override 
    public void mostraDados(int iTab){ 

        int i;

        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Cod: " + this.getCod());

        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Nome: " + this.getNome());

        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Quant: " + this.getQt());

        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Preco: " + this.getPreco());

        System.out.println();

    }
/* 
    public boolean dadosInput(Scanner l){ 

        String sCod, sNome, sQt, sPreco;
        double dPreco;
        int iQt;
        String sAux; 

        System.out.println("Cadastro de Ativos");

        sCod = textInput("Codigo: ",l);
        sNome = textInput("Nome:",l);
        sQt = textInput("Quantidade: ",l);
        sPreco = textInput("Preco: ",l);

        iQt = Integer.parseInt(sQt);
        dPreco = Double.parseDouble(sPreco);

        sAux = textInput("Adicionar Ativo (S/N) ?",l);

        if  (sAux.equalsIgnoreCase("s")==false){
            return false;
        }

        this.setCod(sCod);
        this.setNome(sNome);
        this.setQt(iQt);
        this.setPreco(dPreco);

        return true;

    }
*/
}


