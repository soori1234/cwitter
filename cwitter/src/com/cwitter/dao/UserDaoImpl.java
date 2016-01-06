package com.cwitter.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cwitter.dto.User;
import com.cwitter.hibernate.HibernateUtil;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Override
	public User saveUser(User user) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Long userId = (Long) session.save(user);
		tx.commit();
		session.flush();
		user.setUserId(userId);
		return user;
		
	}

	@Override
	public User getUser(User user) {
       SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	   Session session = sessionFactory.getCurrentSession();
	   String hql = "select u from User u where u.emailId=:email and u.password=:pwd";
	   
	   Transaction tx = session.beginTransaction();
	   //String hql = "SELECT u from User u where u.emailId = '"+user.getEmailId()+"' AND u.password='"+user.getPassword()+"'";
	   
	   Query query = session.createQuery(hql);
	   query.setParameter("email", user.getEmailId());
	   query.setParameter("pwd", user.getPassword());
	   User validUser = (User) query.uniqueResult();
	   tx.commit();
	   session.flush();
	  return validUser;
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
