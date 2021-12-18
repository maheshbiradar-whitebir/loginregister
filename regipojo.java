package loginregiproject;

public class regipojo {

	private int rid;
	private String name,pwd,email,gender,country;
	private long phno;
	private String rdate;
	public regipojo() {
		
	}
	public regipojo(int rid, String name, String pwd, String email, String gender, String country, long phno,
			String rdate) {
		super();
		this.rid = rid;
		this.name = name;
		this.pwd = pwd;
		this.email = email;
		this.gender = gender;
		this.country = country;
		this.phno = phno;
		this.rdate = rdate;
	} 
	
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public long getPhno() {
		return phno;
	}
	public void setPhno(long phno) {
		this.phno = phno;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	
	
}
