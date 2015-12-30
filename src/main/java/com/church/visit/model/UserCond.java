package com.church.visit.model;

public class UserCond  extends BaseCond{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**类型: 
	 0:同工 
	 1:朋友男, 2:朋友女 
	 3:弟兄, 4:姊妹 
	 5:男孩, 6:女孩*/
	private Integer type;

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	

}
