package bolsa;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ordem extends Negocio{

    private int qt_executada;
    private int qt_restante;
    private Date data;
    //private LocalDateTime data;

    public Ordem(
        String tipo,
        String cod, 
        Conta conta,
        Ativo ativo, 
        int qt, 
        Double preco) {

        super (        
            tipo,
            cod, 
            conta,
            ativo, 
            qt, 
            preco);

        qt_executada = 0;
        qt_restante = qt;

        this.data = new Date();
        //this.data = LocalDateTime.now();

        conta.getOrdens().inserirPilhaCrescente(this , cod);

    }    

    public int getQt_executada(){
        return this.qt_executada;
    }

    public void  setQt_executada(int qt){
        this.qt_executada = qt;
    }

    public int getQt_resante(){
        return this.qt_restante;
    }

    public void  setQt_restante(int qt){
        this.qt_restante = qt;
    }

    //public LocalDateTime getData() {
    public Date getData() {
        return this.data;
    }

    @Override 
    public void mostraCabecalho(int iTab){ 

        int i;

        System.out.println();

        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println(
            "T" + " " + 
            "Cod" + " " + 
            "Cta" + " " +
            "Cor" + " " + 
            "Inv" + " " + 
            "Ativo" + " " + 
            "Preco " + " " + 
            "Qt Tot" + " " + 
            "Qt Exe" + " " + 
            "Qt Res" + " " + 
            "Total     " + " " + 
            "Hora    " 
            );

        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println(
            "-" + " " +
            "---" + " " +
            "---" + " " +
            "---" + " " +
            "---" + " " +
            "-----" + " " +
            "------" + " " +
            "------" + " " +
            "------" + " " +
            "------" + " " +
            "----------" + " " +
            "--------" 
            );

    }

    @Override 
    public int mostraDados(int iTab){ 

        int i, iTam, iAux, iNivel = 0;   
        double dAux;
        String sAux;     
        DateFormat dateFormat;
        
        iTam = 10;

        for (i=1; i<=iTab; i++) System.out.print("\t");

        // Tipo
        sAux = this.getTipo();
        sAux = this.completaString(sAux, 1);
        System.out.print(sAux + " ");

        // Cod
        sAux = this.getCod();
        sAux = this.completaString(sAux, 3);
        System.out.print(sAux + " ");

        // Conta
        sAux = this.getConta().getCod();
        sAux = this.completaString(sAux, 3);
        System.out.print(sAux + " ");

        // Corretora
        sAux = this.getConta().getCorretora().getNome();
        sAux = this.completaString(sAux, 3);
        System.out.print(sAux + " ");

        // Investidor
        sAux = this.getConta().getInvestidor().getNome();
        sAux = this.completaString(sAux, 3);
        System.out.print(sAux + " ");

        // Ativo
        sAux = this.getAtivo().getCod();
        sAux = this.completaString(sAux, 5);
        System.out.print(sAux + " ");

        // Preco
        dAux =  this.getPreco();
        sAux = Double.toString(dAux);
        sAux = this.completaString(sAux, 6);
        System.out.print(sAux + " ");

        // Qt Total
        iAux = this.getQt();
        sAux = Integer.toString(iAux);
        sAux = this.completaString(sAux, 6);
        System.out.print(sAux + " ");

        // Qt Executada
        iAux = this.qt_executada;
        sAux = Integer.toString(iAux);
        sAux = this.completaString(sAux, 6);
        System.out.print(sAux + " ");

        // Qt Restante
        iAux = this.qt_restante;
        sAux = Integer.toString(iAux);
        sAux = this.completaString(sAux, 6);
        System.out.print(sAux + " ");

        // Total
        dAux =  this.getPreco() * this.qt_executada;
        sAux = Double.toString(dAux);
        sAux = this.completaString(sAux, iTam);
        System.out.print(sAux + " ");

        // Data

        //dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        dateFormat = new SimpleDateFormat("HH:mm:ss");
        sAux = dateFormat.format(this.data);
 
        //sAux = data.toString(); 
        sAux = this.completaString(sAux, 8);
        System.out.print(sAux + " ");

        System.out.println();

        //if (iNivel==0) System.out.println();

        return iNivel;

    }


}


