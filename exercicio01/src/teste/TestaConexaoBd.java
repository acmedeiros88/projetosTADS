package teste;

import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexaoBd {

	public static void main(String[] args) throws SQLException {

		Connection con = fabricaConexao.FabricaMysql.getConexao();
		if (con != null) {
			System.out.println("Conexao realizada com sucesso");
			con.close();
		} else {
			System.out.println("Nao foi possivel conectar ao banco de dados");
		}
	}
}
