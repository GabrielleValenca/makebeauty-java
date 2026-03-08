import java.time.LocalDate;

public class CuidadoCapilar extends MakeBeauty {
    private String tratamento;
    private String finalizador;
    private String limpeza;

    public CuidadoCapilar(int id, String marca, String nomeProduto, double preco, LocalDate dataValid, String tratamento, String finalizador, String limpeza){
        super( id,  marca,  nomeProduto,  preco,  dataValid);
        this.tratamento = tratamento;
        this.finalizador = finalizador;
        this.limpeza = limpeza;

    }
    public String getTratamento(){
        return tratamento;
    }
    public void setTratamento(String tratamento){
        this.tratamento = tratamento;
    }
    public String getFinalizador(){
        return finalizador;
    }
    public void setFinalizador(String finalizador){
        this.finalizador = finalizador;
    }
    public String getLimpeza(){
        return limpeza;
    }
    public void setLimpeza(String limpeza){
        this.limpeza = limpeza;
    }
}
