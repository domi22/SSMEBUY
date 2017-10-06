package com.del.pojo;

import java.io.Serializable;

public class Details implements Serializable {
	private Integer detailid;
	private Integer indentid;
	private Integer shangid;
	private Integer gcount;
	public Details() {
		super();
	}
	public int getDetailid() {
		return detailid;
	}
	public void setDetailid(int detailid) {
		this.detailid = detailid;
	}
	public int getIndentid() {
		return indentid;
	}
	public void setIndentid(int indentid) {
		this.indentid = indentid;
	}
	public int getShangid() {
		return shangid;
	}
	public void setShangid(int shangid) {
		this.shangid = shangid;
	}
	public int getGcount() {
		return gcount;
	}
	public void setGcount(int gcount) {
		this.gcount = gcount;
	}
	
}
