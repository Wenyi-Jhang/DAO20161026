package DAO;

import java.sql.Connection;

public interface DataDAO {
	public void insert(Connection conn,int ID,String Name,String Gender,String Date_of_Birth);
	public void update(Connection conn,int ID,String Name,String Gender,String Date_of_Birth);
	public void delete(Connection conn,int ID);
   public void query(Connection conn,int ID);
}