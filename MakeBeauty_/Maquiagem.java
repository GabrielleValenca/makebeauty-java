import java.time.LocalDate;

public class Maquiagem extends MakeBeauty {
    private String labios;
    private String rosto;
    private String olhos;
    private String preparacao;

    public Maquiagem(int id, String marca, String nomeProduto, double preco, LocalDate dataValid, String labios, String rosto, String olhos, String preparacao){
        super( id,  marca,  nomeProduto,  preco,  dataValid);
        this.labios = labios;
        this.rosto = rosto;
        this.olhos = olhos;
        this.preparacao = preparacao;       

    }
    public String getLabios(){
        return labios;
    }
    public void setLabios(String labios){
        this.labios = labios;
    }
    public String getRosto(){
        return rosto;
    }
    public void setRosto(String rosto){
        this.rosto = rosto;
    }
    public String getOlhos(){
        return olhos;
    }
    public void setOlhos(String olhos){
        this.olhos = olhos;
    }
    public String getPreparacao(){
        return preparacao;
    }
    public void setPreparacao(String preparacao){
        this.preparacao = preparacao;
    }   
}
