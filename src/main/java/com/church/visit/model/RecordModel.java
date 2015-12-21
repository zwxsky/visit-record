package com.church.visit.model;

import java.util.List;

public class RecordModel extends Record{
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//被探访者名字
    private String name;
    //被探访者地址
    private String addr;
    //探访时间
    private String date;

    private Long uidEdit;

    private List<Visitor> visitors;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Long getUidEdit() {
		return uidEdit;
	}

	public void setUidEdit(Long uidEdit) {
		this.uidEdit = uidEdit;
	}

	public List<Visitor> getVisitors() {
		return visitors;
	}

	public void setVisitors(List<Visitor> visitors) {
		this.visitors = visitors;
	}
    
}
