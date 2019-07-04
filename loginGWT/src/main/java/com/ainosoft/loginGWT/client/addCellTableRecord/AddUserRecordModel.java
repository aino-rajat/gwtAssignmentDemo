package com.ainosoft.loginGWT.client.addCellTableRecord;

import com.ainosoft.loginGWT.client.LoginService;
import com.ainosoft.loginGWT.client.LoginServiceAsync;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class AddUserRecordModel {

	public void saveRecord(AddUserRecordSlim userRecordSlim) {
	
		LoginServiceAsync loginAsync = GWT.create(LoginService.class);
		loginAsync.addUserRecord(userRecordSlim,new AsyncCallback<Integer>(){

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(Integer result) {
				Window.alert("User Record Saved in DB");
		
			}
	
		});
	}
}


