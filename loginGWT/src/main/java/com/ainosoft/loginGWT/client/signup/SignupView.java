//package com.ainosoft.loginGWT.client.signup;
//
//import com.google.gwt.user.client.ui.Button;
//import com.google.gwt.user.client.ui.Composite;
//import com.google.gwt.user.client.ui.FlexTable;
//import com.google.gwt.user.client.ui.HorizontalPanel;
//import com.google.gwt.user.client.ui.Label;
//import com.google.gwt.user.client.ui.TextBox;
//import com.google.gwt.user.client.ui.VerticalPanel;
//
//public class SignupView extends Composite{
//
//
//	VerticalPanel userSignRecordPanel;
//	TextBox usernameTxtBox,passwordTxtBox;
//	
//	Button cancelBtn,SignupBtn;
//	
//	FlexTable flexTable;
//	
//	public void initialize() {
//		usernameTxtBox=new TextBox();
//		passwordTxtBox=new TextBox();
//		flexTable = new FlexTable();
//		userSignRecordPanel=new VerticalPanel();
//		
//		cancelBtn=new Button("Go Back");
//		SignupBtn=new Button("Save");
//	}
//	
//	public FlexTable createUi() {
//	
//		flexTable.setHTML(1, 0, "Username:");
//		flexTable.setWidget(1, 1, usernameTxtBox);
//		flexTable.setCellPadding(10);
//		
//		flexTable.setHTML(2, 0, "password :");
//		flexTable.setWidget(2, 1, passwordTxtBox);
//
//
//		flexTable.setWidget(3,1, cancelBtn);
//		flexTable.setWidget(3, 2, SignupBtn);
//		userSignRecordPanel.add(flexTable);
//
//		initWidget(userSignRecordPanel);
//		return flexTable;
//	}
//	
//	public void setStyle() {	
//		userSignRecordPanel.setStyleName("userSignRecordPanel");
//		flexTable.setStyleName("flexTable");
//		cancelBtn.setStyleName("CancelButton");
//		SignupBtn.setStyleName("SignUpButton");
//	}
//
//	
//	public Label errorLabel(String string) {
//		Label label=new Label(string);
//		label.setStyleName("Error");
//		return label;
//	}
//
//	public VerticalPanel getUserSignRecordPanel() {
//		return userSignRecordPanel;
//	}
//
//	public void setUserSignRecordPanel(VerticalPanel userSignRecordPanel) {
//		this.userSignRecordPanel = userSignRecordPanel;
//	}
//
//	public TextBox getUsernameTxtBox() {
//		return usernameTxtBox;
//	}
//
//	public void setUsernameTxtBox(TextBox usernameTxtBox) {
//		this.usernameTxtBox = usernameTxtBox;
//	}
//
//	public TextBox getPasswordTxtBox() {
//		return passwordTxtBox;
//	}
//
//	public void setPasswordTxtBox(TextBox passwordTxtBox) {
//		this.passwordTxtBox = passwordTxtBox;
//	}
//
//	public Button getCancelBtn() {
//		return cancelBtn;
//	}
//
//	public void setCancelBtn(Button cancelBtn) {
//		this.cancelBtn = cancelBtn;
//	}
//
//	public Button getSignupBtn() {
//		return SignupBtn;
//	}
//
//	public void setSignupBtn(Button signupBtn) {
//		SignupBtn = signupBtn;
//	}
//
//	public FlexTable getFlexTable() {
//		return flexTable;
//	}
//
//	public void setFlexTable(FlexTable flexTable) {
//		this.flexTable = flexTable;
//	}
//}
