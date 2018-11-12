package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Contato;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ContatoDao {
	private Connection connection;

	public ContatoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Contato contato) {
		// codigo SQL
		String sql = "insert into contatos" + "(nome,email,endereco,dataNascimento)" + "values (?,?,?,?)";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, null);

			// executa statement
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Contato> getLista() throws SQLException {
		List<Contato> listaDeContatos = new ArrayList<>();
		try {
			String sql = "SELECT * FROM contatos";
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Contato contato = new Contato();

				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				// contato.setDataNascimento(rs.getDate(0));

				listaDeContatos.add(contato);

			}
		} catch (SQLException ex) {
			Logger.getLogger(ContatoDao.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			connection.close();
		}

		return listaDeContatos;
	}
}
