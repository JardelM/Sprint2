import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.Filme;

public class FilmeDAO {

	private Connection connection;

	public FilmeDAO(Connection connection) {
		this.connection = connection;
	}

	public void salvar(Filme filme) throws SQLException {

		String sql = "Insert into Filme (id, nome, descricao, ano) values (?,?,?,?)";

		try (PreparedStatement pst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			pst.setInt(1, filme.getId());
			pst.setString(2, filme.getNome());
			pst.setString(3, filme.getDescricao());
			pst.setInt(4, filme.getAno());

			pst.execute();

			try (ResultSet rst = pst.getGeneratedKeys()) {

				while (rst.next()) {
					filme.setId(rst.getInt(1));
				}
			}
		}

	}

	public void filmesParaAdicionar() throws SQLException {

		Filme godfather = new Filme(1, "The Godfather", "Suspense", 1972);
		Filme citizen = new Filme(2, "Citizen Kane", "Suspense", 1954);
		Filme sindicato = new Filme(3, "Sindicato de Ladrões", "Ação", 1978);
		Filme sonho = new Filme(4, "Um sonho de liberdade", "Suspense", 1995);
		Filme rambo = new Filme(5, "Rambo", "Ação", 1981);
		Filme rambo2 = new Filme(6, "Rambo II", "Ação", 1982);
		Filme rambo3 = new Filme(7, "Rambo III", "Ação", 1985);
		Filme rambo4 = new Filme(8, "Rambo IV", "Ação", 1999);
		Filme rambo5 = new Filme(9, "Rambo V", "Ação", 2008);
		Filme jhon = new Filme(10, "Jhon Wick", "Aventura", 1972);
		Filme godfather2 = new Filme(11, "The Godfather II", "Suspense", 1972);
		Filme godfather3 = new Filme(12, "The Godfather III", "Suspense", 1972);
		Filme psico = new Filme(13, "Psicose", "Terror", 1972);
		Filme place = new Filme(14, "No place for old men", "Suspense", 1972);
		Filme jhon3 = new Filme(15, "Jhon Wick III", "Suspense", 1972);
		Filme rocky = new Filme(16, "Rocky", "Ação", 1980);
		Filme rocky2 = new Filme(17, "Rocky II", "Ação", 1982);
		Filme rocky3 = new Filme(18, "Rocky III", "Ação", 1987);
		Filme rocky4 = new Filme(19, "Rocky IV", "Ação", 1990);
		Filme rocky5 = new Filme(20, "Rocky V", "Ação", 1992);

		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			FilmeDAO filmeDAO = new FilmeDAO(connection);
			filmeDAO.salvar(godfather);
			filmeDAO.salvar(citizen);
			filmeDAO.salvar(sindicato);
			filmeDAO.salvar(sonho);
			filmeDAO.salvar(rambo);
			filmeDAO.salvar(rambo2);
			filmeDAO.salvar(rambo3);
			filmeDAO.salvar(rambo4);
			filmeDAO.salvar(rambo5);
			filmeDAO.salvar(jhon);
			filmeDAO.salvar(godfather2);
			filmeDAO.salvar(godfather3);
			filmeDAO.salvar(psico);
			filmeDAO.salvar(place);
			filmeDAO.salvar(jhon3);
			filmeDAO.salvar(rocky);
			filmeDAO.salvar(rocky2);
			filmeDAO.salvar(rocky3);
			filmeDAO.salvar(rocky4);
			filmeDAO.salvar(rocky5);

			System.out.println("O banco de dados foi populado com 20 filmes!\n");

		} catch (Exception e) {
			System.out.println("O banco de dados já foi populado\n");
		}

	}

	public List<Filme> listar() throws SQLException {

		List<Filme> filmes = new ArrayList<Filme>();

		String sql = "select * from filme";

		try (PreparedStatement pstm = connection.prepareStatement(sql)) {

			pstm.execute();

			try (ResultSet rst = pstm.getResultSet()) {
				while (rst.next()) {
					Filme filme = new Filme(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getInt(4));

					filmes.add(filme);

				}
			}

		}

		return filmes;
	}

	public void menuInicial() throws SQLException {
		Scanner in = new Scanner(System.in);

		FilmeDAO filmeDAO = new FilmeDAO(connection);

		int opcao = 0, pagina = 0, qtFilmes = 0;

		do {
			System.out.print("Digite a pagina que deseja acessar, de 1 a 5 : ");
			opcao = in.nextInt();

			if (opcao == 1)
				pagina = 0;

			else if (opcao == 2)
				pagina = 4;

			else if (opcao == 3)
				pagina = 8;

			else if (opcao == 4)
				pagina = 12;

			else if (opcao == 5)
				pagina = 16;

			else
				System.out.println("Página inválida, tente novamente\n");

		} while (opcao <= 0 || opcao > 5);

		do {
			System.out.print("Quantos filmes deseja ver? : ");
			qtFilmes = in.nextInt();

			if (qtFilmes <= 0 || qtFilmes > 20)
				System.out.println("Valor inválido, digite de 1 a 20 !");

		} while (qtFilmes <= 0 || qtFilmes > 20);

		List<Filme> listaDeFilmes = filmeDAO.listar();

		if (pagina + qtFilmes > listaDeFilmes.size())
			System.out.println("Não existe essa quantidade de filmes nessa pagina!");
		else
			listaDeFilmes.subList(pagina, pagina + qtFilmes).forEach(System.out::println);

		in.close();

	}

}
