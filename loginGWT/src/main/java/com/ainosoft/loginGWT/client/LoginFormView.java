package com.ainosoft.loginGWT.client;


import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class LoginFormView extends Composite {
	
	public VerticalPanel mainVpanel;
	private HorizontalPanel userHpanel,passordHpanel;
	
	private Label userNameLbl,passwordLbl,errorUserNameLbl,errorPasswordLbl;
	

	 public TextBox userTbx;
	private Button LoginBtn,SignUpBtn;
	PasswordTextBox passwordBox;
	
	public void initialize() {
		mainVpanel=new VerticalPanel();
		userHpanel=new HorizontalPanel();
		passordHpanel=new HorizontalPanel();
		userNameLbl=new Label("Username");
		passwordLbl=new Label("Password");
		userTbx=new TextBox();
		passwordBox=new PasswordTextBox();
		LoginBtn=new Button("SignIN");
		SignUpBtn=new Button("SignUP");
		errorUserNameLbl=new Label("User Name not be empty");
		errorPasswordLbl=new Label("Password Cannot be empty");
		initWidget(mainVpanel);
	}

	
	public void createUi() {
		addstyle();
		userHpanel.add(userNameLbl);
		userHpanel.add(userTbx);
		mainVpanel.add(errorUserNameLbl);
		errorUserNameLbl.setVisible(false);
	
		
		passordHpanel.add(passwordLbl);
		passordHpanel.add(passwordBox);
		mainVpanel.add(errorPasswordLbl);
		errorPasswordLbl.setVisible(false);
		
		
		mainVpanel.add(userHpanel);
		mainVpanel.add(passordHpanel);
		mainVpanel.add(LoginBtn);
		mainVpanel.add(SignUpBtn);
		
		
	}
	public void addstyle()	{
		mainVpanel.setStylePrimaryName("mainpanel");
		errorUserNameLbl.setStyleName("errorLbl1");
		errorPasswordLbl.setStyleName("errorPasswordLbl");
		LoginBtn.setStyleName("LoginUser");
		SignUpBtn.setStyleName("SignUpButton");
		
	}

	
	
	public Button getSignUpBtn() {
		return SignUpBtn;
	}


	public void setSignUpBtn(Button signUpBtn) {
		SignUpBtn = signUpBtn;
	}


	///Getters and Setters
	public Label getUserNameLbl() {
		return userNameLbl;
	}

	public void setUserNameLbl(Label userNameLbl) {
		this.userNameLbl = userNameLbl;
	}
	
	public TextBox getUserTbx() {
		return userTbx;
	}

	public void setUserTbx(TextBox userTbx) {
		this.userTbx = userTbx;
	}	

	public HorizontalPanel getUserHpanel() {
		return userHpanel;
	}

	public void setUserHpanel(HorizontalPanel userHpanel) {
		this.userHpanel = userHpanel;
	}

	
	public Button getLoginBtn() {
		return LoginBtn;
	}

	public void setLoginBtn(Button loginBtn) {
		LoginBtn = loginBtn;
	}

	public PasswordTextBox getPasswordBox() {
		return passwordBox;
	}

	public void setPasswordBox(PasswordTextBox passwordBox) {
		this.passwordBox = passwordBox;
	}

	public VerticalPanel getMainVpanel() {
		return mainVpanel;
	}

	public void setMainVpanel(VerticalPanel mainVpanel) {
		this.mainVpanel = mainVpanel;
	}

	public Label getErrorLbl() {
		return errorUserNameLbl;
	}

	public void setErrorLbl(Label errorLbl) {
		this.errorUserNameLbl = errorLbl;
	}
	
	public Label getErrorPasswordLbl() {
		return errorPasswordLbl;
	}

	public void setErrorPasswordLbl(Label errorPasswordLbl) {
		this.errorPasswordLbl = errorPasswordLbl;
	}

}
