package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataDAOImpl implements DataDAO{
	
	@Override
	public void insert(Connection conn,int ID, String Name, String Gender, String Date_of_Birth) {
		// TODO Auto-generated method stub
		try {
			Statement st = conn.createStatement();
			st.executeUpdate("INSERT INTO basic VALUES("+ID+",'"+Name+"','"+Gender+"','"+ Date_of_Birth+"')");
			System.out.println("Success!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Connection conn,int ID, String Name, String Gender, String Date_of_Birth) {
		// TODO Auto-generated method stub
		try {
			Statement st = conn.createStatement();
			st.executeUpdate("UPDATE basic SET Name='"+Name+"', Gender='"+Gender+"',Date_of_Birth='"+Date_of_Birth+"'WHERE ID="+ID);
			System.out.println("Success!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
  
	@Override
	public void delete(Connection conn,int ID) {
		// TODO Auto-generated method stub
		try {
			Statement st = conn.createStatement();
			st.executeUpdate("DELETE FROM basic WHERE ID="+ID);
			System.out.println("Success!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void query(Connection conn,int ID) {
		// TODO Auto-generated method stub
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM basic WHERE ID="+ID);
			rs.last();
			System.out.println(rs.getString("ID") + " " + rs.getString("Name") + " " + rs.getString("Gender") + " "
					+ rs.getString("Date_of_Birth"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void showDB(Connection conn) throws SQLException {
		Statement st = conn.createStatement();
		ResultSet rs2 = st.executeQuery("SELECT * FROM basic ORDER BY ID");
		System.out.println("Database basic");
		while (rs2.next()) {
			System.out.println(rs2.getString("ID") + " " + rs2.getString("Name") + " " + rs2.getString("Gender") + " "
					+ rs2.getString("Date_of_Birth"));
		}

	}

}
