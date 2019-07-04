package com.ainosoft.loginGWT.client.cellTable;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.ListDataProvider;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class CellTableDemoView extends Composite {

	private VerticalPanel cellTableMainPanel ,tablePanel;
	private TextBox textBox1;
	private Button searchBtn,addBtn,refreshBtn,resetBtn;
	private HorizontalPanel Hpanel;
	private CellTable<Employee> table;
	
	ListDataProvider<Employee> dataProvider = new ListDataProvider<Employee>();

	

	// The list of data to display.
	private static List<Employee> CONTACTS; 
	
	public void initialize() {
		cellTableMainPanel=new VerticalPanel();
		textBox1=new TextBox();
		searchBtn=new Button("Search");
		addBtn=new Button("Add Record");
		refreshBtn=new Button("Retrive Data");
		resetBtn=new Button("Refresh Data");
		Hpanel=new HorizontalPanel();
		table = new CellTable<Employee>();
		tablePanel=new VerticalPanel();
		table = new CellTable<Employee>(10, (CellTable.Resources)GWT.create(MyCellTableResources.class));
		
//		table.getElement().getStyle().setWhiteSpace(WhiteSpace.NOWRAP);
//		table.getElement().setStyle()
	
		
	}
	
	
	public void clearUi() {		
		cellTableMainPanel.clear();
		tablePanel.clear();
	
	}
			//void
	public void createUi() {
		
		
		// Create a CellTable.
		
		CONTACTS = Arrays.asList(new Employee
				("John","Wick","LossAngeles","USA"),
				new Employee("Mary", "Kom","Nepal","India"),
				new Employee("RAJAT", "Jaee","Pune","INIDA"),
				new Employee("Shubham", "Manchalkar","Nagpur","Australia"),
				new Employee("Vinay", "Revar","Banglore","Singhapur"),
				new Employee("Nandita", "Shakya","Mumbai","Italy"));
		

		// Create name column.
		TextColumn<Employee> nameColumn = new TextColumn<Employee>() {
			@Override
			public String getValue(Employee contact) {
				return contact.getName();
			}
		};

		// Make the name column sortable.
		nameColumn.setSortable(true);

		// Create surname  column.
		TextColumn<Employee> surnameColum = new TextColumn<Employee>() {
			@Override
			public String getValue(Employee contact) {
				return contact.getSurname();
			}
		};
		surnameColum.setSortable(true);

		// Create city column.
		TextColumn<Employee> cityColum = new TextColumn<Employee>() {
			@Override
			public String getValue(Employee contact) {
				return contact.getCity();
			}
		};
		cityColum.setSortable(true);

		// Create Country  column.
		TextColumn<Employee> countryColum = new TextColumn<Employee>() {
			@Override
			public String getValue(Employee contact) {
				return contact.getCountry();
			}
		};
		countryColum.setSortable(true);




		// Add the columns.
		table.addColumn(nameColumn, "Name");
		table.addColumn(surnameColum, "Surname");
		table.addColumn(cityColum, "City");
		table.addColumn(countryColum, "Country");

		// Create a data provider.
		//ListDataProvider<Employee> dataProvider = new ListDataProvider<Employee>();

		// Connect the table to the data provider.
		dataProvider.addDataDisplay(table);

		// Add the data to the data provider, which automatically pushes it to the
		// widget.
		List<Employee> list = dataProvider.getList();
		for (Employee contact : CONTACTS) {
			list.add(contact);
		}

		// Add a ColumnSortEvent.ListHandler to connect sorting to the
		// java.util.List.
		ListHandler<Employee> columnSortHandler = new ListHandler<Employee>(
				list);
		columnSortHandler.setComparator(nameColumn,
				new Comparator<Employee>() {
			public int compare(Employee o1, Employee o2) {
				if (o1 == o2) {
					return 0;
				}

				// Compare the name columns.
				if (o1 != null) {
					return (o2 != null) ? o1.getName().compareTo(o2.getName()) : 1;
				}
				return -1;
			}

		});


		ListHandler<Employee> surNamecolumnSortHandler = new ListHandler<Employee>(
				list);
		surNamecolumnSortHandler.setComparator(surnameColum,
				new Comparator<Employee>() {
			public int compare(Employee o1, Employee o2) {
				if (o1 == o2) {
					return 0;
				}

				// Compare the name columns.
				if (o1 != null) {
					return (o2 != null) ? o1.getSurname().compareTo(o2.getSurname()) : 1;
				}
				return -1;
			}
		});

		ListHandler<Employee> citycolumnSortHandler = new ListHandler<Employee>(
				list);
		citycolumnSortHandler.setComparator(cityColum,
				new Comparator<Employee>() {
			public int compare(Employee o1, Employee o2) {
				if (o1 == o2) {
					return 0;
				}

				// Compare the name columns.
				if (o1 != null) {
					return (o2 != null) ? o1.getCity().compareTo(o2.getCity()) : 1;
				}
				return -1;
			}
		});

		ListHandler<Employee> countrycolumnSortHandler = new ListHandler<Employee>(
				list);
		countrycolumnSortHandler.setComparator(countryColum,
				new Comparator<Employee>() {
			public int compare(Employee o1, Employee o2) {
				if (o1 == o2) {
					return 0;
				}

				// Compare the name columns.
				if (o1 != null) {
					return (o2 != null) ? o1.getCountry().compareTo(o2.getCountry()) : 1;

				}
				return -1;
			}
		});


		table.addColumnSortHandler(columnSortHandler);
		table.addColumnSortHandler(surNamecolumnSortHandler);
		table.addColumnSortHandler(citycolumnSortHandler);
		table.addColumnSortHandler(countrycolumnSortHandler);

		// We know that the data is sorted alphabetically by default.
		table.getColumnSortList().push(nameColumn);
		table.getColumnSortList().push(surnameColum);
		table.getColumnSortList().push(cityColum);
		table.getColumnSortList().push(countryColum);

		setStyle();
		// Add it to the root panel.

		Hpanel.add(textBox1);
		Hpanel.add(searchBtn);
		Hpanel.add(addBtn);
		Hpanel.add(refreshBtn);
		Hpanel.add(resetBtn);
		//RootPanel.get().add(textBox1);
		// RootPanel.get().add(searchBtn);
		cellTableMainPanel.add(Hpanel);
		tablePanel.add(table);
		cellTableMainPanel.add(tablePanel);
		//return table;
		
	}

	public static List<Employee> getCONTACTS() {
		return CONTACTS;
	}

	public static void setCONTACTS(List<Employee> cONTACTS) {
		CONTACTS = cONTACTS;
	}

	public void setStyle() {
	
		textBox1.setStyleName("searchBox");
		searchBtn.setStyleName("searchButton");
		addBtn.setStyleName("AddRecord");
		refreshBtn.setStyleName("refreshBtn");
		resetBtn.setStyleName("ResetBtn");
		table.setStyleName("cellTable");

	}

	public Button getResetBtn() {
		return resetBtn;
	}


	public void setResetBtn(Button resetBtn) {
		this.resetBtn = resetBtn;
	}


	public ListDataProvider<Employee> getDataProvider() {
		return dataProvider;
	}


	public void setDataProvider(ListDataProvider<Employee> dataProvider) {
		this.dataProvider = dataProvider;
	}


	public Button getRefreshBtn() {
		return refreshBtn;
	}


	public void setRefreshBtn(Button refreshBtn) {
		this.refreshBtn = refreshBtn;
	}


	public Button getAddBtn() {
		return addBtn;
	}


	public void setAddBtn(Button addBtn) {
		this.addBtn = addBtn;
	}


	public TextBox getTextBox1() {
		return textBox1;
	}

	public void setTextBox1(TextBox textBox1) {
		this.textBox1 = textBox1;
	}

	public Button getSearchBtn() {
		return searchBtn;
	}

	public void setSearchBtn(Button searchBtn) {
		this.searchBtn = searchBtn;
	}

	public HorizontalPanel getHpanel() {
		return Hpanel;
	}

	public void setHpanel(HorizontalPanel hpanel) {
		Hpanel = hpanel;
	}

	public VerticalPanel getCellTableMainPanel() {
		return cellTableMainPanel;
	}

	public void setCellTableMainPanel(VerticalPanel cellTableMainPanel) {
		this.cellTableMainPanel = cellTableMainPanel;
	}
	public CellTable<Employee> getTable() {
		return table;
	}

	public void setTable(CellTable<Employee> table) {
		this.table = table;
	}

}
		





