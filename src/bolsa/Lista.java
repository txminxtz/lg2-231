package bolsa;

//import java.util.Scanner;

/**
 * Implementação da estrutura de dados Lista Encadeada
 *
 * Implementação utilizando primeiro (head) e último nó da lista
 */
public class Lista {

    private String tipo;
    private No primeiro;
    private No ultimo;
    private int qt;

    public Lista(String sTipo){
        tipo = sTipo;
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

        atual.getProximo().setAnterior(novoNo);
        novoNo.setProximo(atual.getProximo());
        novoNo.setAnterior(atual);
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

        atual.getProximo().setAnterior(novoNo);
        novoNo.setProximo(atual.getProximo());
        novoNo.setAnterior(atual);
        atual.setProximo(novoNo);

        qt++;

    }

    public void removeNo(No no) {

        No no_anterior, no_proximo;

        if (no == primeiro) {
            removePrimeiroNo();
            return;
        }

        if (no == ultimo) {
            removeUltimoNo();
            return;
        }

        no_anterior = no.getAnterior();
        no_proximo = no.getProximo();

        no_anterior.setProximo(no_proximo);
        no_proximo.setAnterior(no_anterior);

        qt--;

    }


    public void removePrimeiroNo() {

        if(qt == 0) {
            return;
        }

        primeiro = primeiro.getProximo();
        if (primeiro != null) primeiro.setAnterior(null);

        qt--;

        if(qt == 0) {
            ultimo = null;
        }
    }

    public void removeUltimoNo() {

        if(qt == 0) {
            return;
        }

        ultimo = ultimo.getAnterior();
        if (ultimo != null) ultimo.setProximo(null);
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

    public void exibeComponentes(int iTab, boolean bCrescente) {

        No no;

        if (this.qt == 0) {
            System.out.println("Nao ha Registro de "+this.tipo+".");
            return;
        }

        if (bCrescente )    no = this.getPrimeiro();
        else                no = this.getUltimo();

        int iNivel = 1;

        while (no != null){

            if (iNivel > 0) no.getElemento().mostraCabecalho(iTab);

            iNivel = no.getElemento().mostraDados(iTab);

            if (bCrescente)    no = no.getProximo();
            else                no = no.getAnterior();

        }
        
    }    

    public No procuraNo( 
        String sIndexador,
        String sTipo	// > Maior; < Menor; <> Indiferente
        ) {

        No no_atual;

        String sAux;
        int iTam;

        sAux = "<>";

        if (!sAux.contains(sTipo)) return null;

        iTam = sIndexador.length();

        if (sTipo==">") no_atual = this.ultimo;
        else            no_atual = this.primeiro;

        while (no_atual!=null) {                
            
            sAux = no_atual.getIndexador();
            sAux = sAux.substring(0,iTam);

            if (sIndexador.equalsIgnoreCase(sAux))  {
                return no_atual;   
            }             
            
            if (sTipo==">") { 
                no_atual = no_atual.getAnterior();
            }
            else { 
                no_atual = no_atual.getProximo();
            }
            
        }

        return null;

    }

    public No procuraNo_Ordem( 
        Ordem ordem
        ) {

        No no;
        Ordem ordemNo;

        no = this.primeiro;

        while (no !=null) {                
            
            ordemNo = (Ordem)no.getElemento();

            if (ordem == ordemNo)  {
                return no;   
            }             
        
            else { 
                no = no.getProximo();
            }
            
        }

        return null;

    }



}
