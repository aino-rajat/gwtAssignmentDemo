package com.ainosoft.loginGWT.server;


import java.util.ArrayList;

import com.ainosoft.loginGWT.client.LoginSlim;
import com.ainosoft.loginGWT.client.addCellTableRecord.AddUserRecordSlim;

public class hbLoginHelper {

	public int addLogin(LoginSlim loginslim) {
		hbLoginHelper helper=new hbLoginHelper();
		HbLoginDao hb=new HbLoginDao();
		Login loginUser=helper.convertToPojo(loginslim);
		System.out.println(loginUser.getUsername());
		int id=hb.add(loginUser);
		return id;
	}

	private Login convertToPojo(LoginSlim loginslim) {
		Login login=new Login();
		login.setUsername(loginslim.getUsername());
		login.setPassword(loginslim.getPassword());
		return login;
	}

	
	public int addUserRecord(AddUserRecordSlim addUserRecordSlim) {
		hbLoginHelper helper=new hbLoginHelper();
		HbUserRecordDao hbRecordDao=new HbUserRecordDao();
		AddUserRecordPojo addUser=helper.convertToPojoRecord(addUserRecordSlim);
		int id=hbRecordDao.saveRecord(addUser);
		return id;
	}

	private AddUserRecordPojo convertToPojoRecord(AddUserRecordSlim addUserRecordSlim) {
		AddUserRecordPojo adduserRecord=new AddUserRecordPojo();
		adduserRecord.setName(addUserRecordSlim.getName());
		adduserRecord.setSurname(addUserRecordSlim.getSurname());
		adduserRecord.setCity(addUserRecordSlim.getCity());
		adduserRecord.setCountry(addUserRecordSlim.getCountry());
		return adduserRecord;
		
	}

	public ArrayList<AddUserRecordSlim> readAll() {
		HbUserRecordDao hb=new HbUserRecordDao();
		
		ArrayList<AddUserRecordSlim> addressRecordslim=new ArrayList<AddUserRecordSlim>();
		ArrayList<AddUserRecordPojo> al=hb.readAll();
		
		for(AddUserRecordPojo a:al) {
		AddUserRecordSlim address=convertToSlim(a);	
		addressRecordslim.add(address);
		}
		
		return addressRecordslim;
	}

	private AddUserRecordSlim convertToSlim(AddUserRecordPojo addUserRecordpojoObject) {
		
		AddUserRecordSlim addUserSlim=new AddUserRecordSlim();
		
		addUserSlim.setName(addUserRecordpojoObject.getName());
		addUserSlim.setSurname(addUserRecordpojoObject.getSurname());
		addUserSlim.setCity(addUserRecordpojoObject.getCity());
		addUserSlim.setCountry(addUserRecordpojoObject.getCountry());
	
		
		return addUserSlim;
	}
	
	
	

}
