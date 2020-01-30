package com.kryptow.springbootrest.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kryptow.springbootrest.model.PrivatePosts;
import com.kryptow.springbootrest.model.User;

@Repository
public class PostDAOImpl implements PostDAO {

private EntityManager entityManger;
	
	@Autowired
	public PostDAOImpl(EntityManager theEntityManger) {
		entityManger = theEntityManger;
	}
	
	@Override
	public PrivatePosts findById(int id) {
	Session currentSession = entityManger.unwrap(Session.class);
		
	PrivatePosts privatePosts = currentSession.get(PrivatePosts.class, id);
		return privatePosts;
	}

	@Override
	public List<PrivatePosts> findByFromID(String fromID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PrivatePosts> findAll() {
		// get the current hibernate session
				Session currentSession = entityManger.unwrap(Session.class);
				
				//create a query
				Query<PrivatePosts> theQuery = 
						currentSession.createQuery("from Posts",PrivatePosts.class);
				// execute query
				List<PrivatePosts> privatePosts = theQuery.getResultList();
				
				//return results
				return privatePosts;
	}

}
