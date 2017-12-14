package com.pakur.tk.daos;

import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pakur.tk.models.WebsiteComments;

@Repository
public class CommentsDaoImpl implements CommentsDao{

	@Resource
	private SessionFactory sessionFactory;
	@Autowired
	private DataSource dataSource;
	
	@Override
	@Transactional
	public void addComments(WebsiteComments websiteComments) {
		Session session = sessionFactory.getCurrentSession();
		session.save(websiteComments);
	}

	@Override
	@Transactional
	public List<WebsiteComments> getAllComments() {
		Session session = sessionFactory.openSession();
		Criteria crt = session.createCriteria(WebsiteComments.class);
		List<WebsiteComments> uList = crt.list();
		session.clear();
		return uList;
	}

	@Override
	@Transactional
	public void deleteComments(long id) {
		Session session = sessionFactory.getCurrentSession();
		WebsiteComments websiteComments = (WebsiteComments) session.get(WebsiteComments.class, id);
		session.delete(websiteComments);
		
	}

	@Override
	@Transactional
	public void updateComments(WebsiteComments websiteComments) {
		Session session = sessionFactory.getCurrentSession();
		session.update(websiteComments);
		
	}

}
