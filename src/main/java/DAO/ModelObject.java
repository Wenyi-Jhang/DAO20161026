package DAO;

public class ModelObject {
	private int ID; 
	private String Name;
	private String Gender;
	private String Date_of_Birth;
	private String action;
	
	ModelObject(int ID,String Name,String Gender,String Date_of_Birth){
		this.ID=ID;
		this.Name = Name;
		this.Gender=Gender;
		this.Date_of_Birth=Date_of_Birth;	
	}
	
	ModelObject(int ID){
		this.ID=ID;
	}
	
	public int getID(){
		return ID;
	}
	
	public String getName(){
		return Name;
	}
	
	public String getGender(){
		return Gender;
	}
	
	public String getDate_of_Birth(){
		return Date_of_Birth;
	}
	public String getaction(){
		return action;
	}


}
