package schoolmanagment.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Assignment {

	@Id
	private int id;
	private String Que;
	private String Ans;
	//@Id
	private int stid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQue() {
		return Que;
	}
	public void setQue(String que) {
		Que = que;
	}
	public String getAns() {
		return Ans;
	}
	public void setAns(String ans) {
		Ans = ans;
	}
	public int getStid() {
		return stid;
	}
	public void setStid(int stid) {
		this.stid = stid;
	}
	
	
}
