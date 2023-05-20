package schoolmanagment.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Management {
	
	@Id
	private int id;
	private String email;
	private String pwd;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


}
