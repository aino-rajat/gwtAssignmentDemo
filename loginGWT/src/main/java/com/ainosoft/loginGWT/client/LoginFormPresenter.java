package com.ainosoft.loginGWT.client;

import com.ainosoft.loginGWT.client.addCellTableRecord.AddCellTableRecordView;
import com.ainosoft.loginGWT.client.cellTable.CellTableDemoView;
import com.ainosoft.loginGWT.client.dbCellTable.DBCelltableView;
import com.ainosoft.loginGWT.client.editDetails.EditDetailsView;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

@Presenter(view=LoginFormView.class)
public class LoginFormPresenter extends BasePresenter<LoginFormView, GwtEventBus> {

	public void onGetAddressView() {
		view.createUi();
	}

	
	
//	public void onCreateUp(SignupView view) {
//		this.view.getMainVpanel().clear();
//		this.view.getMainVpanel().add(view);
//	}
	
public void onDisplayCelltable(DBCelltableView view) {
	this.view.getMainVpanel().clear();
	this.view.getMainVpanel().add(view);
}
	
	public void onAddrecordView(AddCellTableRecordView view) {
		this.view.getMainVpanel().clear();
		this.view.getMainVpanel().add(view);
	}
	
	public void onChangeDetails(EditDetailsView view) {
		this.view.getMainVpanel().clear();
		this.view.getMainVpanel().add(view);
	}

	public void onAddUserDetailsView(LoginDisplayFormView view) {
		this.view.getMainVpanel().clear();
		this.view.getMainVpanel().add(view);
	}
	public void onCreateCellTable(CellTableDemoView view) {
		this.view.getMainVpanel().clear();
		this.view.getMainVpanel().add(view.getCellTableMainPanel());
	}

	public void onViewUserDetails(LoginDisplayFormView view) {
		this.view.getMainVpanel().clear();
		this.view.getMainVpanel().add(view);	
	}

	public void onNewTable(CellTableDemoView view) {		  
		//		  this.view.getMainVpanel().clear();
		this.view.getMainVpanel().add(view);

	}




	@Override
	public void bind() {
		super.bind();	
		view.initialize();
		view.addstyle();

		view.getUserTbx().addBlurHandler(new BlurHandler() {
			@Override
			public void onBlur(BlurEvent event) {
				String username=view.getUserTbx().getText();
				if(username.length()==0)
				{
					view.getErrorLbl().setVisible(true);
				}
				else {
					view.getErrorLbl().setVisible(false);
				}	
			}
		});


		view.getPasswordBox().addBlurHandler(new BlurHandler() {
			@Override
			public void onBlur(BlurEvent event) {
				String password=view.getPasswordBox().getText();
				if(password.isEmpty()) {
					view.getErrorPasswordLbl().setVisible(true);
				}
				else {
					view.getErrorPasswordLbl().setVisible(false);
				}
			}
		});

		view.getLoginBtn().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				String username=view.getUserTbx().getText();
				String password=view.getPasswordBox().getText();

				if(username.length()==0 || password.length()==0) {
					view.getErrorLbl().setVisible(true);
					view.getErrorPasswordLbl().setVisible(true);
				}

				else {
				LoginFormModel model=new LoginFormModel();
				LoginSlim loginSlim=new LoginSlim(); 
			
				loginSlim.setUsername(view.userTbx.getText());
				loginSlim.setPassword(view.passwordBox.getText());
				model.saveName(loginSlim);
				eventBus.getCellTable();
				}
			}		
		});	
		
		view.getSignUpBtn().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
			
				//eventBus.getSignUP();
				
			}
		});
	}


}
