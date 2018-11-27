package com.dx.pojo;

public class Recommendation {
	private int recommendationId;
	private int userId;
	private String name;
	private String author;
	private String bookType;
	private String brief;
	private int storage;
	private float costPrice;
	private float nowPrice;
	private String imgPath;
	private String isSold;
	private String recommendation;
	private String belongToAdmin;
	
	public Recommendation() {
		super();
	}

	public Recommendation(int recommendationId, int userId, String name, String author, String bookType, String brief,
			int storage, float costPrice, float nowPrice, String imgPath, String isSold, String recommendation,
			String belongToAdmin) {
		super();
		this.recommendationId = recommendationId;
		this.userId = userId;
		this.name = name;
		this.author = author;
		this.bookType = bookType;
		this.brief = brief;
		this.storage = storage;
		this.costPrice = costPrice;
		this.nowPrice = nowPrice;
		this.imgPath = imgPath;
		this.isSold = isSold;
		this.recommendation = recommendation;
		this.belongToAdmin = belongToAdmin;
	}

	public int getRecommendationId() {
		return recommendationId;
	}

	public void setRecommendationId(int recommendationId) {
		this.recommendationId = recommendationId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getBookType() {
		return bookType;
	}

	public void setBookType(String bookType) {
		this.bookType = bookType;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public int getStorage() {
		return storage;
	}

	public void setStorage(int storage) {
		this.storage = storage;
	}

	public float getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(float costPrice) {
		this.costPrice = costPrice;
	}

	public float getNowPrice() {
		return nowPrice;
	}

	public void setNowPrice(float nowPrice) {
		this.nowPrice = nowPrice;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getIsSold() {
		return isSold;
	}

	public void setIsSold(String isSold) {
		this.isSold = isSold;
	}

	public String getRecommendation() {
		return recommendation;
	}

	public void setRecommendation(String recommendation) {
		this.recommendation = recommendation;
	}

	public String getBelongToAdmin() {
		return belongToAdmin;
	}

	public void setBelongToAdmin(String belongToAdmin) {
		this.belongToAdmin = belongToAdmin;
	}
	
}
