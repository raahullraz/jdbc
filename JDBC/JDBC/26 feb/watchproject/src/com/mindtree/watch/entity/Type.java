package com.mindtree.watch.entity;

public class Type {
private int tid;
private String tname;

public int getTid() {
	return tid;
}
public void setTid(int tid) {
	this.tid = tid;
}
public String getTname() {
	return tname;
}
public void setTname(String tname) {
	this.tname = tname;
}
@Override
public String toString() {
	return "Type [tid=" + tid + ", tname=" + tname + "]";
}
public Type() {}
public Type(int tid, String tname) {
	//super();
	this.tid = tid;
	this.tname = tname;
}

}
