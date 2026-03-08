import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MakeBeautyDAO {

    // INSERIR APENAS OS CAMPOS DA TABELA MÃE
    public void inserir(MakeBeauty m) {
        String sql = "INSERT INTO makeBeauty (marca, nome_produto, preco, data_valid) VALUES (?,?,?,?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, m.getMarca());
            stmt.setString(2, m.getNomeProduto());
            stmt.setDouble(3, m.getPreco());
            stmt.setDate(4, java.sql.Date.valueOf(m.getDataValid()));

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                m.setId(rs.getInt(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // LISTA SOMENTE OS DADOS BÁSICOS
    public List<MakeBeautyDados> listar() {
        List<MakeBeautyDados> lista = new ArrayList<>();

        String sql = "SELECT * FROM makeBeauty";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                lista.add(new MakeBeautyDados(
                    rs.getInt("id"),
                    rs.getString("marca"),
                    rs.getString("nome_produto"),
                    rs.getDouble("preco"),
                    rs.getDate("data_valid").toLocalDate()
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    public void atualizar(MakeBeauty m) {
        String sql = "UPDATE makeBeauty SET marca=?, nome_produto=?, preco=?, data_valid=? WHERE id=?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, m.getMarca());
            stmt.setString(2, m.getNomeProduto());
            stmt.setDouble(3, m.getPreco());
            stmt.setDate(4, java.sql.Date.valueOf(m.getDataValid()));
            stmt.setInt(5, m.getId());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletar(int id) {
        String sql = "DELETE FROM makeBeauty WHERE id=?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
