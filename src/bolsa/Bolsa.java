package bolsa;

//import java.time.LocalDate;
//import java.time.LocalDateTime;

public class Bolsa  {

    private Lista l_Corretoras;
    private Lista l_Investidores;
    private Lista l_Ativos;
    private Lista l_Investimentos;

    public Bolsa() 
    {
        l_Corretoras = new Lista();
        l_Investidores = new Lista();
        l_Ativos = new Lista();
        l_Investimentos = new Lista();
 
    }

    public Lista getCorretoras() {
        return l_Corretoras;
    }

    public Lista getInvestidores() {
        return l_Investidores;
    }

    public Lista getAtivos() {
        return l_Ativos;
    }

    public Lista getInvestimentos() {
        return l_Investimentos;
    }

}


