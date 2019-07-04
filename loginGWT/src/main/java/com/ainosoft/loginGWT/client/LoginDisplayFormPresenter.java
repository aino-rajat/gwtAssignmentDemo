package com.ainosoft.loginGWT.client;

import com.ainosoft.loginGWT.client.addCellTableRecord.AddUserRecordSlim;
import com.ainosoft.loginGWT.client.eduactionDetails.EducationDetailsView;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

@Presenter(view=LoginDisplayFormView.class)
public class LoginDisplayFormPresenter extends BasePresenter<LoginDisplayFormView,GwtEventBus>{
	//Employee select;

	AddUserRecordSlim select;

	public void onGetDisplayForm(AddUserRecordSlim empSelected) {
		select= empSelected;
		Window.alert("Login display presenter");
		view.getMainVpanel().clear();
		view.createUI(empSelected);
		eventBus.viewUserDetails(view);
	}



	public void onAddEducationDetails(EducationDetailsView view) {
		this.view.getMainVpanel().clear();
		this.view.getMainVpanel().add(view);
	}

	@Override
	public void bind() {
		// TODO Auto-generated method stub
		super.bind();
		view.initialize();
		view.setStyle();


		view.getCancelBtn().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				//view.getMainVpanel().clear();
				eventBus.getCellTable();

			}	
		});

		view.getUpdateBtn().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				Window.alert("Update Button Clicked");
				eventBus.getUpdateDetailsView(select);


			}
		});


		view.getEducationBtn().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {

				com.google.gwt.user.client.Window.alert("In Click Handler Function");

				Window.alert("In Click Handler Function");
				//view.mainVpanel.clear();
				eventBus.getEducationDetailsView();


			}
		});




	}

}
