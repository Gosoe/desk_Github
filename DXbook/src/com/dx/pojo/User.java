package com.dx.pojo;

public class User {
	private int userId;
	private String account;
	private String password;
	private String name;
	private String sex;
	private String IDCard;
	private String postAddress;
	private String postCode;
	private String email;
	private float money;
	private String isAdmin;
	
	private float addMoney;
	
	public float getAddMoney() {
		return addMoney;
	}
	public void setAddMoney(float addMoney) {
		this.addMoney = addMoney;
	}

	public User() {
		super();
	}

	public User(int userId, String account, String password, String name, String sex, String iDCard, String postAddress,
			String postCode, String email, float money, String isAdmin) {
		super();
		this.userId = userId;
		this.account = account;
		this.password = password;
		this.name = name;
		this.sex = sex;
		IDCard = iDCard;
		this.postAddress = postAddress;
		this.postCode = postCode;
		this.email = email;
		this.money = money;
		this.isAdmin = isAdmin;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getIDCard() {
		return IDCard;
	}
	public void setIDCard(String iDCard) {
		IDCard = iDCard;
	}
	public String getPostAddress() {
		return postAddress;
	}
	public void setPostAddress(String postAddress) {
		this.postAddress = postAddress;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
		this.money = money;
	}
	public String getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}
	
}
