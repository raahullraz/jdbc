package com.mindtree.watch.entity;

public class Watch implements Comparable<Watch>{
	private int wid;
	private String wmodelnumber;
	private double wprice;
	
	public int getWid() {
		return wid;
	}
	public void setWid(int wid) {
		this.wid = wid;
	}
	public String getWmodelnumber() {
		return wmodelnumber;
	}
	public void setWmodelnumber(String wmodelnumber) {
		this.wmodelnumber = wmodelnumber;
	}
	public double getWprice() {
		return wprice;
	}
	public void setWprice(double wprice) {
		this.wprice = wprice;
	}
	@Override
	public String toString() {
		return "Watch [wid=" + wid + ", wmodelnumber=" + wmodelnumber + ", wprice=" + wprice + "]";
	}
	
	public Watch() {}
	
	public Watch(int wid, String wmodelnumber, double wprice) {
		super();
		this.wid = wid;
		this.wmodelnumber = wmodelnumber;
		this.wprice = wprice;
	}
	@Override
	public int compareTo(Watch k) {
		
		return (int) (this.wprice-k.wprice);
	}
	
}
