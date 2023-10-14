package bolsa;

import java.time.LocalDateTime;

public class Negociacao extends Elemento{

    private Ordem ordem_compra;
    private Ordem ordem_venda;
    private int qt;
    private double preco;
    private LocalDateTime data;

    public Negociacao(
        String stipo,
        String cod,
        Ordem ordem_compra,
        Ordem ordem_venda, 
        int qt, 
        Double preco) {

        super (stipo, cod);

        this.ordem_compra = ordem_compra;
        this.ordem_venda = ordem_venda;
        this.qt = qt;
        this.preco = preco;

        this.data = LocalDateTime.now();

        ordem_compra.getConta().getNegociacoes().inserirPilhaCrescente(this , cod);
        ordem_venda.getConta().getNegociacoes().inserirPilhaCrescente(this , cod);

    }    

 /*    
    @Override 
    public void mostraDados(int iTab){ 

        int i;

        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Ordem Compra: " + ordem_compra.getCod());
 
        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Ordem Venda: " + ordem_venda.getCod());
 
        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Qt: " + this.qt);

        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Preco: " + this.preco);

        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Data: " + this.data);   

 
    }
*/

    @Override 
    public void mostraCabecalho(int iTab){ 

        int i;

        System.out.println();

        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println(
            "Cod   " + " " + 
            "Ordem C   " + " " + 
            "Ordem V   " + " " + 
            "Qt        " + " " + 
            "Preco     " + " " + 
            "Data               " 
            );

        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println(
            "------" + " " +
            "----------" + " " +
            "----------" + " " +
            "----------" + " " +
            "----------" + " " +
            "-------------------" 
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
        sAux = this.completaString(sAux, 6);
        System.out.print(sAux + " ");

        // Ordem de Compra
        sAux = ordem_compra.getCod();
        sAux = this.completaString(sAux, iTam);
        System.out.print(sAux + " ");

        // Ordem de Venda
        sAux = ordem_venda.getCod();
        sAux = this.completaString(sAux, iTam);
        System.out.print(sAux + " ");

        // Qt Total
        iAux = this.qt;
        sAux = Integer.toString(iAux);
        sAux = this.completaString(sAux, iTam);
        System.out.print(sAux + " ");

        // Preco
        dAux =  this.preco;
        sAux = Double.toString(dAux);
        sAux = this.completaString(sAux, iTam);
        System.out.print(sAux + " ");

        // Data
        sAux = data.toString(); //dateFormat.format(this.data);
        sAux = this.completaString(sAux, 19);
        System.out.print(sAux + " ");

        System.out.println();

        //if (iNivel==0) System.out.println();

        return iNivel;

    }

}


