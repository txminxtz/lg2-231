package bolsa;

//import java.time.LocalDate;
import java.time.LocalDateTime;

public class Pregao  {

    private String cod;
    private LocalDateTime data;
    
    //private Negociacoes negociacoes;

    public Pregao() {}

    public String getCod() {
        return this.cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public LocalDateTime getData() {
        return this.data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

}


