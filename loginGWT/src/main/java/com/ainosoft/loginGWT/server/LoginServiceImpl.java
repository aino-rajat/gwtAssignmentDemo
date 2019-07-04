package com.ainosoft.loginGWT.server;


import java.util.ArrayList;

import com.ainosoft.loginGWT.client.LoginService;
import com.ainosoft.loginGWT.client.LoginSlim;
import com.ainosoft.loginGWT.client.addCellTableRecord.AddUserRecordSlim;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class LoginServiceImpl extends RemoteServiceServlet implements
    LoginService {

  public String greetServer(String input) throws IllegalArgumentException {
	  return "Hello";
  
    // Verify that the input is valid.
  }
  
  public int add(LoginSlim loginslim) {
	  
		hbLoginHelper hb=new hbLoginHelper();
		int id=hb.addLogin(loginslim);
		return id;
	}
  
  public int addUserRecord(AddUserRecordSlim addUserRecordSlim) {
	  hbLoginHelper hb=new hbLoginHelper();
		int id=hb.addUserRecord(addUserRecordSlim);
		return id;	
  }
  
  
  public ArrayList<AddUserRecordSlim> readAll() {
		hbLoginHelper hb=new hbLoginHelper();
		ArrayList<AddUserRecordSlim> addUserRecordSlim=hb.readAll();
		for(AddUserRecordSlim add:addUserRecordSlim) {
		System.out.println(add);
		
		}
		return addUserRecordSlim;
	}
  
}
