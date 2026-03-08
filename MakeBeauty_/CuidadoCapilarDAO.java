import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CuidadoCapilarDAO {

    public void inserir(CuidadoCapilar c) {
        String sql = "INSERT INTO cuidado_capilar (id, tratamento, finalizador, limpeza) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, c.getId()); // id vem da tabela mãe
            stmt.setString(2, c.getTratamento());
            stmt.setString(3, c.getFinalizador());
            stmt.setString(4, c.getLimpeza());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<CuidadoCapilar> listar() {
        List<CuidadoCapilar> lista = new ArrayList<>();

        String sql = """
            SELECT * FROM makeBeauty 
            INNER JOIN cuidado_capilar ON makeBeauty.id = cuidado_capilar.id
        """;

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                CuidadoCapilar c = new CuidadoCapilar(
                    rs.getInt("id"),
                    rs.getString("marca"),
                    rs.getString("nome_produto"),
                    rs.getDouble("preco"),
                    rs.getDate("data_valid").toLocalDate(),
                    rs.getString("tratamento"),
                    rs.getString("finalizador"),
                    rs.getString("limpeza")
                );

                lista.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    public void atualizar(CuidadoCapilar c) {
        String sql = "UPDATE cuidado_capilar SET tratamento=?, finalizador=?, limpeza=? WHERE id=?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, c.getTratamento());
            stmt.setString(2, c.getFinalizador());
            stmt.setString(3, c.getLimpeza());
            stmt.setInt(4, c.getId());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletar(int id) {
        String sql = "DELETE FROM cuidado_capilar WHERE id=?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
