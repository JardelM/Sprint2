import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) throws SQLException {
		Scanner in = new Scanner(System.in);

		ConnectionFactory criaConexao = new ConnectionFactory();
		Connection connection = criaConexao.recuperarConexao();
		ProdutoDAO produtoDAO = new ProdutoDAO(connection);

		int opcao = 0;

		do {
			System.out.println("1 - Insere 3 produtos");
			System.out.println("2 - Atualizar o primeiro produto");
			System.out.println("3 - Deleta primeiro produto");
			System.out.println("0 - Fecha aplicação");
			System.out.print("\nDigite a opção : ");
			opcao = in.nextInt();

			if (opcao == 1)
				produtoDAO.inserir();

			else if (opcao == 2) 
				produtoDAO.update();

			else if (opcao == 3)
				produtoDAO.removeSegundoProduto();

			else if (opcao < 0 || opcao > 3)
				System.out.println("Opção inválida");

		} while (opcao != 0);

		in.close();
		connection.close();

	}

}
