package com.kryptow.springbootrest.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kryptow.springbootrest.model.User;
import com.kryptow.springbootrest.model.posts.PrivatePosts;

@Repository
public class UserDAOImpl implements UserDAO {

	private EntityManager entityManger;
	
	@Autowired
	public UserDAOImpl(EntityManager theEntityManger) {
		entityManger = theEntityManger;
	}
	
	@Override
	public List<User> findAll() {
		// get the current hibernate session
		Session currentSession = entityManger.unwrap(Session.class);
		
		//create a query
		Query<User> theQuery = 
				currentSession.createQuery("from User",User.class);
		// execute query
		List<User> users = (List<User>) theQuery.getResultList();
		for(User p : users) {
			System.out.println(p);
		}
		//return results
		return users;
	}
	@Transactional
	@Override
	public User findById(int theId) {
		Session currentSession = entityManger.unwrap(Session.class);
		
		User theUser = currentSession.get(User.class, theId);
		return theUser;
	}
	@Transactional
	@Override
	public void save(User theUser) {
		Session currentSession = entityManger.unwrap(Session.class);
		currentSession.save(theUser);
	}
	@Transactional
	@Override
	public void deleteById(int theId) {
		Session currentSession = entityManger.unwrap(Session.class);
		Query<User> theQuery = 
				currentSession.createQuery("delete from Users where id=:userId",User.class);
		theQuery.setParameter("userId", theId);
		theQuery.executeUpdate(); 
	}

}
