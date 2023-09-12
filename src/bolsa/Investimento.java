package bolsa;

//import java.time.LocalDate;
import java.time.LocalDateTime;
//import java.util.Scanner;

public class Investimento extends Elemento {

    //private String cod;
    private Investidor investidor;
    private Ativo ativo;
    private int qt;
    private Double preco;
    private LocalDateTime data;

    public Investimento() {}

    public Investimento(
        String cod, 
        Investidor investidor, 
        Ativo ativo, 
        int qt, 
        Double preco, 
        LocalDateTime data) {

        super ("Investimento", cod);

        //this.cod =  cod;
        this.investidor = investidor;
        this.ativo = ativo;
        this.qt = qt;
        this.preco = preco;
        this.data = data;

        investidor.getCarteira().inserirPilhaCrescente(this , cod);

        investidor.getCorretora().getCustodia().inserirPilhaCrescente(this, cod);

    }    

/*     
    public String getCod() {
        return this.cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }
*/
    public Ativo getAtivo() {
        return this.ativo;
    }

    public void setAtivo(Ativo ativo) {
        this.ativo = ativo;
    }

    public int getQt() {
        return this.qt;
    }

    public void setQt(int qt) {
        this.qt = qt;
    }
    
    public Investidor getInvestidor() {
        return this.investidor;
    }

    public void setInvestidor(Investidor investidor) {
        this.investidor = investidor;
    }

    public Double getPreco() {
        return this.preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public LocalDateTime getData() {
        return this.data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    @Override 
    public void mostraDados(int iTab){ 

        int i;
 
        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Cod: " + this.getCod());
 
        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Investidor: " + this.getInvestidor().getNome());
 
        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Ativo: " + this.getAtivo().getCod());
 
        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Quant: " + this.getQt());
 
        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Preco: " + this.getPreco());   

        System.out.println();
    }

}


