package com.church.visit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.church.visit.dao.UserDao;
import com.church.visit.model.User;
import com.church.visit.model.UserCond;
import com.church.visit.utils.LongUtils;
import com.church.visit.utils.PwdEncoder;

/**
 * @author philip
 *
 */
@Service("userService")
public class UserService {
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private PwdEncoder pwdEncoder;
	
	/**
	 * 管理员创建新用户
	 * 需要校验管理权限
	 * @param user
	 * @param uid
	 * @return
	 */
	public User create(User user, Long uid) {
		
		//check uid permission
		
		userDao.insert(init(user));
		return user;
	}

	private User init(User user) {
		user.setIsDisable(false);
		return user;
	}
	
	/**
	 * 用户登陆
	 * @param user
	 * @return
	 */
	public User doLogin(User user) {

		User _user = userDao.queryByName(user.getName());
		if(_user == null) {
			
		}
		if(_user.getIsDisable()) {
			
		}
		if(!pwdEncoder.isPasswordValid(_user.getPwd(), _user.getPwd())) {
			
		}
		return user;
	}

	public User getOne(Long id) {
		if(LongUtils.isEmpty(id)){
			return null;
		}
		
		return userDao.getById(id);
	}

	public List<User> getList(UserCond cond) {
		// TODO Auto-generated method stub
		return userDao.getList(cond);
	}
	
}
