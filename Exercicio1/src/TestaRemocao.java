import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemocao {
	
	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory criaConexao = new ConnectionFactory();
		Connection connection = criaConexao.recuperarConexao();
		
		Statement stm = connection.createStatement();
		stm.execute("delete from produto where id >= 1");
		
		Integer lm = stm.getUpdateCount();
		
		System.out.println("QTD linhas modificadas = "+lm);
	}

}
