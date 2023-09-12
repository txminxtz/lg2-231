package bolsa;

//import java.util.Scanner;

public class Investidor  extends Elemento {

    //private String cod;
    private String nome;
    private String cpf;
    private Corretora corretora;
    private Double saldo;
    private Lista carteira;

    //public Investidor(){}

    public Investidor() {}

    public Investidor(String cod, String nome, String cpf, Corretora corretora, Double saldo) {

        super("Investidor", cod);         

        //this.cod =  cod;
        this.nome = nome;
        this.cpf = cpf;
        this.corretora = corretora;
        this.saldo = saldo;

        this.carteira = new Lista ();

        corretora.getInvestidores().inserirPilhaCrescente(this , cod);

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

    public String getCPF() {
        return this.cpf;
    }

    public void setCPF(String cpf) {
        this.cpf = cpf;
    }

    public Corretora getCorretora() {
        return this.corretora;
    }

    public void setCorretora(Corretora corretora) {
        this.corretora = corretora;
    }

    public Double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Lista getCarteira() {
        return this.carteira;
    }

    @Override 
    public void mostraDados(int iTab){ 

        int i;
 
        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Cod: " + this.getCod());
 
        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Nome: " + this.getNome());
 
        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("CPF: " + this.getCPF());
 
        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Corretora: " + this.getCorretora().getCod());
 
        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Saldo: " + this.getSaldo());
 
        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Carteira: ");

        System.out.println();

        this.getCarteira().exibeComponentes(iTab + 1);

        System.out.println();

    }
/* 
    public boolean dadosInput(Scanner l){ 

        String sCod, sNome, sCPF, sCorretora, sSaldo;
        double dSaldo;
        String sAux; 

        System.out.println("Cadastro de Investidores");

        sCod = textInput("Cod: ",l);
        sNome = textInput("Nome:",l);
        sCPF = textInput("CPF: ",l);
        sCorretora = textInput("Corretora: ",l);
        sSaldo = textInput("Saldo: ",l);

        dSaldo = Double.parseDouble(sSaldo);

        sAux = textInput("Adicionar Investidor (S/N) ?",l);

        if  (sAux.equalsIgnoreCase("s")==false){
            return false;
        }

        //this.setIndexador(sCod);
        
        this.setCod(sCod);
        this.setNome(sNome);
        this.setCPF(sCPF);
        this.setCorretora(sCorretora);
        this.setSaldo(dSaldo);

        return true;

    }

 */

}


