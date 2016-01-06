package com.cwitter.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cwitter.dao.UserDao;
import com.cwitter.dto.User;

@Service
public class UserLocalServiceImpl implements UserLocalService{
	@Autowired
	@Qualifier("userDao")
	private UserDao userDao;
		
	@Override
	public User saveUser(User user) {
		//UserDao userDao = new UserDaoImpl();

		return userDao.saveUser(user);
		
	}

	@Override
	@Transactional
	public User getUser(User user) {
		//UserDao userDao = new UserDaoImpl();
		return userDao.getUser(user);
	}

	@Override
	@Transactional
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
