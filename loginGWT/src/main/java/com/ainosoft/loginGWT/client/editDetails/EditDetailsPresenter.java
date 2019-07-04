package com.ainosoft.loginGWT.client.editDetails;

import com.ainosoft.loginGWT.client.GwtEventBus;
import com.ainosoft.loginGWT.client.MyDialog;
import com.ainosoft.loginGWT.client.addCellTableRecord.AddUserRecordSlim;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

@Presenter(view=EditDetailsView.class)
public class EditDetailsPresenter extends BasePresenter<EditDetailsView, GwtEventBus> {

										//Employee
	public void onGetUpdateDetailsView(AddUserRecordSlim empSelected) {		
		view.createUI(empSelected);
		eventBus.changeDetails(view);
	}
	
	@Override
	public void bind() {
		super.bind();
		view.initialize();
		view.setStyle();
	
	
	
	
	view.getCancelBtn().addClickHandler(new ClickHandler() {

		@Override
		public void onClick(ClickEvent event) {
			Window.alert("Cancel button clicked");
			//view.getMainVpanel().clear();
			eventBus.getCellTable();	
		}
	});
	
	 view.getUpdateBtn().addClickHandler(new ClickHandler() {
		@Override
		public void onClick(ClickEvent event) {
	            MyDialog myDialog = new MyDialog();

	            int left = Window.getClientWidth()/2;
	            int top = Window.getClientHeight()/2;
	            myDialog.setPopupPosition(left, top);
	            myDialog.show();	
				} 
	         });
		}
	
	}


