package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import bean.UsuarioBean;
import fabricaConexao.FabricaMysql;


public class UsuarioDao {
	public void cadastrar(UsuarioBean usuario) {
		String sql = "INSERT INTO usuario(nome,login,senha) VALUES(?,?,?)";
		Connection conexao = FabricaMysql.getConexao();

		try {
			PreparedStatement comando = conexao.prepareStatement(sql);
			comando.setString(1, usuario.getNome());
			comando.setString(2, usuario.getLogin());
			comando.setString(3, usuario.getSenha());
			comando.execute();
			FabricaMysql.closeConexao();
		} catch (SQLException e) {
			System.out.println("Não foi possivel cadastrar o usuario no BD");
			e.printStackTrace();
		}
	}

	public boolean validarLogin(String login, String senha) {
		String sql = "SELECT login,senha FROM usuario WHERE login=? and senha=?";
		Connection conexao = FabricaMysql.getConexao();
		boolean valido = false;
		try {
			PreparedStatement comando = conexao.prepareStatement(sql);
			comando.setString(1, login);
			comando.setString(2, senha);
			ResultSet cursor = comando.executeQuery();
			if (cursor.next()) {
				valido = true;
			}
			cursor.close();
			comando.close();
			FabricaMysql.closeConexao();
		} catch (SQLException e) {
			System.out.println("Não foi possivel buscar o login e senha no BD");
			e.printStackTrace();
		}
		return valido;
	}

	public List<UsuarioBean> getLista() {
		List<UsuarioBean> lista = new ArrayList<>();
		String sql = "SELECT * FROM usuario";
		Connection conexao = FabricaMysql.getConexao();
		try {
			PreparedStatement comando = conexao.prepareStatement(sql);
			ResultSet cursor = comando.executeQuery();
			while (cursor.next()) {
				String nome = cursor.getString("nome");
				String login = cursor.getString("login");
				String senha = cursor.getString("senha");
				UsuarioBean usuario = new UsuarioBean(nome, login, senha);
				lista.add(usuario);
			}
		} catch (SQLException e) {
			System.out.println("Não foi possivel buscar os usuarios cadastrado");
			e.printStackTrace();
		}
		return lista;
	}
}
