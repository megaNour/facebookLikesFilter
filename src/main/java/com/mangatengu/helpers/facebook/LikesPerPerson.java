package com.mangatengu.helpers.facebook;

public class LikesPerPerson {
	String name;
	Integer count;
	public LikesPerPerson() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LikesPerPerson(String name, Integer count) {
		super();
		this.name = name;
		this.count = count;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return name + ": " + count;
	}
}
