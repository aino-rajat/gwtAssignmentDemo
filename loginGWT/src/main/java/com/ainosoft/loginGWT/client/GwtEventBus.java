package com.ainosoft.loginGWT.client;



import com.ainosoft.loginGWT.client.addCellTableRecord.AddCellTableRecordPresenter;
import com.ainosoft.loginGWT.client.addCellTableRecord.AddCellTableRecordView;
import com.ainosoft.loginGWT.client.addCellTableRecord.AddUserRecordSlim;
import com.ainosoft.loginGWT.client.cellTable.CellTableDemoView;
import com.ainosoft.loginGWT.client.cellTable.CellTablePresenter;
import com.ainosoft.loginGWT.client.dbCellTable.DBCellTablePresenter;
import com.ainosoft.loginGWT.client.dbCellTable.DBCelltableView;
import com.ainosoft.loginGWT.client.editDetails.EditDetailsPresenter;
import com.ainosoft.loginGWT.client.editDetails.EditDetailsView;
import com.ainosoft.loginGWT.client.eduactionDetails.EducationDetailsPresenter;
import com.ainosoft.loginGWT.client.eduactionDetails.EducationDetailsView;
import com.mvp4g.client.annotation.Event;
import com.mvp4g.client.annotation.Events;
import com.mvp4g.client.annotation.Start;
import com.mvp4g.client.event.EventBusWithLookup;

@Events(startPresenter=LoginFormPresenter.class)
public interface GwtEventBus extends EventBusWithLookup{

	@Start
	@Event(handlers=LoginFormPresenter.class)
	public void getAddressView();

//	@Event(handlers=LoginDisplayFormPresenter.class)
//	public void userDetailView();
	
	
//	@Event(handlers=LoginFormPresenter.class)
//	public void addUserDetailsView(LoginDisplayFormView view);

	@Event(handlers=EducationDetailsPresenter.class)
	public void getEducationDetailsView();
	
	@Event(handlers=LoginDisplayFormPresenter.class)
	public void addEducationDetails(EducationDetailsView view);
	
	@Event(handlers=CellTablePresenter.class)
	public void getCellTable();
	
	@Event(handlers=LoginFormPresenter.class)
	public void createCellTable(CellTableDemoView view);

	@Event(handlers=LoginDisplayFormPresenter.class)
	public void getDisplayForm(AddUserRecordSlim empSelected);
	
	@Event(handlers=LoginFormPresenter.class)
	public void viewUserDetails(LoginDisplayFormView view);

	@Event(handlers=EditDetailsPresenter.class)
	public void getUpdateDetailsView(AddUserRecordSlim select);

	@Event(handlers=LoginFormPresenter.class)
	public void changeDetails(EditDetailsView view);
	
	@Event(handlers=CellTablePresenter.class)
	public void goBackToCellTable();
	
	@Event(handlers=LoginFormPresenter.class)
	public void newTable(CellTableDemoView view);

	@Event(handlers=AddCellTableRecordPresenter.class)
	public void getRecord();

	@Event(handlers=LoginFormPresenter.class)
	public void addrecordView(AddCellTableRecordView  view);

	@Event(handlers=DBCellTablePresenter.class)
	public void readAllCellTable();

	@Event(handlers=LoginFormPresenter.class)
	public void displayCelltable(DBCelltableView view);

//	//SOme Functionalities nedd to be added 
//	@Event(handlers=SignupPresenter.class)
//	public void getSignUP();
//
//	@Event(handlers=LoginFormPresenter.class)
//	public void createUp(SignupView view);
	

	
	

	



	

//	@Event(handlers=CellTablePresenter.class)
//	public void getUpdatedCellTable(AddUserRecordSlim userRecordSlim);
	
	
	
	

	
	
	

}


