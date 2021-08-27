package RecDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Turma {
	
	
	public static void main(String[] args) {
	
		try {
			String myDriver = "org.gjt.mm.mysql.Driver";
			String myUrl = "jdbc:mysql://localhost/faculdade";
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "root", "");

			String query = "SELECT * FROM Turma";
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				int identificacao = rs.getInt("identificacao");
				String descricao = rs.getString("descricao");
				
				System.out.format("%S, %S\n", identificacao, descricao);
			}
			st.close();
			
			}catch(Exception e) {
				System.out.println("Erro!");
				System.out.println(e.getMessage());

			}
	}

}
