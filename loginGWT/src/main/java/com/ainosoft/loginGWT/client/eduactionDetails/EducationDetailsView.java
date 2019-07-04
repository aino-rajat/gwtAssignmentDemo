package com.ainosoft.loginGWT.client.eduactionDetails;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class EducationDetailsView extends Composite {

	private VerticalPanel mainVpanel;
	private HorizontalPanel englishHpanel,mathHpanel,scienceHpanel,percentageHpanel;
	private Label englishNameLbl,mathLbl,scienceLbl,percentageLbl;
	private Label errorEngLbl,errorMathLbl,errorScienceLbl,errorPercentageLbl;
	private TextBox englishTbx,mathTbx,scienceTbx,percentageTbx;
	private Button saveBtn;

	
	public void initialize() {
	
		mainVpanel=new VerticalPanel();
		englishHpanel=new HorizontalPanel();
		mathHpanel=new HorizontalPanel();
		scienceHpanel=new HorizontalPanel();
		percentageHpanel=new HorizontalPanel();
		englishNameLbl=new Label("English");
		mathLbl=new Label("Math: ");
		scienceLbl=new Label("Science: ");
		percentageLbl=new Label("Percentage:");
		englishTbx=new TextBox();
		scienceTbx=new TextBox();
		mathTbx=new TextBox();
		percentageTbx=new TextBox();
		
		errorEngLbl=new Label("Enter Valid marks");
		errorEngLbl.setVisible(false);
		
		errorMathLbl=new Label("Enter Valid marks");
		errorMathLbl.setVisible(false);
		
		errorScienceLbl=new Label("Enter Valid marks");
		errorScienceLbl.setVisible(false);
		
		errorPercentageLbl=new Label("Enter Valid Percentage");
		errorPercentageLbl.setVisible(false);
		
		saveBtn=new Button("Save Details");
		
		initWidget(mainVpanel);
	}
	


	public void createUi() {

		englishHpanel.add(englishNameLbl);
		englishHpanel.add(englishTbx);
		englishHpanel.add(errorEngLbl);
		
		mathHpanel.add(mathLbl);
		mathHpanel.add(mathTbx);
		mathHpanel.add(errorMathLbl);
		
		scienceHpanel.add(scienceLbl);
		scienceHpanel.add(scienceTbx);
		scienceHpanel.add(errorScienceLbl);
		
		percentageHpanel.add(percentageLbl);
		percentageHpanel.add(percentageTbx);
		percentageHpanel.add(errorPercentageLbl);
		
		mainVpanel.add(englishHpanel);
		mainVpanel.add(mathHpanel);
		mainVpanel.add(scienceHpanel);
		mainVpanel.add(percentageHpanel);
		mainVpanel.add(saveBtn);
	
		
	}
	
	
	
	
	public void setStyle() {
		mainVpanel.setStyleName("mainVpanel");
		saveBtn.setStyleName("SaveEduationDetailsBtn");
		
	
	}
	
	public Label getErrorEngLbl() {
		return errorEngLbl;
	}



	public void setErrorEngLbl(Label errorEngLbl) {
		this.errorEngLbl = errorEngLbl;
	}



	public Label getErrorMathLbl() {
		return errorMathLbl;
	}



	public void setErrorMathLbl(Label errorMathLbl) {
		this.errorMathLbl = errorMathLbl;
	}



	public Label getErrorScienceLbl() {
		return errorScienceLbl;
	}



	public void setErrorScienceLbl(Label errorScienceLbl) {
		this.errorScienceLbl = errorScienceLbl;
	}



	public Label getErrorPercentageLbl() {
		return errorPercentageLbl;
	}



	public void setErrorPercentageLbl(Label errorPercentageLbl) {
		this.errorPercentageLbl = errorPercentageLbl;
	}



	public TextBox getEnglishTbx() {
		return englishTbx;
	}



	public void setEnglishTbx(TextBox englishTbx) {
		this.englishTbx = englishTbx;
	}



	public TextBox getMathTbx() {
		return mathTbx;
	}



	public void setMathTbx(TextBox mathTbx) {
		this.mathTbx = mathTbx;
	}



	public TextBox getScienceTbx() {
		return scienceTbx;
	}



	public void setScienceTbx(TextBox scienceTbx) {
		this.scienceTbx = scienceTbx;
	}



	public TextBox getPercentageTbx() {
		return percentageTbx;
	}



	public void setPercentageTbx(TextBox percentageTbx) {
		this.percentageTbx = percentageTbx;
	}



	public Button getSaveBtn() {
		return saveBtn;
	}

	public void setSaveBtn(Button saveBtn) {
		this.saveBtn = saveBtn;
	}



	public VerticalPanel getMainVpanel() {
		return mainVpanel;
	}

	public void setMainVpanel(VerticalPanel mainVpanel) {
		this.mainVpanel = mainVpanel;
	}
	
}
