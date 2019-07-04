package com.ainosoft.loginGWT.server;

import org.hibernate.Session;
import org.hibernate.Transaction;



public class HbLoginDao {

	public Session getSession() {
		return HibernateUtil.getSessionFactory().openSession();

	}
	
	public Integer add(Login loginUser) {
		Session session=getSession();
		Transaction transaction=session.beginTransaction();
		Integer id = null;
		try {

			id = (Integer) session.save(loginUser);
			transaction.commit();

		}catch (Exception e) {

		} 
		finally {
			session.close();
		}
		return id;
	}

}
