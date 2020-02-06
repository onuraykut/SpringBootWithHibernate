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
public class PostDAOImpl implements PostDAO {

private EntityManager entityManger;
	
	@Autowired
	public PostDAOImpl(EntityManager theEntityManger) {
		entityManger = theEntityManger;
	}

	@Transactional
	@Override
	public List<PrivatePosts> findAll() {
		// get the current hibernate session
				Session currentSession = entityManger.unwrap(Session.class);
				
			/*	Query q = currentSession.createQuery("from PrivatePosts");
				List<Object[]> post = (List<Object[]>) q.getResultList();
				
				for(Object[] posts : post) {
					System.out.println(posts[0]);
				} */
				
			/*	Query q = currentSession.createQuery("select fromID from PrivatePosts");
				List<User> post = (List<User>) q.list();
				
				for(Object posts : post) {
					System.out.println((User)posts);
				} */
				
				
				//create a query
				Query<PrivatePosts> theQuery = 
						currentSession.createQuery("from PrivatePosts",PrivatePosts.class);
				// execute query
				List<PrivatePosts> privatePosts = (List<PrivatePosts>) theQuery.getResultList(); 
				
				System.out.println(privatePosts);
				//return results
				return privatePosts;
	}
	@Transactional
	@Override
	public void save(PrivatePosts privatePosts) {
		Session currentSession = entityManger.unwrap(Session.class);
		currentSession.save(privatePosts);
	}
	@Transactional
	@Override
	public void delete(int id) {
		Session currentSession = entityManger.unwrap(Session.class);
		
		Query<PrivatePosts> theQuery = 
				currentSession.createQuery("delete Posts where id=:theID",PrivatePosts.class);
		theQuery.setParameter("theID", id);
		theQuery.executeUpdate();
	}
	
	@Transactional
	@Override
	public PrivatePosts findById(int id) {
	Session currentSession = entityManger.unwrap(Session.class);
		
	PrivatePosts privatePosts = currentSession.get(PrivatePosts.class, id);
	//System.out.println(privatePosts.getFromID());
		return privatePosts;
	}
	
	@Transactional
	@Override
	public List<PrivatePosts> findByFromID(String fromID) {
		Session currentSession = entityManger.unwrap(Session.class);
		Query<PrivatePosts> theQuery = 
				currentSession.createQuery("from PrivatePosts where fromID=:theFromid",PrivatePosts.class);
		theQuery.setParameter("theFromid", fromID);
		// execute query
		List<PrivatePosts> privatePosts = (List<PrivatePosts>) theQuery.getResultList(); 
		return privatePosts;
	}
	@Override
	public List<PrivatePosts> findByToID(String toID) {
		Session currentSession = entityManger.unwrap(Session.class);
		Query<PrivatePosts> theQuery = 
				currentSession.createQuery("from PrivatePosts where toID=:theToid",PrivatePosts.class);
		theQuery.setParameter("theToid", toID);
		// execute query
		List<PrivatePosts> privatePosts = (List<PrivatePosts>) theQuery.getResultList(); 
		return privatePosts;
	}

}
