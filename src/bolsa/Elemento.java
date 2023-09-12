package bolsa;

import java.util.Scanner;

public class Elemento {

    private String tipo;
    private String cod;

    public Elemento (){}

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

    public void mostraDados(int iTab){ 

        int i;

        for (i=1; i<=iTab; i++) System.out.println("\t");

        System.out.println("Cod: " + this.getCod());
        System.out.println();

    }

    public String textInput(String label, Scanner l) {
        System.out.println(label);
        return l.nextLine();
    }

}
