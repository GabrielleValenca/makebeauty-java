import java.time.LocalDate;


public abstract class MakeBeauty implements Venda{
    private int id;
    private String marca;
    private String nomeProduto;
    private double preco;
    private LocalDate dataValid;

    public MakeBeauty(int id, String marca, String nomeProduto, double preco, LocalDate dataValid){
        this.id = id;
        this.marca = marca;
        this.nomeProduto = nomeProduto;
        this.preco = preco;
        this.dataValid = dataValid;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getMarca(){
        return marca;
    }
    public void setMarca(String marca){
        this.marca = marca;
    }
    public String getNomeProduto(){
        return nomeProduto;
    }
    public void setNomeProduto(String nomeProduto){
        this.nomeProduto = nomeProduto;
    }
    public double getPreco(){
        return preco;
    }
    public void setPreco(double preco){
        this.preco = preco;
    }
    public LocalDate getDataValid(){
        return dataValid;
    }
    public void setDataValid(LocalDate dataValid){
        this.dataValid = dataValid;

    }   
    @Override
    public double calcularValor(){
        return preco;
    }

}
