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

}
