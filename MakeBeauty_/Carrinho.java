import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private List<MakeBeauty> itens = new ArrayList<>();

    public void adicionar(MakeBeauty item){
        itens.add(item);
    }

    public void mostrarCarrinho(){
        for(MakeBeauty m : itens){
            System.out.println(m.getNomeProduto() + "R$" + m.getPreco());
        }
    }

    public double total(){
        double soma = 0;
        for (MakeBeauty m : itens){
            soma += m.calcularValor();
        }
        return soma;
    }
}