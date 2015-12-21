package com.church.visit.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class RecordCond extends BaseCond{
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date fromTime;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date toTime;
    /**0未领取;1已领取;2已探访;3已取消*/
    private Integer status;
    private Long uid;
    
	public Date getFromTime() {
		return fromTime;
	}
	public void setFromTime(Date fromTime) {
		this.fromTime = fromTime;
	}
	public Date getToTime() {
		return toTime;
	}
	public void setToTime(Date toTime) {
		this.toTime = toTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}

}
