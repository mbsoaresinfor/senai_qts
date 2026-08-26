package aula;


import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
*
* @author marcelo.soares
*/

public class BancoDados {

	private Connection connection = null;
	private static int id = 1;

	public BancoDados() {
		conectaBanco();
	}

	// CONECTA O BANCO DE DADOS H2 EM MEMORIA.
	private void conectaBanco() {

		try {
			String jdbcURL = "jdbc:h2:mem:test";

			connection = DriverManager.getConnection(jdbcURL);

			System.out.println("Connected to H2 in-memory database.");

			String sql = "Create table pessoa (ID int primary key , nome varchar(50), idade int,salario float)";

			Statement statement = connection.createStatement();

			statement.execute(sql);

			System.out.println("Created table pessoas.");
			
		} catch (Exception e) {
			System.out.println("Error ao conectar o banco de dados");
			e.printStackTrace();
		}

	}

	public int insertPessoa(Pessoa p) {
		id++;
		String sql = "insert into pessoa (id,nome,idade,salario) values("+ id +","+ "'" + p.getNome() + "'," 
					+ p.getIdade() + "," + p.getSalario() +" ) ";		
		p.setId(id);
		System.out.println("sql insert " + sql + " com id: " + id);

		try {
			connection.createStatement().executeUpdate(sql);
			return id;

		} catch (Exception e) {
			System.out.println("Error na insercao pessoa " + e);
			return -1;
		}

	}

	public boolean deletePessoa(int id) {
		String sql = "delete from  pessoa where id = " + id;
		System.out.println("sql delete " + sql);

		try {
			connection.createStatement().execute(sql);
		} catch (Exception e) {
			System.out.println("Error na remocao pessoa " + e);
			return false;
		}

		return true;
	}

	public boolean updatePessoa(Pessoa p) {
		String sql = "update  pessoa set nome = '" + p.getNome() + "', idade = " + p.getIdade() 
				+ ", salario = " + p.getSalario() + " where id = "
				+ p.getId();

		System.out.println("sql update " + sql);

		try {
			connection.createStatement().execute(sql);
		} catch (Exception e) {
			System.out.println("Error na update pessoa " + e);
			return false;
		}

		return true;
	}

	public List<Pessoa> listPessoa() {
		List<Pessoa> lista = new ArrayList<Pessoa>();
		String sql = "select * from pessoa";
		System.out.println("sql select " + sql);
		try {
			connection.createStatement().execute(sql);
			ResultSet resultSet = connection.createStatement().executeQuery(sql);

			while (resultSet.next()) {
				Pessoa pessoa = new Pessoa();
				pessoa.setId(resultSet.getInt("id"));
				pessoa.setNome(resultSet.getString("nome"));
				pessoa.setIdade(resultSet.getInt("idade"));
				pessoa.setSalario(resultSet.getFloat("salario"));
				lista.add(pessoa);
			}

		} catch (Exception e) {

		}

		return lista;
	}

	public Pessoa buscaPessoa(int idPessoa) {

		String sql = "select * from pessoa where id =" + idPessoa;
		;
		System.out.println("sql select " + sql);
		Pessoa pessoa = null;
		try {
			connection.createStatement().execute(sql);
			ResultSet resultSet = connection.createStatement().executeQuery(sql);

			while (resultSet.next()) {
				pessoa = new Pessoa();
				pessoa.setId(resultSet.getInt("id"));
				pessoa.setNome(resultSet.getString("nome"));
				pessoa.setIdade(resultSet.getInt("idade"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return pessoa;
	}

	public void limparBanco() {
		// TODO Auto-generated method stub
		
	}
}
