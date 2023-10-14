package bolsa;

import java.util.Scanner;

public abstract class Elemento {

    private String tipo;
    private String cod;

    //public Elemento (){}

    public Elemento (String tipo, String cod){
        this.tipo = tipo;
        this.cod = cod;
    }

    public String getTipo() {
        return tipo;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public void mostraCabecalho(int iTab){ 

        int i;

        System.out.println();

        for (i=1; i<=iTab; i++) System.out.println("\t");

        System.out.println(
            "Cod       " 
            );

	    System.out.println(
            "----------" 
            );

    }

    public int mostraDados(int iTab){ 

        int i, iNivel = 0;

        for (i=1; i<=iTab; i++) System.out.println("\t");
        System.out.println("Cod: " + this.getCod());

        System.out.println();

        return iNivel;

    }

    public String textInput(String label, Scanner l) {
        System.out.println(label);
        return l.nextLine();
    }

    public String completaString(String sAux, int iTam){

        for (int i=sAux.length(); i<iTam; i++){
            sAux += " ";
        }
        return sAux.substring(0, iTam); 
    }

}
