package com.sahabt.borrow.dto.response;

public class Deadline {
	private int day;
	private int mount;
	private int year;
	public Deadline() {

	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMount() {
		return mount;
	}
	public void setMount(int mount) {
		this.mount = mount;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	@Override
	public String toString() {
		return "Deadline [day=" + day + ", mount=" + mount + ", year=" + year + "]";
	}
	
	
	
	

}
