package com.ainosoft.loginGWT.server;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;



public class HbUserRecordDao {

	public Session getSession() {
		return HibernateUtil.getSessionFactory().openSession();

	}
	
	public int saveRecord(AddUserRecordPojo addUserRecord) {
		Session session=getSession();
		Transaction transaction=session.beginTransaction();
		Integer id = null;
		try {

			id = (Integer) session.save(addUserRecord);
			transaction.commit();

		}catch (Exception e) {

		} 
		finally {
			session.close();
		}
		return id;
		
	}

	public ArrayList<AddUserRecordPojo> readAll() {
		ArrayList<AddUserRecordPojo> al=null;
		AddUserRecordPojo addUserRecordObject=null;
		Session session=getSession();
		Transaction transaction=session.beginTransaction();
		try {
			al= (ArrayList<AddUserRecordPojo>) session.createQuery("from AddUserRecordPojo").list();

		}catch (Exception e) {
		} 
		
		return al;
	
	}

}
