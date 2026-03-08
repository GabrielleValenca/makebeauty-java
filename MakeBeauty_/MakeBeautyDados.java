import java.time.LocalDate;

public class MakeBeautyDados extends MakeBeauty{

    private int id;
    private String marca;
    private String nomeProduto;
    private double preco;
    private java.time.LocalDate dataValid;

    public MakeBeautyDados(int id, String marca, String nomeProduto, double preco, LocalDate dataValid) {
        super(id, marca, nomeProduto, preco, dataValid);
        this.id = id;
        this.marca = marca;
        this.nomeProduto = nomeProduto;
        this.preco = preco;
        this.dataValid = dataValid;
    }

    public int getId() { return id; }
    public String getMarca() { return marca; }
    public String getNomeProduto() { return nomeProduto; }
    public double getPreco() { return preco; }
    public java.time.LocalDate getDataValid() { return dataValid; }
}
