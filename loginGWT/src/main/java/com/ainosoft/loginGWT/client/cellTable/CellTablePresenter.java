package com.ainosoft.loginGWT.client.cellTable;

import java.util.ArrayList;
import java.util.List;

import com.ainosoft.loginGWT.client.GwtEventBus;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.view.client.AsyncDataProvider;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

@Presenter(view=CellTableDemoView.class)
public class CellTablePresenter extends BasePresenter<CellTableDemoView,GwtEventBus>{

	CellTableDisplayAllModel model;
	ListDataProvider<Employee> dataProvider = new ListDataProvider<Employee>();
	
	public void onGetCellTable() {	
		eventBus.createCellTable(view);
	}
	
	

	public void onGoBackToCellTable()
	{
		eventBus.newTable(view);
	}
	
	public	String searchString ;
	private void search() {
		searchString = view.getTextBox1().getText();
		setData();
	}

	

	
	private void setData() {
		Window.alert(searchString);
		if ( view.getCONTACTS()!= null && view.getCONTACTS().size() > 0) {
			AsyncDataProvider<Employee> provider = new AsyncDataProvider<Employee>() {
				protected void onRangeChanged(HasData<Employee> display) {
					int start = display.getVisibleRange().getStart();
					int end = start + display.getVisibleRange().getLength();
					//new function if searchString is specified take into account
					List<Employee> sub = getSubList(start,end);
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

	private List<Employee> getSubList(int start, int end) {
		List<Employee> filtered_list = null;
		if (searchString != null) {
			filtered_list= new ArrayList<>();
			for (Employee form : view.getCONTACTS()) {
				if (form.getName().equals(searchString) || form.getSurname().equals(searchString) 
						|| form.getCity().equals(searchString) || form.getCountry().equals(searchString))
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
		view.createUi();

		view.getSearchBtn().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				search();	
			}

		});
		final SingleSelectionModel<Employee> selectionModel = new SingleSelectionModel<Employee>();
		
		view.getTable().setSelectionModel(selectionModel);
		selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
			public void onSelectionChange(SelectionChangeEvent event) {
//				selectionModel.clear();
				Employee selected = selectionModel.getSelectedObject();
				if (selected != null) {
					
					Window.alert("You selected: " + selected.getName());
				}
				//eventBus.getDisplayForm(selected);
			
			}
		});


		view.getAddBtn().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
			
				eventBus.getRecord();
			}
		});
		
		view.getRefreshBtn().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Window.alert("Referesh button clicked");
				eventBus.readAllCellTable();
				
			}
		});
		
		view.getResetBtn().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
			
				
			}
		});
	}


}