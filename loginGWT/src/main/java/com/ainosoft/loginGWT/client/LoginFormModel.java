package com.ainosoft.loginGWT.client;


import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class LoginFormModel {

	public void saveName(LoginSlim loginSlim) {
		LoginServiceAsync loginAsync = GWT.create(LoginService.class);
		loginAsync.add(loginSlim,new AsyncCallback<Integer>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(Integer result) {
				Window.alert("User Authentication Saved");
				
			}
		});
	}
}


