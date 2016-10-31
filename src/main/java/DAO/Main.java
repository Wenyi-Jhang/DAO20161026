package DAO;

import java.sql.SQLException;

public class Main {
	
	public static void main(String[] args) throws SQLException{
		
		Connection_class.setid_action(args[0], Integer.parseInt(args[1]));
		//set id and action
		Connection_class.connect(); 
		DataDAOImpl datadaoimpl = new DataDAOImpl();
		
		ModelObject modelobject = (args.length>2) ? new ModelObject(Integer.parseInt(args[1]),args[2],args[3],args[4])
				                    :new ModelObject(Integer.parseInt(args[1])); 
	
		switch (args[0]) {
		case "insert":
			datadaoimpl.insert(Connection_class.conn, modelobject.getID(),modelobject.getName(),
					             modelobject.getGender(), modelobject.getDate_of_Birth());
			break;
		case "delete":
			datadaoimpl.delete(Connection_class.conn, modelobject.getID());
			break;
		case "update":
			datadaoimpl.update(Connection_class.conn, modelobject.getID(),modelobject.getName(),
					             modelobject.getGender(), modelobject.getDate_of_Birth());
			break;
		case "query":
			datadaoimpl.query(Connection_class.conn, modelobject.getID()); 
			break;
		default:
			System.out.println("Wrong argument");
			System.exit(0);
		}
		datadaoimpl.showDB(Connection_class.conn);
		Connection_class.connectOFF(Connection_class.conn);//Close connection
	}

}
