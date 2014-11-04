package model;

import com.mongodb.BasicDBObject;

public class Customer extends BasicDBObject {

	private static final long serialVersionUID = 1L;
	
	public int getId() {
		return super.getInt("_id"); 
	}
	
	public void setId(int id) {
		super.put("_id", id); 
	}
	
	public String getName() {
		return super.getString("name");
	}
	
	public void setName(String name) {
		super.put("name", name);
	}
	
	public String getProjectName() {
		return super.getString("projectName");
	}
	
	public void setProjectName(String projectName) {
		super.put("projectName", projectName);
	}
	
	public String getEmpId() {
		return super.getString("empId");
	}
	
	public void setEmpId(String empId) {
		super.put("empId", empId);
	}
	
	public String getPassword() {
		return super.getString("password");
	}
	
	public void setPassword(String password) {
		super.put("password", password);
	}
	
	public String getEmailId() {
		return super.getString("emailId");
	}
	
	public void setEmailId(String emailId) {
		super.put("emailId", emailId);
	}
}
