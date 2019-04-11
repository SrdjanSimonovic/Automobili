package automobili;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Metode {

	private Connection konektujSe(String baza) throws SQLException {
		
		final String url = "jdbc:mysql://localhost:3306/"+baza;
		final String username = "root";
		final String password = "root";
		
		return DriverManager.getConnection(url, username, password);
		
		
	}
	
	public void ubaciMarku(String naziv_marke, String zemlja) {
		
			Connection konekcija = null;
			PreparedStatement pst = null;
		
		try {
			konekcija = konektujSe("automobili");
			String query = "Insert into marke VALUES (null,?,?)";
			pst = konekcija.prepareStatement(query);
			pst.setString(1, naziv_marke);
			pst.setString(2,zemlja);
			pst.execute();
			
			System.out.println("Uspesan unos.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Neuspesan unos.");
			e.printStackTrace();
		}finally {
			
			if(pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(konekcija != null) {
				try {
					konekcija.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		
	}
	
	
	
	
	
}
