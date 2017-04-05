package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.polito.tdp.anagrammi.model.Anagramma;


public class AnagrammaDAO {
	
	/*
	 * Ottengo la parola (se presente nel dizionario)
	 */
	public void getCheck(Anagramma anagramma) {
		
		final String sql = "SELECT nome "+
							"FROM parola "+
							"WHERE nome=?";
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, anagramma.getParola());

			ResultSet rs = st.executeQuery();

			if(rs.next()) {
				anagramma.setCorretto(true);
			}
			
			conn.close();

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}

}
