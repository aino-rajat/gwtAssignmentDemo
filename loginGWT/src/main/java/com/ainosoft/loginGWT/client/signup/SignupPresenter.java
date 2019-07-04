//package com.ainosoft.loginGWT.client.signup;
//
//import com.ainosoft.loginGWT.client.GwtEventBus;
//import com.google.gwt.event.dom.client.BlurEvent;
//import com.google.gwt.event.dom.client.BlurHandler;
//import com.google.gwt.event.dom.client.ClickEvent;
//import com.google.gwt.event.dom.client.ClickHandler;
//import com.google.gwt.user.client.Window;
//import com.mvp4g.client.annotation.Presenter;
//import com.mvp4g.client.presenter.BasePresenter;
//
//@Presenter(view=SignupView.class)
//public class SignupPresenter extends BasePresenter<SignupView, GwtEventBus> {
//
////	public void onGetSignUP() {
////	Window.alert("In Sign UP prsenter");
////	eventBus.createUp(view);
////	}
//	
//	@Override
//	public void bind() {
//		super.bind();
//		view.initialize();
//		view.createUi();
//		view.setStyle();
//		
//		view.usernameTxtBox.addBlurHandler(new BlurHandler() {
//			@Override
//			public void onBlur(BlurEvent event) {
//				if (view.usernameTxtBox.getText().equals("")) {
//					view.flexTable.setWidget(1, 3,view.errorLabel("Usename Name should not be Empty"));
//				}else {
//					view.usernameTxtBox.getText().equals("");
//					view.flexTable.setWidget(1, 3,view.errorLabel(""));
//				}
//			}
//		}); 
//		
//		
//		view.passwordTxtBox.addBlurHandler(new BlurHandler() {
//			
//			@Override
//			public void onBlur(BlurEvent event) {
//				if(view.passwordTxtBox.getText().equals("")) {
//					view.flexTable.setWidget(2,3,view.errorLabel("Surname cannot be empty!"));
//				}
//				else {
//					view.passwordTxtBox.getText().equals("");
//					view.flexTable.setWidget(2, 3,view.errorLabel(""));
//				}
//			}
//		});
//		
//		view.SignupBtn.addClickHandler(new ClickHandler() {
//			
//			@Override
//			public void onClick(ClickEvent event) {
//				//eventBus.getAddressView();
//				
//			}
//		});
//	}
//}
