import java.time.LocalDate;

public class CuidadoCorporal extends MakeBeauty {
    private String higieneCorporal;
    private String bodyCare;
    private String nailCare;
    private String skinCare;

    public CuidadoCorporal(int id, String marca, String nomeProduto, double preco, LocalDate dataValid, String higieneCorporal, String bodyCare, String nailCare, String skinCare){
        super(id, marca, nomeProduto, preco, dataValid);
        this.higieneCorporal = higieneCorporal;
        this.bodyCare = bodyCare;
        this.nailCare = nailCare;
        this.skinCare =  skinCare;

    }
    public String getHigieneCorporal(){
        return higieneCorporal;
    }
    public void setHigieneCorporal(String higieneCorporal){
        this.higieneCorporal = higieneCorporal;
    }
    public String getBodyCare(){
        return bodyCare;
    }
    public void setBodyCare(String bodyCare){
        this.bodyCare = bodyCare;
    }
    public String getNailCare(){
        return nailCare;
    }
    public void setNailCare(String nailCare){
        this.nailCare = nailCare;
    }
    public String getSkinCare(){
        return skinCare;
    }
    public void setSkinCare(String skinCare){
        this.skinCare = skinCare;
    }     
}
