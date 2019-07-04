package com.ainosoft.loginGWT.client;


import java.util.ArrayList;

import com.ainosoft.loginGWT.client.addCellTableRecord.AddUserRecordSlim;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface LoginService extends RemoteService {
  String greetServer(String name) throws IllegalArgumentException;
  
  public int add(LoginSlim loginslim);
  
  public int addUserRecord(AddUserRecordSlim addUserRecordSlim);
  
   public ArrayList<AddUserRecordSlim> readAll();
  
}
