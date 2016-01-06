package com.cwitter.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.cwitter.dto.Tweet;
import com.cwitter.dto.User;
import com.cwitter.hibernate.HibernateUtil;

public class TweetDaoImpl implements TweetDao{

	@Override
	public Tweet saveTweet(Tweet tweet) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.persist(tweet);
		tx.commit();
		return tweet;	
		
	}

	@Override
	public Tweet getTweet(Tweet tweet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tweet updateTweet(Tweet tweet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteTweet(Tweet tweet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tweet> getAllTweets() {
		   SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		   Session session = sessionFactory.getCurrentSession();
		   Transaction tx = session.beginTransaction();
		   String hql = "from Tweet";
		   Query query = session.createQuery(hql);
		   List<Tweet> tweetList = query.list();
		   tx.commit();
		   if(tweetList.size()>0)
		   {
			return tweetList;
		   }else{
			   return null;
		   }
	}

	@Override
	public List<Tweet> getAllTweetsByUserId(Long userId) {
		
		   SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		   Session session = sessionFactory.getCurrentSession();
		   Transaction tx = session.beginTransaction();
		   String hql = "SELECT t from Tweet t where t.tweetCreatedBy = '"+userId+"'";
		   Query query = session.createQuery(hql);
		   List<Tweet> tweetList = query.list();
		   tx.commit();
		   if(tweetList.size()>0)
		   {
			return tweetList;
		   }else{
			   return null;
		   }
		
	   }

}
