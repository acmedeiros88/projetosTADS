package fabricaConexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaMysql {
	private static final String TIMEZONE ="?useSSL=false&useTimezone=true&serverTimezone=UTC";
	private static final String URL = "jdbc:mysql://localhost:3306/pgmv"+TIMEZONE;
	private static final String USER = "root";
	private static final String PASSWORD = "";
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static Connection conexao = null;


	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("Não foi possivel carregar o Driver do Banco");
		}
	}

	public static Connection getConexao() {
		try {
			if (conexao == null || conexao.isClosed()) {
				conexao = DriverManager.getConnection(URL, USER, PASSWORD);
			}
		} catch (SQLException ex) {
			System.out.println("Falha na conexão com o banco de dados");
			ex.printStackTrace();
		}
		return conexao;
	}

	public static void closeConexao() {
		if (conexao != null) {
			try {
				conexao.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
	}
}
