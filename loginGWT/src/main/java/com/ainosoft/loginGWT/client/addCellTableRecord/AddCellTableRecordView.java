package com.ainosoft.loginGWT.client.addCellTableRecord;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class AddCellTableRecordView extends Composite{

	TextBox name;
	TextBox surname;
	TextBox city;
	TextBox country;
	Button cancelBtn,saveBtn;
	 
	VerticalPanel userRecordPanel;
	FlexTable flexTable;
	
	public void initialize() {
		name=new TextBox();
		surname=new TextBox();
		city=new TextBox();
		country=new TextBox();

		
		flexTable = new FlexTable();
		userRecordPanel=new VerticalPanel();
		
		cancelBtn=new Button("Go Back");
		saveBtn=new Button("Save");
	}
	
	public FlexTable createUi() {
	
		
		flexTable.setHTML(1, 0, "Name :");
		flexTable.setWidget(1, 1, name);
		flexTable.setCellPadding(10);
		
		flexTable.setHTML(2, 0, "Surname :");
		flexTable.setWidget(2, 1, surname);

		flexTable.setHTML(3, 0, "City :");
		flexTable.setWidget(3, 1, city);

		flexTable.setHTML(4, 0, "Country :");
		flexTable.setWidget(4, 1, country);

		flexTable.setWidget(5,1, cancelBtn);
		flexTable.setWidget(5, 2, saveBtn);
		userRecordPanel.add(flexTable);

		initWidget(userRecordPanel);
		return flexTable;
	}
	
	public void setStyle() {	
		userRecordPanel.setStyleName("UserCellRecordPanel");
		flexTable.setStyleName("flexTable");
		cancelBtn.setStyleName("CancelButton");
		saveBtn.setStyleName("SaveButton");
	}

	
	public Label errorLabel(String string) {
		Label label=new Label(string);
		label.setStyleName("Error");
		return label;
	}
	
	public TextBox getName() {
		return name;
	}

	public void setName(TextBox name) {
		this.name = name;
	}

	public TextBox getSurname() {
		return surname;
	}

	public void setSurname(TextBox surname) {
		this.surname = surname;
	}

	public TextBox getCity() {
		return city;
	}

	public void setCity(TextBox city) {
		this.city = city;
	}

	public TextBox getCountry() {
		return country;
	}

	public void setCountry(TextBox country) {
		this.country = country;
	}

	public Button getSave() {
		return saveBtn;
	}

	public void setSave(Button save) {
		this.saveBtn = save;
	}

	public Button getCancelBtn() {
		return cancelBtn;
	}

	public void setCancelBtn(Button cancelBtn) {
		this.cancelBtn = cancelBtn;
	}

	public VerticalPanel getUserRecordPanel() {
		return userRecordPanel;
	}

	public void setUserRecordPanel(VerticalPanel userRecordPanel) {
		this.userRecordPanel = userRecordPanel;
	}

	public FlexTable getFlexTable() {
		return flexTable;
	}

	public void setFlexTable(FlexTable flexTable) {
		this.flexTable = flexTable;
	}
}
