import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CuidadoCorporalDAO {

    public void inserir(CuidadoCorporal c) {
        String sql = "INSERT INTO cuidado_corporal (id, higiene_corporal, body_care, nail_care, skin_care) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, c.getId());
            stmt.setString(2, c.getHigieneCorporal());
            stmt.setString(3, c.getBodyCare());
            stmt.setString(4, c.getNailCare());
            stmt.setString(5, c.getSkinCare());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<CuidadoCorporal> listar() {
        List<CuidadoCorporal> lista = new ArrayList<>();

        String sql = """
            SELECT * FROM makeBeauty 
            INNER JOIN cuidado_corporal ON makeBeauty.id = cuidado_corporal.id
        """;

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                CuidadoCorporal c = new CuidadoCorporal(
                    rs.getInt("id"),
                    rs.getString("marca"),
                    rs.getString("nome_produto"),
                    rs.getDouble("preco"),
                    rs.getDate("data_valid").toLocalDate(),
                    rs.getString("higiene_corporal"),
                    rs.getString("body_care"),
                    rs.getString("nail_care"),
                    rs.getString("skin_care")
                );

                lista.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    public void atualizar(CuidadoCorporal c) {
        String sql = "UPDATE cuidado_corporal SET higiene_corporal=?, body_care=?, nail_care=?, skin_care=? WHERE id=?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, c.getHigieneCorporal());
            stmt.setString(2, c.getBodyCare());
            stmt.setString(3, c.getNailCare());
            stmt.setString(4, c.getSkinCare());
            stmt.setInt(5, c.getId());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletar(int id) {
        String sql = "DELETE FROM cuidado_corporal WHERE id=?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
