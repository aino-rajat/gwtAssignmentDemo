package com.ainosoft.loginGWT.client.addCellTableRecord;

import com.ainosoft.loginGWT.client.GwtEventBus;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

@Presenter(view=AddCellTableRecordView.class)
public class AddCellTableRecordPresenter extends BasePresenter<AddCellTableRecordView,GwtEventBus> {

	public void onGetRecord() {
		view.createUi();
		eventBus.addrecordView(view);
	}
	
	@Override
	public void bind() {
		super.bind();	
		view.initialize();
		view.setStyle();
		
		view.name.addBlurHandler(new BlurHandler() {
			@Override
			public void onBlur(BlurEvent event) {
				if (view.name.getText().equals("")) {
					view.flexTable.setWidget(1, 2,view.errorLabel("Name should not be Empty"));
				}else {
					view.name.getText().equals("");
					view.flexTable.setWidget(1, 2,view.errorLabel(""));
				}
			}
		}); 
		
		
		view.surname.addBlurHandler(new BlurHandler() {
			
			@Override
			public void onBlur(BlurEvent event) {
				if(view.surname.getText().equals("")) {
					view.flexTable.setWidget(2,2,view.errorLabel("Surname cannot be empty!"));
				}
				else {
					view.surname.getText().equals("");
					view.flexTable.setWidget(2, 2,view.errorLabel(""));
				}
			}
		});
		
		
		view.city.addBlurHandler(new BlurHandler() {
			
			@Override
			public void onBlur(BlurEvent event) {
				if(view.city.getText().equals("")) {
					view.flexTable.setWidget(3,2,view.errorLabel("City cannot be empty"));
				}
				else {
					view.city.getText().equals("");
					view.flexTable.setWidget(3, 2, view.errorLabel(""));
				}
			}
		});
		
		view.country.addBlurHandler(new BlurHandler() {
			
			@Override
			public void onBlur(BlurEvent event) {
				if(view.country.getText().equals("")) {
					view.flexTable.setWidget(4, 2,view.errorLabel("Country Feild Cannot be Empty!"));
				}
				else {
					view.getCountry().getText().equals("");
					view.flexTable.setWidget(4,2,view.errorLabel(""));
				}
			}
		});
		
				
		
		view.getSave().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
			
				AddUserRecordModel model=new AddUserRecordModel();
				AddUserRecordSlim userRecordSlim=new AddUserRecordSlim(); 
			
				userRecordSlim.setName(view.name.getText());
				userRecordSlim.setSurname(view.surname.getText());
				userRecordSlim.setCity(view.getCity().getText());
				userRecordSlim.setCountry(view.getCountry().getText());
				model.saveRecord(userRecordSlim);
				eventBus.getCellTable();
				}
		});	
		
		view.getCancelBtn().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Window.alert("Cancel Button clicked");
				view.getFlexTable().clear();
				eventBus.getCellTable();
				
			}
		});
	}
}
