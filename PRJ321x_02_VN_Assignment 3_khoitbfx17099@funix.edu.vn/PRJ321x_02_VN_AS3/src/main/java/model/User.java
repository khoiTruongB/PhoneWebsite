package model;

public class User {
	String mail;
	String password;
	int role;
	String name;
	String address;
	String phone;
	
	
	public User() {
		
	}

	




	public User(String mail, String password, int role, String name, String address, String phone) {

		this.mail = mail;
		this.password = password;
		this.role = role;
		this.name = name;
		this.address = address;
		this.phone = phone;
		
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getRole() {
		return role;
	}


	public void setRole(int role) {
		this.role = role;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		
		return getMail()+" | "+getPassword()+" | "+ getRole()+" | "+ getName()+" | "+getAddress()+" | "+getPhone();
	}
	
	
}
