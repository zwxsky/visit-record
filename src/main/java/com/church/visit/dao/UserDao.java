package com.church.visit.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.church.visit.model.User;
import com.church.visit.model.UserCond;

public interface UserDao {

	public Long insert(User user);
	
	public User queryByName(String name);

	public User getById(Long id);

	public List<User> getList(@Param("cond")UserCond cond);
}
