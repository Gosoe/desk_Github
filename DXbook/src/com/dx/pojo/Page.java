package com.dx.pojo;

public class Page {
	
	private int currentPage=1;     //当前页面数
	private int pageSize; //每一页的数据条数
	private int pageSum;   //数据总页数
	private int dataCount; //数据条数
	
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageSum() {
		//求总页数
		int i=this.dataCount%this.pageSize;
		if(i==0){
			this.pageSum=this.dataCount/this.pageSize;			
		}else{
			this.pageSum=this.dataCount/this.pageSize+1;
		}
		return pageSum;
	}
	public void setPageSum(int pageSum) {
		this.pageSum = pageSum;
	}
	public int getDataCount() {
		return dataCount;
	}
	public void setDataCount(int dataCount) {
		this.dataCount = dataCount;
	}
	
	
	
}
