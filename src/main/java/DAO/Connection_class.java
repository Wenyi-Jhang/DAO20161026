package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Connection_class {
	private static int ID; 
	private static String action;
	public static Connection conn = null;
	
	public static void setid_action(String action,int id){
		Connection_class.ID =  id;
		Connection_class.action=action;
	}
	
	public static void connect() {
	try {
		Class.forName("com.mysql.jdbc.Driver");// 驅動程式
		System.out.println("連接成功 MySQLToJava");
		try {
			conn = getConnection();
		} catch (SQLException e) {
			System.out.println("無法連接到 MySQL" + e.getMessage());
			System.exit(0);
		}
        
		if (! checkid(conn,ID,action)) {
			conn.close();
			if (conn.isClosed()) {
				System.out.println("資料庫連接已關閉");
			}
			System.exit(0);
		}
		
	} catch (Exception e) {
		System.out.println("ERROR: " + e.getMessage());
		e.printStackTrace();
	}

}

	public static void connectOFF(Connection conn) {
		try {
			conn.close();
			if (conn.isClosed()) {
				System.out.println("資料庫連接已關閉");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

		public static Connection getConnection() throws SQLException {
			String datasource = "jdbc:mysql://localhost/Individual_Data?user=root&password=123456";
			return DriverManager.getConnection(datasource);// 連接資料庫		
		}
		
		public static Boolean checkid(Connection conn,int ID, String action) {
			Statement st;
			boolean tf = false;
			try {
				st = conn.createStatement();
				ResultSet rs = st.executeQuery("SELECT ID FROM basic");
				while (rs.next()) {
					if (String.valueOf(ID).equals(rs.getString("ID")))
						tf = true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			if (action.equals("insert") && tf == true) {
				System.out.println("The ID is reapted");
				return false;
			}
			if (!action.equals("insert") && tf == false) {
				System.out.println("The ID is not exist");
				return false;
			}
			return true;
		}

}
