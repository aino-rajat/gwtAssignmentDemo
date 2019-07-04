package com.ainosoft.loginGWT.client.dbCellTable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.ainosoft.loginGWT.client.GwtEventBus;
import com.ainosoft.loginGWT.client.LoginService;
import com.ainosoft.loginGWT.client.LoginServiceAsync;
import com.ainosoft.loginGWT.client.addCellTableRecord.AddUserRecordSlim;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.view.client.AsyncDataProvider;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

@Presenter(view=DBCelltableView.class)
public class DBCellTablePresenter extends BasePresenter<DBCelltableView,GwtEventBus>{
	
	public String searchRecord;
	ListDataProvider<AddUserRecordSlim> dataProvider = new ListDataProvider<AddUserRecordSlim>();
	public void onReadAllCellTable() {
		
		eventBus.displayCelltable(view);
	}
	
	
	protected void search() {
		searchRecord = view.getTextBox().getText();
		setData();
	}
	
	private void setData() {
		Window.alert(searchRecord);
		if ( view.getCONTACTS()!= null && view.getCONTACTS().size() > 0) {
			AsyncDataProvider<AddUserRecordSlim> provider = new AsyncDataProvider<AddUserRecordSlim>() {
				protected void onRangeChanged(HasData<AddUserRecordSlim> display) {
					int start = display.getVisibleRange().getStart();
					int end = start + display.getVisibleRange().getLength();
					//new function if searchString is specified take into account
					List<AddUserRecordSlim> sub = getSubList(start,end);
					view.getDataProvider().getList().clear();
                    view.getDataProvider().setList(sub);
					end = end >= sub.size() ? sub.size() : end;
					updateRowData(start, sub);

				}


			};
			provider.addDataDisplay(view.getTable());
			Window.alert(view.getTable().toString());
			provider.updateRowCount(view.getCONTACTS().size(), true);

		}
	}

	private List<AddUserRecordSlim> getSubList(int start, int end) {
		List<AddUserRecordSlim> filtered_list = null;
		if (searchRecord != null) {
			filtered_list= new ArrayList<>();
			for (AddUserRecordSlim form : view.getCONTACTS()) {
				if (form.getName().equals(searchRecord) || form.getSurname().equals(searchRecord) 
						|| form.getCity().equals(searchRecord) || form.getCountry().equals(searchRecord))
					filtered_list.add(form);                
			}
		}
		else 
			filtered_list =view.getCONTACTS();
		return filtered_list;
	}
	
	
	
	@Override
	public void bind() {
		super.bind();
		view.initialize();
		view.clearUi();
		view.createUI();
		
		

		view.getSearchBtn().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				search();	
			}

		});
		
		
		
		
		
		view.getRefreshBtn().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				
				LoginServiceAsync loginAsync = GWT.create(LoginService.class);
				loginAsync.readAll(new AsyncCallback<ArrayList<AddUserRecordSlim>>() {

					@Override
					public void onSuccess(ArrayList<AddUserRecordSlim> result) {
						Window.alert("Success");
						ListDataProvider<AddUserRecordSlim> dataProvider = new ListDataProvider<AddUserRecordSlim>();

						dataProvider.addDataDisplay(view.getTable());

						List<AddUserRecordSlim> list = dataProvider.getList();
						for (AddUserRecordSlim contact : result) {
							list.add(contact);
						}
					
						view.getNameColumn().setSortable(true);
						view.getSurnameColum().setSortable(true);
						view.getCityColum().setSortable(true);
						view.getCountryColum().setSortable(true);
						
						ListHandler<AddUserRecordSlim> columnSortHandler = new ListHandler<AddUserRecordSlim>(
								list);
						columnSortHandler.setComparator(view.getNameColumn(),
								new Comparator<AddUserRecordSlim>() {
							public int compare(AddUserRecordSlim o1, AddUserRecordSlim o2) {
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
						
						ListHandler<AddUserRecordSlim> surnamecolumnSortHandler = new ListHandler<AddUserRecordSlim>(
								list);
						columnSortHandler.setComparator(view.getSurnameColum(),
								new Comparator<AddUserRecordSlim>() {
							public int compare(AddUserRecordSlim o1, AddUserRecordSlim o2) {
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
						
						ListHandler<AddUserRecordSlim> citycolumnSortHandler = new ListHandler<AddUserRecordSlim>(
								list);
						columnSortHandler.setComparator(view.getCityColum(),
								new Comparator<AddUserRecordSlim>() {
							public int compare(AddUserRecordSlim o1, AddUserRecordSlim o2) {
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

						ListHandler<AddUserRecordSlim> countrycolumnSortHandler = new ListHandler<AddUserRecordSlim>(
								list);
						columnSortHandler.setComparator(view.getCountryColum(),
								new Comparator<AddUserRecordSlim>() {
							public int compare(AddUserRecordSlim o1, AddUserRecordSlim o2) {
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
						
						view.getTable().addColumnSortHandler(columnSortHandler);
						view.getTable().addColumnSortHandler(surnamecolumnSortHandler);
						view.getTable().addColumnSortHandler(citycolumnSortHandler);
						view.getTable().addColumnSortHandler(countrycolumnSortHandler);
						
						// We know that the data is sorted alphabetically by default.
						view.getTable().getColumnSortList().push(view.nameColumn);
						view.getTable().getColumnSortList().push(view.surnameColum);
						view.getTable().getColumnSortList().push(view.cityColum);
						view.getTable().getColumnSortList().push(view.countryColum);
						
						final SingleSelectionModel<AddUserRecordSlim> selectionModel = new SingleSelectionModel<AddUserRecordSlim>();
						
						view.getTable().setSelectionModel(selectionModel);
						selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
							public void onSelectionChange(SelectionChangeEvent event) {
//								selectionModel.clear();
								AddUserRecordSlim selected = selectionModel.getSelectedObject();
								if (selected != null) {
									
									Window.alert("You selected: " + selected.getName());
								}
								eventBus.getDisplayForm(selected);
							
							}
						});

					}//onsuccess closed

					@Override
					public void onFailure(Throwable caught) {
						Window.alert("bad");

					}
				});

			}
		});
		
		view.getCancelBtn().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				eventBus.getCellTable();
				
			}
		});

	}

	
}
