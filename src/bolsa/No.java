package bolsa;

//import java.util.Scanner;

public class No {

    private Elemento elemento;
    private String indexador;
    private No anterior;
    private No proximo;

    public No (){}

    public No (Elemento elemento, String indexador){
        this.indexador = indexador;
        this.elemento = elemento;
        this.anterior = null;
        this.proximo = null;
    }

    public Elemento getElemento() {
        return elemento;
    }

    public void setElemento(Elemento elemento) {
        this.elemento = elemento;
    }

    public String getIndexador() {
        return indexador;
    }

    public void setIndexador(String indexador) {
        this.indexador = indexador;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No no) {
        this.proximo = no;
    }

    public No getAnterior() {
        return anterior;
    }

    public void setAnterior(No no) {
        this.anterior = no;
    }

    /* 
    public void mostraDados(){ 

        System.out.println("\tElemento: " + this.getElemento().getCod());
        System.out.println("\tIndexador: " + this.getIndexador());
        System.out.println();

    }

    public String textInput(String label, Scanner l) {
        System.out.println(label);
        return l.nextLine();
    }

*/


}
