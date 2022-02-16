package biblioteca;

import java.sql.*;

public class FabricaDeConexao {

	private static String usuario = "root";
	private static String senha = "admin123";
	private static String textoDeConexao = "jdbc:mariadb://localhost:3306/empresa";
	
	public static Connection obterConexao() {
		Connection con = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			con = DriverManager.getConnection(textoDeConexao,usuario,senha);
			
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Erro de conexao!!!!!!!!!");
			e.printStackTrace();	
		}
		return con;
		
	}
	
}
