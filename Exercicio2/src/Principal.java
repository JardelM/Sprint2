import java.sql.Connection;
import java.sql.SQLException;

public class Principal {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperarConexao();

		FilmeDAO filmeDAO = new FilmeDAO(connection);

		filmeDAO.filmesParaAdicionar();

		filmeDAO.menuInicial();
	}
}
