package com.ainosoft.loginGWT.client.dbCellTable;

import java.util.List;

import com.ainosoft.loginGWT.client.addCellTableRecord.AddUserRecordSlim;
import com.ainosoft.loginGWT.client.cellTable.MyCellTableResources;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.ListDataProvider;

public class DBCelltableView extends Composite{

	private VerticalPanel cellTableMainPanel ,tablePanel;
	private TextBox textBox;
	private Button searchBtn,cancelBtn,refreshBtn;
	private HorizontalPanel Hpanel;
	private CellTable<AddUserRecordSlim> table;
	private List<AddUserRecordSlim> sub;
	
	ListDataProvider<AddUserRecordSlim> dataProvider = new ListDataProvider<AddUserRecordSlim>();
	
	// The list of data to display.
	private static List<AddUserRecordSlim> CONTACTS; 
	
	public void initialize() {
		cellTableMainPanel=new VerticalPanel();
		textBox=new TextBox();
		searchBtn=new Button("Search");
		cancelBtn=new Button("Cancel");
		refreshBtn=new Button("Refresh Data");
		Hpanel=new HorizontalPanel();
		table = new CellTable<AddUserRecordSlim>();
		tablePanel=new VerticalPanel();
		table = new CellTable<AddUserRecordSlim>(10, (CellTable.Resources)GWT.create(MyCellTableResources.class));
		
		initWidget(cellTableMainPanel);
		
	}
	
	public void clearUi() {		
		cellTableMainPanel.clear();
		tablePanel.clear();
	}

	public void createUI() {
		Hpanel.add(textBox);
		Hpanel.add(searchBtn);
		Hpanel.add(cancelBtn);
		Hpanel.add(refreshBtn);
		
		nameColumn.setSortable(true);
		surnameColum.setSortable(true);
		cityColum.setSortable(true);
		countryColum.setSortable(true);
		
		getTable().addColumn(nameColumn, "Name");
		getTable().addColumn(surnameColum, "Surname");
		getTable().addColumn(cityColum, "City");
		getTable().addColumn(countryColum, "Country");
	
		
		Hpanel.add(table);
		cellTableMainPanel.add(Hpanel);
		tablePanel.add(table);
		cellTableMainPanel.add(tablePanel);
		setStyle();
		
	}
	
	TextColumn<AddUserRecordSlim> nameColumn = new TextColumn<AddUserRecordSlim>() {
		@Override
		public String getValue(AddUserRecordSlim contact) {
			return contact.getName();
		}
	};
	// Make the name column sortable.
	

	// Create surname  column.
	TextColumn<AddUserRecordSlim> surnameColum = new TextColumn<AddUserRecordSlim>() {
		@Override
		public String getValue(AddUserRecordSlim contact) {
			return contact.getSurname();
		}
	};


	// Create city column.
	TextColumn<AddUserRecordSlim> cityColum = new TextColumn<AddUserRecordSlim>() {
		@Override
		public String getValue(AddUserRecordSlim contact) {
			return contact.getCity();
		}
	};


	// Create Country  column.
	TextColumn<AddUserRecordSlim> countryColum = new TextColumn<AddUserRecordSlim>() {
		@Override
		public String getValue(AddUserRecordSlim contact) {
			return contact.getCountry();
		}
	};
	
	
	public void setStyle() {
		textBox.setStyleName("searchBox");
		searchBtn.setStyleName("searchButton");
		cancelBtn.setStyleName("cancelButton");
		refreshBtn.setStyleName("refreshBtn");
		table.setStyleName("cellTable");
	}
	
	public ListDataProvider<AddUserRecordSlim> getDataProvider() {
		return dataProvider;
	}

	public void setDataProvider(ListDataProvider<AddUserRecordSlim> dataProvider) {
		this.dataProvider = dataProvider;
	}

	public TextColumn<AddUserRecordSlim> getNameColumn() {
		return nameColumn;
	}

	public TextColumn<AddUserRecordSlim> getSurnameColum() {
		return surnameColum;
	}

	public TextColumn<AddUserRecordSlim> getCityColum() {
		return cityColum;
	}

	public TextColumn<AddUserRecordSlim> getCountryColum() {
		return countryColum;
	}
	
	
	
	public void setNameColumn(TextColumn<AddUserRecordSlim> nameColumn) {
		this.nameColumn = nameColumn;
	}

	public void setSurnameColum(TextColumn<AddUserRecordSlim> surnameColum) {
		this.surnameColum = surnameColum;
	}

	public void setCityColum(TextColumn<AddUserRecordSlim> cityColum) {
		this.cityColum = cityColum;
	}

	public void setCountryColum(TextColumn<AddUserRecordSlim> countryColum) {
		this.countryColum = countryColum;
	}

	public Button getCancelBtn() {
		return cancelBtn;
	}

	public void setCancelBtn(Button cancelBtn) {
		this.cancelBtn = cancelBtn;
	}
	

	public VerticalPanel getCellTableMainPanel() {
		return cellTableMainPanel;
	}


	public void setCellTableMainPanel(VerticalPanel cellTableMainPanel) {
		this.cellTableMainPanel = cellTableMainPanel;
	}


	public VerticalPanel getTablePanel() {
		return tablePanel;
	}


	public void setTablePanel(VerticalPanel tablePanel) {
		this.tablePanel = tablePanel;
	}	


	public TextBox getTextBox() {
		return textBox;
	}

	public void setTextBox(TextBox textBox1) {
		this.textBox = textBox1;
	}


	public Button getSearchBtn() {
		return searchBtn;
	}


	public void setSearchBtn(Button searchBtn) {
		this.searchBtn = searchBtn;
	}


	public Button getRefreshBtn() {
		return refreshBtn;
	}


	public void setRefreshBtn(Button refreshBtn) {
		this.refreshBtn = refreshBtn;
	}


	public HorizontalPanel getHpanel() {
		return Hpanel;
	}


	public void setHpanel(HorizontalPanel hpanel) {
		Hpanel = hpanel;
	}


	public CellTable<AddUserRecordSlim> getTable() {
		return table;
	}


	public void setTable(CellTable<AddUserRecordSlim> table) {
		this.table = table;
	}


	public static List<AddUserRecordSlim> getCONTACTS() {
		return CONTACTS;
	}


	public static void setCONTACTS(List<AddUserRecordSlim> cONTACTS) {
		CONTACTS = cONTACTS;
	}

	public List<AddUserRecordSlim> getSub() {
		return sub;
	}

	public void setSub(List<AddUserRecordSlim> sub) {
		this.sub = sub;
	}
	
}

	
	
	
	
