package bolsa;

//import java.util.Scanner;

/**
 * Implementação da estrutura de dados Lista Encadeada
 *
 * Implementação utilizando primeiro (head) e último nó da lista
 */
public class Lista {

    private No primeiro;
    private No ultimo;
    private int qt;

    public Lista(){
        primeiro = null;
        ultimo = null;
        qt = 0;
    }

    public int getQt() {
        return qt;
    }

    public No getPrimeiro() {
        return primeiro;
    }

    public No getUltimo() {
        return ultimo;
    }


    public void inserirPrimeiro(Elemento elemento, String sIndexador) {

        No novoNo = new No(elemento, sIndexador);

        primeiro = novoNo;
        ultimo = novoNo;
        qt = 1;

    }

    public void inserirNoInicio(Elemento elemento, String sIndexador) {

        if (qt == 0){
            inserirPrimeiro(elemento,  sIndexador);
            return;
        }

        No novoNo = new No(elemento, sIndexador);

        novoNo.setAnterior(null);
        novoNo.setProximo(primeiro);

        primeiro.setAnterior(novoNo);
        primeiro = novoNo;
        qt = qt + 1;
    }


    public void inserirNoFinal(Elemento elemento, String sIndexador) {

        if (qt == 0){
            inserirPrimeiro(elemento,  sIndexador);
            return;
        }

        No novoNo = new No(elemento, sIndexador);
        
        novoNo.setAnterior(ultimo);
        novoNo.setProximo(null);

        ultimo.setProximo(novoNo);
        ultimo = novoNo;

        qt = qt + 1;

    }

    public void inserirFilaCrescente(Elemento elemento, String sIndexador) {

        if (qt == 0){
            inserirPrimeiro(elemento,  sIndexador);
            return;
        }

        if (sIndexador.compareTo(primeiro.getIndexador()) <= 0)
        {
            this.inserirNoInicio(elemento,  sIndexador);
            return;
        }

        if (sIndexador.compareTo(ultimo.getIndexador()) > 0)
        {
            this.inserirNoFinal(elemento,  sIndexador);
            return;
        }

        No novoNo = new No(elemento, sIndexador);
        No atual;

        atual = primeiro;

        while (sIndexador.compareTo(atual.getProximo().getIndexador()) > 0) {                
            atual = atual.getProximo();
        }

        novoNo.setProximo(atual.getProximo());
        atual.setProximo(novoNo);

        qt++;

    }

    public void inserirPilhaCrescente(Elemento elemento, String sIndexador) {

        if (qt == 0){
            inserirPrimeiro(elemento,  sIndexador);
            return;
        }

        if (sIndexador.compareTo(primeiro.getIndexador()) < 0)
        {
            this.inserirNoInicio(elemento,  sIndexador);
            return;
        }

        //if (indexador >= ultimo.getIndexador())
        if (sIndexador.compareTo(ultimo.getIndexador()) >= 0)
        {
            this.inserirNoFinal(elemento,  sIndexador);
            return;
        }

        No novoNo = new No(elemento, sIndexador);
        No atual;

        atual = primeiro;

        while (sIndexador.compareTo(atual.getProximo().getIndexador()) >= 0) {                
            atual = atual.getProximo();
        }

        novoNo.setProximo(atual.getProximo());
        atual.setProximo(novoNo);

        qt++;

    }


    public void removerNoInicio() {

        if(qt == 0) {
            return;
        }

        primeiro = primeiro.getProximo();
        primeiro.setAnterior(null);
        qt--;

        if(qt == 0) {
            ultimo = null;
        }
    }

    public void removerNoFim() {

        if(qt == 0) {
            return;
        }

        ultimo = ultimo.getAnterior();
        ultimo.setProximo(null);
        qt--;

        if(qt == 0) {
            primeiro = null;
        }
    }

    public void imprimir() {
        if(qt == 0) {
            System.out.println("[]");
            return;
        }

        String indexadors = retornaElementos();
        System.out.println(indexadors);
    }

    String retornaElementos() {

        StringBuilder elementos = new StringBuilder("[");

        No atual = primeiro;

        while (atual.getProximo() != null) {
            elementos.append(atual.getIndexador());
            elementos.append(" ");
            atual = atual.getProximo();
        }

        elementos.append(atual.getIndexador());

        elementos.append("]");

        return elementos.toString();
    }

    public void exibeComponentes(int iTab) {

        No no = this.getPrimeiro();

        while (no != null){

            no.getElemento().mostraDados(iTab);

            no = no.getProximo();

        }
        
    }    

    public Elemento pesquisaElemento(String sCod) {

        Elemento elemento;

        No no = this.getPrimeiro();

        while (no != null){

            elemento = no.getElemento();

            //if (sCod.compareTo(elemento.getCod())==0) return elemento;
            if (sCod.equalsIgnoreCase(elemento.getCod())) return elemento;

            /* 
            System.out.print("");
            System.out.print(sCod + ", " + elemento.getCod() );
            System.out.print(" " + sCod.compareTo(elemento.getCod()));
            System.out.print(" ");
            System.out.print(sCod == elemento.getCod());
            */

            no = no.getProximo();

        }

        return null;
        
    }    


/* 
    public void cadastro(String sTipo, Scanner l) {

        String sIndexador = "";
        //No no=null;
        Elemento elemento = null;

        if (sTipo == "Ativo"){

            Ativo ativo = new Ativo();

            if (! ativo.dadosInput(l)) return;

            sIndexador = ativo.getNome();

            elemento = ativo;

            //no = new No(ativo, sIndexador);

        }
        else if (sTipo == "Corretora"){

            Corretora corretora = new Corretora();

            if (! corretora.dadosInput(l)) return;

            sIndexador = corretora.getCod();

            elemento = corretora;

        }
        else if (sTipo == "Investidor") {

            Investidor investidor = new Investidor();

            if (! investidor.dadosInput(l)) return;

            sIndexador = investidor.getCod();

            elemento = investidor;

        }
        else if (sTipo == "Investimento"){

            Investimento investimento = new Investimento();

            if (! investimento.dadosInput(l)) return;

            sIndexador = investimento.getCod();

            elemento = investimento;
            
        }

        this.inserirPilhaCrescente(elemento, sIndexador);
        System.out.println(sTipo + " " + sIndexador + " Adicionado com Sucesso !");

    }
*/
}
