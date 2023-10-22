## Bolsa de Valores

O projeto simula um pregão na bolsa de valores 

## Estrutura

A aplicação permite cadastrar as seguintes entidades: 

- Ativos
- Corretoras
- Investidores
- Contas

Além disso, permite executar as seguintes operações:

- Oferta Publica de Ações (OPA)
- Deposito em conta 
- Compra de OPA
- Inclusão, alteração e edição de ordens

Gerando os seguintes resultados:

- Negociações
- Carteira de investimentos
- Inclusão de ordens

Os dados podem ser consultados nos seguintes relatórios:

- Ativos
- Corretoras
- Investidores
- Contas
- Investimentos
- Ordens
- Negociações

A aplicação foi desenvolvida utilizando conceitos de orientação a objetos e consistiu na criação das seguintes classes:

public abstract class Elemento {

    private String tipo;
    private String cod;

}

public class Ativo extends Elemento {

    private String nome;
    private int qt;
    private int qt_disponivel;
    private Double preco;
    private Lista investimentos;

}

public class Corretora extends Elemento {

    private String nome;
    private Lista contas;
}

public class Investidor extends Elemento {

    private String nome;
    private String cpf;
    private Lista contas;
}

public class Conta extends Elemento {

    private Corretora corretora;
    private Investidor investidor;
    private Double saldo;
    private Lista ordens;
    private Lista investimentos;
    private Lista negociacoes;
}


public abstract class Negocio extends Elemento {

    private Conta conta;
    private Ativo ativo;
    private int qt;
    private Double preco;
}

public class Investimento extends Negocio {
}

public class Ordem extends Negocio{

    private int qt_executada;
    private int qt_restante;
    private Date data;
}

public class Negociacao extends Elemento{

    private Ordem ordem_compra;
    private Ordem ordem_venda;
    private int qt;
    private double preco;
    private LocalDateTime data;
}

O pregão é representado pela classe bolsa que contém uma série de listas encadeadas, implementadas conforme descrição a seguir.

public class No {

    private Elemento elemento;
    private String indexador;
    private No anterior;
    private No proximo;
}

public class Lista {

    private String tipo;
    private No primeiro;
    private No ultimo;
    private int qt;
}

public class Bolsa  {

    private Lista l_Ativos;
    private Lista l_Corretoras;
    private Lista l_Investidores;
    private Lista l_Contas;
    private Lista l_Investimentos;
    private Lista l_Ordens;
    private Lista l_Negociacoes;
}

O programa pode ser executado a partir do arquivo Main.java, onde ja estão incluidas alguns objetos das classes para teste. 


## Integrantes do Grupo

O grupo é formado pelos seguintes integrantes:

- Anna Carolina
- Bruno Taminato
- Caio Lucas Bertaglia
- Giovana Obeid
- Pedro Guilherme
- Janiely Vieira
