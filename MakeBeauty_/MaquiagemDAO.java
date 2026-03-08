import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MaquiagemDAO {

    public void inserir(Maquiagem m) {
        String sql = "INSERT INTO maquiagem (id, labios, rosto, olhos, preparacao) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, m.getId());
            stmt.setString(2, m.getLabios());
            stmt.setString(3, m.getRosto());
            stmt.setString(4, m.getOlhos());
            stmt.setString(5, m.getPreparacao());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Maquiagem> listar() {
        List<Maquiagem> lista = new ArrayList<>();

        String sql = """
            SELECT * FROM makeBeauty 
            INNER JOIN maquiagem ON makeBeauty.id = maquiagem.id
        """;

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Maquiagem m = new Maquiagem(
                    rs.getInt("id"),
                    rs.getString("marca"),
                    rs.getString("nome_produto"),
                    rs.getDouble("preco"),
                    rs.getDate("data_valid").toLocalDate(),
                    rs.getString("labios"),
                    rs.getString("rosto"),
                    rs.getString("olhos"),
                    rs.getString("preparacao")
                );

                lista.add(m);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    public void atualizar(Maquiagem m) {
        String sql = "UPDATE maquiagem SET labios=?, rosto=?, olhos=?, preparacao=? WHERE id=?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, m.getLabios());
            stmt.setString(2, m.getRosto());
            stmt.setString(3, m.getOlhos());
            stmt.setString(4, m.getPreparacao());
            stmt.setInt(5, m.getId());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletar(int id) {
        String sql = "DELETE FROM maquiagem WHERE id=?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
