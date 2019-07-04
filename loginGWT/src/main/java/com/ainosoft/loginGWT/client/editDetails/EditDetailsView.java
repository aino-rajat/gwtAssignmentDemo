package com.ainosoft.loginGWT.client.editDetails;

import com.ainosoft.loginGWT.client.addCellTableRecord.AddUserRecordSlim;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class EditDetailsView extends Composite {

	private VerticalPanel mainVpanel;
	
	private HorizontalPanel Hpanel;
	private HorizontalPanel nameHpanel,surnameHpanel,cityHpanel,countryHpanel;
	private Label nameLbl,surnameLbl,cityLbl,countryLbl;
	private TextBox nameTxtBox,surnameTxtBox,cityTxtBox,countryTxtBox;
	
	private Button cancelBtn,updateBtn,saveBtn;


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
		
		cancelBtn=new Button("Cancel Edit");
		updateBtn=new Button("Save");
		
		
		initWidget(mainVpanel);
		
	}

								
		public void createUI(AddUserRecordSlim selected) {
			mainVpanel.add(createField("Name:", selected.getName()));
			mainVpanel.add(createField("Surname:", selected.getSurname()));
			mainVpanel.add(createField("City:", selected.getCity()));
			mainVpanel.add(createField("Country:", selected.getCountry()));
			mainVpanel.add(cancelBtn);
			mainVpanel.add(updateBtn);
			

		}
		

		public FlowPanel createField(String fieldname,String fieldValue) {
		        FlowPanel flowPanel=new FlowPanel();
		        flowPanel.setStylePrimaryName("flowpanel");
		        Label field=new Label(fieldname);
		        field.setStylePrimaryName("field");
		        TextBox textBox=new TextBox();
		        textBox.setText(fieldValue);

		        flowPanel.add(field);
		        flowPanel.add(textBox);
		        return flowPanel;
		    }
		 public void setStyle() {
				mainVpanel.setStyleName("MainPanelUserdetail");
				nameHpanel.setStyleName("name-label");
				cancelBtn.setStyleName("Cancel");
				updateBtn.setStyleName("SaveChanges");
			}

		
		 public VerticalPanel getMainVpanel() {
				return mainVpanel;
			}

			public void setMainVpanel(VerticalPanel mainVpanel) {
				this.mainVpanel = mainVpanel;
			}
			
		public Button getCancelBtn() {
			return cancelBtn;
		}


		public void setCancelBtn(Button cancelBtn) {
			this.cancelBtn = cancelBtn;
		}
		
		public Button getUpdateBtn() {
			return updateBtn;
		}


		public void setUpdateBtn(Button updateBtn) {
			this.updateBtn = updateBtn;
		}
}
