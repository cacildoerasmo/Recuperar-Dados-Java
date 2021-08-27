package RecDados;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner; 

public class Estudante {
	
	public static void RecuperarDados() {
		
		Scanner sc = new Scanner(System.in);
	
			try {
				String myDriver = "org.gjt.mm.mysql.Driver";
				String myUrl = "jdbc:mysql://localhost/faculdade";
				Class.forName(myDriver);
				Connection conn = DriverManager.getConnection(myUrl, "root", "");

				String query = "SELECT * FROM Estudante est inner join Turma tur where fk_identificacao_turma = est.fk_identificacao_turma group by numero_matricula";
				Statement st = conn.createStatement();
				
				ResultSet rs = st.executeQuery(query);
				while(rs.next()) {
					int numero_matricula = rs.getInt("numero_matricula");
					String descricao = rs.getString("descricao");
					String nome = rs.getString("nome");
					String apelido= rs.getString("apelido");
					int telefone = rs.getInt("telefone");
					String endereco = rs.getString("endereco");
					
					System.out.format("%S, %S, %S, %S, %S, %S\n", numero_matricula, descricao, nome, apelido, telefone, endereco);
				}
				st.close();
				
				}catch(Exception e) {
					System.out.println("Erro!");
					System.out.println(e.getMessage());
				}
	
		}
	

	public static void main(String[] args) {
		
		
		RecuperarDados();
		
	}

}
