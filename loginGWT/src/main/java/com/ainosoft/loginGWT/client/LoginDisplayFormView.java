package com.ainosoft.loginGWT.client;


import com.ainosoft.loginGWT.client.addCellTableRecord.AddUserRecordSlim;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class LoginDisplayFormView  extends Composite{

	private VerticalPanel mainVpanel;
	//private HorizontalPanel nameHpanel,addressHpanel,emailHpanel,mobileHpanel,bdateHpanel,genderHpanel,countryHpanel,cityHpanel;
	//private Label nameLbl,emailLbl,addressLbl,mobileLbl,genderLbl,bdateLbl,cityLbl,countryLbl;
	//private Label errorNameLbl,errorEmailLbl,errorAddressLbl,errorMobileLbl,errorCountryLbl;
	
	private HorizontalPanel Hpanel;
	private HorizontalPanel nameHpanel,surnameHpanel,cityHpanel,countryHpanel;
	private Label nameLbl,surnameLbl,cityLbl,countryLbl;
	private TextBox nameTxtBox,surnameTxtBox,cityTxtBox,countryTxtBox;
	
	private Button cancelBtn,updateBtn,educationBtn;



	public void initialize() {
		mainVpanel=new VerticalPanel();
		Hpanel=new HorizontalPanel();

		nameHpanel=new HorizontalPanel();
		surnameHpanel=new HorizontalPanel();
		cityHpanel=new HorizontalPanel();
		countryHpanel=new HorizontalPanel();
		
		nameTxtBox=new TextBox();
		surnameTxtBox=new TextBox();
		cityTxtBox=new TextBox();
		countryTxtBox=new TextBox();
		
		nameLbl=new Label("Name:");
		surnameLbl=new Label("Surname:");
		cityLbl=new Label("City:");
		countryLbl=new Label("Country:");
		
		cancelBtn=new Button("Cancel1");
		updateBtn=new Button("Update");
		
		educationBtn=new Button("Education Details");
		initWidget(mainVpanel);
		

		
	}
//	public void createUi() {
//
//		nameHpanel.add(nameLbl);
//		nameHpanel.add(nameTxtBox);
//		surnameHpanel.add(surnameLbl);
//		surnameHpanel.add(surnameTxtBox);
//		cityHpanel.add(cityLbl);
//		cityHpanel.add(cityTxtBox);
//		countryHpanel.add(countryLbl);
//		countryHpanel.add(countryTxtBox);
//		
//		mainVpanel.add(nameHpanel);
//		mainVpanel.add(surnameHpanel);
//		mainVpanel.add(cityHpanel);
//		mainVpanel.add(countryHpanel);
//	
//		mainVpanel.add(educationBtn);
//		
//
//	}
						//Employee
	public void createUI(AddUserRecordSlim selected) {
        mainVpanel.add(createField("Name:", selected.getName()));
        mainVpanel.add(createField("Surname:", selected.getSurname()));
        mainVpanel.add(createField("City:", selected.getCity()));
        mainVpanel.add(createField("Country:", selected.getCountry()));
        mainVpanel.add(cancelBtn);
        mainVpanel.add(updateBtn);
        mainVpanel.add(educationBtn);
    
    }
    
    public FlowPanel createField(String fieldname,String fieldValue) {
        FlowPanel flowPanel=new FlowPanel();
        flowPanel.setStylePrimaryName("flowpanel");
        Label field=new Label(fieldname);
        field.setStylePrimaryName("field");
        Label value=new Label(fieldValue);
        value.setStylePrimaryName("value");
        flowPanel.add(field);
        flowPanel.add(value);
        return flowPanel;
    }
	
	public void setStyle() {
		mainVpanel.setStyleName("MainPanelUserdetail");
		nameHpanel.setStyleName("name-label");
		cancelBtn.setStyleName("Cancel");
		updateBtn.setStyleName("UpdateDetails");
		educationBtn.setStyleName("EducationDetails");

	}
	
	
	public Button getUpdateBtn() {
		return updateBtn;
	}

	public void setUpdateBtn(Button updateBtn) {
		this.updateBtn = updateBtn;
	}

	public Button getCancelBtn() {
		return cancelBtn;
	}

	public void setCancelBtn(Button cancelBtn) {
		this.cancelBtn = cancelBtn;
	}

	public Button getEducationBtn() {
		return educationBtn;
	}
	public void setEducationBtn(Button educationBtn) {
		this.educationBtn = educationBtn;
	}
	
	public VerticalPanel getMainVpanel() {
		return mainVpanel;
	}
	public void setMainVpanel(VerticalPanel mainVpanel) {
		this.mainVpanel = mainVpanel;
	}	
}
