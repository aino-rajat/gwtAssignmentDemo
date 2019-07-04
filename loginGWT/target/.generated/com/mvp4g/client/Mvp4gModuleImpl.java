package com.mvp4g.client;

import com.mvp4g.client.history.PlaceService;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.mvp4g.client.presenter.PresenterInterface;
import com.mvp4g.client.event.EventBus;
import com.mvp4g.client.Mvp4gException;
import com.mvp4g.client.history.HistoryConverter;
import com.mvp4g.client.Mvp4gEventPasser;
import com.mvp4g.client.Mvp4gModule;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.mvp4g.client.event.BaseEventBus;
import com.mvp4g.client.event.EventFilter;
import com.mvp4g.client.event.EventHandlerInterface;
import java.util.List;
import com.mvp4g.client.history.NavigationEventCommand;
import com.mvp4g.client.history.NavigationConfirmationInterface;
import com.google.gwt.core.client.RunAsyncCallback;
import com.mvp4g.client.Mvp4gRunAsync;
import com.google.gwt.user.client.Command;

public class Mvp4gModuleImpl implements Mvp4gModule {
    
    private abstract class AbstractEventBus extends com.mvp4g.client.event.BaseEventBusWithLookUp implements com.ainosoft.loginGWT.client.GwtEventBus{}
    
    @GinModules({com.mvp4g.client.DefaultMvp4gGinModule.class})
    public interface com_mvp4g_client_Mvp4gModuleGinjector extends Ginjector {
      com.ainosoft.loginGWT.client.LoginFormPresenter getcom_ainosoft_loginGWT_client_LoginFormPresenter();
      com.ainosoft.loginGWT.client.LoginDisplayFormPresenter getcom_ainosoft_loginGWT_client_LoginDisplayFormPresenter();
      com.ainosoft.loginGWT.client.addCellTableRecord.AddCellTableRecordPresenter getcom_ainosoft_loginGWT_client_addCellTableRecord_AddCellTableRecordPresenter();
      com.ainosoft.loginGWT.client.editDetails.EditDetailsPresenter getcom_ainosoft_loginGWT_client_editDetails_EditDetailsPresenter();
      com.ainosoft.loginGWT.client.eduactionDetails.EducationDetailsPresenter getcom_ainosoft_loginGWT_client_eduactionDetails_EducationDetailsPresenter();
      com.ainosoft.loginGWT.client.dbCellTable.DBCellTablePresenter getcom_ainosoft_loginGWT_client_dbCellTable_DBCellTablePresenter();
      com.ainosoft.loginGWT.client.cellTable.CellTablePresenter getcom_ainosoft_loginGWT_client_cellTable_CellTablePresenter();
      com.ainosoft.loginGWT.client.LoginDisplayFormView getcom_ainosoft_loginGWT_client_LoginDisplayFormPresenterView();
      com.ainosoft.loginGWT.client.addCellTableRecord.AddCellTableRecordView getcom_ainosoft_loginGWT_client_addCellTableRecord_AddCellTableRecordPresenterView();
      com.ainosoft.loginGWT.client.editDetails.EditDetailsView getcom_ainosoft_loginGWT_client_editDetails_EditDetailsPresenterView();
      com.ainosoft.loginGWT.client.eduactionDetails.EducationDetailsView getcom_ainosoft_loginGWT_client_eduactionDetails_EducationDetailsPresenterView();
      com.ainosoft.loginGWT.client.dbCellTable.DBCelltableView getcom_ainosoft_loginGWT_client_dbCellTable_DBCellTablePresenterView();
      com.ainosoft.loginGWT.client.LoginFormView getcom_ainosoft_loginGWT_client_LoginFormPresenterView();
      com.ainosoft.loginGWT.client.cellTable.CellTableDemoView getcom_ainosoft_loginGWT_client_cellTable_CellTablePresenterView();
      com.mvp4g.client.history.PlaceService getcom_mvp4g_client_history_PlaceService();
    }
    private Object startView = null;
    private PresenterInterface startPresenter = null;
    protected AbstractEventBus eventBus = null;
    protected com_mvp4g_client_Mvp4gModuleGinjector injector = null;
    protected com.mvp4g.client.Mvp4gModule itself = this;
    private PlaceService placeService = null;
    public void setParentModule(com.mvp4g.client.Mvp4gModule module){}
    public void loadChildModule(String childModuleClassName, String eventName, boolean passive, Mvp4gEventPasser passer){
    }
    public void addConverter(String historyName, HistoryConverter<?> hc){
      placeService.addConverter(historyName, hc);
    }
    public void clearHistory(){
      placeService.clearHistory();
    }
    public String place(String token, String form, boolean onlyToken){
      return placeService.place( token, form, onlyToken );
    }
    public void dispatchHistoryEvent(String eventType, final Mvp4gEventPasser passer){
      int index = eventType.indexOf(PlaceService.MODULE_SEPARATOR);
      if(index > -1){
        String moduleHistoryName = eventType.substring(0, index);
        String nextToken = eventType.substring(index + 1);
        Mvp4gEventPasser nextPasser = new Mvp4gEventPasser(nextToken) {
          public void pass(Mvp4gModule module) {
            module.dispatchHistoryEvent((String) eventObjects[0], passer);
          }
        };
        passer.setEventObject(false);
        passer.pass(this);
      }else{
        passer.pass(this);
      }
    }
    public void sendInitEvent(){
    }
    public void sendNotFoundEvent(){
    }
    
    public void onForward(){
    }
    
    public void createAndStartModule(){
      injector = GWT.create( com_mvp4g_client_Mvp4gModuleGinjector.class );
      final com.ainosoft.loginGWT.client.LoginDisplayFormView com_ainosoft_loginGWT_client_LoginDisplayFormPresenterView = injector.getcom_ainosoft_loginGWT_client_LoginDisplayFormPresenterView();
      final com.ainosoft.loginGWT.client.addCellTableRecord.AddCellTableRecordView com_ainosoft_loginGWT_client_addCellTableRecord_AddCellTableRecordPresenterView = injector.getcom_ainosoft_loginGWT_client_addCellTableRecord_AddCellTableRecordPresenterView();
      final com.ainosoft.loginGWT.client.editDetails.EditDetailsView com_ainosoft_loginGWT_client_editDetails_EditDetailsPresenterView = injector.getcom_ainosoft_loginGWT_client_editDetails_EditDetailsPresenterView();
      final com.ainosoft.loginGWT.client.eduactionDetails.EducationDetailsView com_ainosoft_loginGWT_client_eduactionDetails_EducationDetailsPresenterView = injector.getcom_ainosoft_loginGWT_client_eduactionDetails_EducationDetailsPresenterView();
      final com.ainosoft.loginGWT.client.dbCellTable.DBCelltableView com_ainosoft_loginGWT_client_dbCellTable_DBCellTablePresenterView = injector.getcom_ainosoft_loginGWT_client_dbCellTable_DBCellTablePresenterView();
      final com.ainosoft.loginGWT.client.LoginFormView com_ainosoft_loginGWT_client_LoginFormPresenterView = injector.getcom_ainosoft_loginGWT_client_LoginFormPresenterView();
      final com.ainosoft.loginGWT.client.cellTable.CellTableDemoView com_ainosoft_loginGWT_client_cellTable_CellTablePresenterView = injector.getcom_ainosoft_loginGWT_client_cellTable_CellTablePresenterView();
      
      
      
      placeService = injector.getcom_mvp4g_client_history_PlaceService();
      
      final com.ainosoft.loginGWT.client.LoginFormPresenter com_ainosoft_loginGWT_client_LoginFormPresenter = injector.getcom_ainosoft_loginGWT_client_LoginFormPresenter();
      com_ainosoft_loginGWT_client_LoginFormPresenter.setView(com_ainosoft_loginGWT_client_LoginFormPresenterView);
      final com.ainosoft.loginGWT.client.LoginDisplayFormPresenter com_ainosoft_loginGWT_client_LoginDisplayFormPresenter = injector.getcom_ainosoft_loginGWT_client_LoginDisplayFormPresenter();
      com_ainosoft_loginGWT_client_LoginDisplayFormPresenter.setView(com_ainosoft_loginGWT_client_LoginDisplayFormPresenterView);
      final com.ainosoft.loginGWT.client.addCellTableRecord.AddCellTableRecordPresenter com_ainosoft_loginGWT_client_addCellTableRecord_AddCellTableRecordPresenter = injector.getcom_ainosoft_loginGWT_client_addCellTableRecord_AddCellTableRecordPresenter();
      com_ainosoft_loginGWT_client_addCellTableRecord_AddCellTableRecordPresenter.setView(com_ainosoft_loginGWT_client_addCellTableRecord_AddCellTableRecordPresenterView);
      final com.ainosoft.loginGWT.client.editDetails.EditDetailsPresenter com_ainosoft_loginGWT_client_editDetails_EditDetailsPresenter = injector.getcom_ainosoft_loginGWT_client_editDetails_EditDetailsPresenter();
      com_ainosoft_loginGWT_client_editDetails_EditDetailsPresenter.setView(com_ainosoft_loginGWT_client_editDetails_EditDetailsPresenterView);
      final com.ainosoft.loginGWT.client.eduactionDetails.EducationDetailsPresenter com_ainosoft_loginGWT_client_eduactionDetails_EducationDetailsPresenter = injector.getcom_ainosoft_loginGWT_client_eduactionDetails_EducationDetailsPresenter();
      com_ainosoft_loginGWT_client_eduactionDetails_EducationDetailsPresenter.setView(com_ainosoft_loginGWT_client_eduactionDetails_EducationDetailsPresenterView);
      final com.ainosoft.loginGWT.client.dbCellTable.DBCellTablePresenter com_ainosoft_loginGWT_client_dbCellTable_DBCellTablePresenter = injector.getcom_ainosoft_loginGWT_client_dbCellTable_DBCellTablePresenter();
      com_ainosoft_loginGWT_client_dbCellTable_DBCellTablePresenter.setView(com_ainosoft_loginGWT_client_dbCellTable_DBCellTablePresenterView);
      final com.ainosoft.loginGWT.client.cellTable.CellTablePresenter com_ainosoft_loginGWT_client_cellTable_CellTablePresenter = injector.getcom_ainosoft_loginGWT_client_cellTable_CellTablePresenter();
      com_ainosoft_loginGWT_client_cellTable_CellTablePresenter.setView(com_ainosoft_loginGWT_client_cellTable_CellTablePresenterView);
      
      
      eventBus = new AbstractEventBus(){
        protected <T extends EventHandlerInterface<?>> T createHandler( Class<T> handlerClass ){
        return null;
        }
        public void getCellTable(){
          if (com_ainosoft_loginGWT_client_cellTable_CellTablePresenter.isActivated(false, "getCellTable")){
            com_ainosoft_loginGWT_client_cellTable_CellTablePresenter.onGetCellTable();
          }
        }
        public void createCellTable(com.ainosoft.loginGWT.client.cellTable.CellTableDemoView attr0){
          if (com_ainosoft_loginGWT_client_LoginFormPresenter.isActivated(false, "createCellTable", new Object[]{attr0})){
            com_ainosoft_loginGWT_client_LoginFormPresenter.onCreateCellTable(attr0);
          }
        }
        public void getUpdateDetailsView(com.ainosoft.loginGWT.client.addCellTableRecord.AddUserRecordSlim attr0){
          if (com_ainosoft_loginGWT_client_editDetails_EditDetailsPresenter.isActivated(false, "getUpdateDetailsView", new Object[]{attr0})){
            com_ainosoft_loginGWT_client_editDetails_EditDetailsPresenter.onGetUpdateDetailsView(attr0);
          }
        }
        public void readAllCellTable(){
          if (com_ainosoft_loginGWT_client_dbCellTable_DBCellTablePresenter.isActivated(false, "readAllCellTable")){
            com_ainosoft_loginGWT_client_dbCellTable_DBCellTablePresenter.onReadAllCellTable();
          }
        }
        public void getDisplayForm(com.ainosoft.loginGWT.client.addCellTableRecord.AddUserRecordSlim attr0){
          if (com_ainosoft_loginGWT_client_LoginDisplayFormPresenter.isActivated(false, "getDisplayForm", new Object[]{attr0})){
            com_ainosoft_loginGWT_client_LoginDisplayFormPresenter.onGetDisplayForm(attr0);
          }
        }
        public void changeDetails(com.ainosoft.loginGWT.client.editDetails.EditDetailsView attr0){
          if (com_ainosoft_loginGWT_client_LoginFormPresenter.isActivated(false, "changeDetails", new Object[]{attr0})){
            com_ainosoft_loginGWT_client_LoginFormPresenter.onChangeDetails(attr0);
          }
        }
        public void displayCelltable(com.ainosoft.loginGWT.client.dbCellTable.DBCelltableView attr0){
          if (com_ainosoft_loginGWT_client_LoginFormPresenter.isActivated(false, "displayCelltable", new Object[]{attr0})){
            com_ainosoft_loginGWT_client_LoginFormPresenter.onDisplayCelltable(attr0);
          }
        }
        public void viewUserDetails(com.ainosoft.loginGWT.client.LoginDisplayFormView attr0){
          if (com_ainosoft_loginGWT_client_LoginFormPresenter.isActivated(false, "viewUserDetails", new Object[]{attr0})){
            com_ainosoft_loginGWT_client_LoginFormPresenter.onViewUserDetails(attr0);
          }
        }
        public void getEducationDetailsView(){
          if (com_ainosoft_loginGWT_client_eduactionDetails_EducationDetailsPresenter.isActivated(false, "getEducationDetailsView")){
            com_ainosoft_loginGWT_client_eduactionDetails_EducationDetailsPresenter.onGetEducationDetailsView();
          }
        }
        public void goBackToCellTable(){
          if (com_ainosoft_loginGWT_client_cellTable_CellTablePresenter.isActivated(false, "goBackToCellTable")){
            com_ainosoft_loginGWT_client_cellTable_CellTablePresenter.onGoBackToCellTable();
          }
        }
        public void addrecordView(com.ainosoft.loginGWT.client.addCellTableRecord.AddCellTableRecordView attr0){
          if (com_ainosoft_loginGWT_client_LoginFormPresenter.isActivated(false, "addrecordView", new Object[]{attr0})){
            com_ainosoft_loginGWT_client_LoginFormPresenter.onAddrecordView(attr0);
          }
        }
        public void getRecord(){
          if (com_ainosoft_loginGWT_client_addCellTableRecord_AddCellTableRecordPresenter.isActivated(false, "getRecord")){
            com_ainosoft_loginGWT_client_addCellTableRecord_AddCellTableRecordPresenter.onGetRecord();
          }
        }
        public void newTable(com.ainosoft.loginGWT.client.cellTable.CellTableDemoView attr0){
          if (com_ainosoft_loginGWT_client_LoginFormPresenter.isActivated(false, "newTable", new Object[]{attr0})){
            com_ainosoft_loginGWT_client_LoginFormPresenter.onNewTable(attr0);
          }
        }
        public void getAddressView(){
          if (com_ainosoft_loginGWT_client_LoginFormPresenter.isActivated(false, "getAddressView")){
            com_ainosoft_loginGWT_client_LoginFormPresenter.onGetAddressView();
          }
        }
        public void addEducationDetails(com.ainosoft.loginGWT.client.eduactionDetails.EducationDetailsView attr0){
          if (com_ainosoft_loginGWT_client_LoginDisplayFormPresenter.isActivated(false, "addEducationDetails", new Object[]{attr0})){
            com_ainosoft_loginGWT_client_LoginDisplayFormPresenter.onAddEducationDetails(attr0);
          }
        }
        public void dispatch( String eventType, Object... data ){
          try{
            if ( "getCellTable".equals( eventType ) ){
              getCellTable();
            } else if ( "createCellTable".equals( eventType ) ){
              createCellTable((com.ainosoft.loginGWT.client.cellTable.CellTableDemoView) data[0]);
            } else if ( "getUpdateDetailsView".equals( eventType ) ){
              getUpdateDetailsView((com.ainosoft.loginGWT.client.addCellTableRecord.AddUserRecordSlim) data[0]);
            } else if ( "readAllCellTable".equals( eventType ) ){
              readAllCellTable();
            } else if ( "getDisplayForm".equals( eventType ) ){
              getDisplayForm((com.ainosoft.loginGWT.client.addCellTableRecord.AddUserRecordSlim) data[0]);
            } else if ( "changeDetails".equals( eventType ) ){
              changeDetails((com.ainosoft.loginGWT.client.editDetails.EditDetailsView) data[0]);
            } else if ( "displayCelltable".equals( eventType ) ){
              displayCelltable((com.ainosoft.loginGWT.client.dbCellTable.DBCelltableView) data[0]);
            } else if ( "viewUserDetails".equals( eventType ) ){
              viewUserDetails((com.ainosoft.loginGWT.client.LoginDisplayFormView) data[0]);
            } else if ( "getEducationDetailsView".equals( eventType ) ){
              getEducationDetailsView();
            } else if ( "goBackToCellTable".equals( eventType ) ){
              goBackToCellTable();
            } else if ( "addrecordView".equals( eventType ) ){
              addrecordView((com.ainosoft.loginGWT.client.addCellTableRecord.AddCellTableRecordView) data[0]);
            } else if ( "getRecord".equals( eventType ) ){
              getRecord();
            } else if ( "newTable".equals( eventType ) ){
              newTable((com.ainosoft.loginGWT.client.cellTable.CellTableDemoView) data[0]);
            } else if ( "getAddressView".equals( eventType ) ){
              getAddressView();
            } else if ( "addEducationDetails".equals( eventType ) ){
              addEducationDetails((com.ainosoft.loginGWT.client.eduactionDetails.EducationDetailsView) data[0]);
            } else {
              throw new Mvp4gException( "Event " + eventType + " doesn't exist. Have you forgotten to add it to your Mvp4g configuration file?" );
            }
          } catch ( ClassCastException e ) {
            handleClassCastException( e, eventType );
          }
        }
      public void setNavigationConfirmation( NavigationConfirmationInterface navigationConfirmation ) {
        placeService.setNavigationConfirmation(navigationConfirmation);
      }
      public void confirmNavigation(NavigationEventCommand event){
        placeService.confirmEvent(event);
      }
      public void setApplicationHistoryStored( boolean historyStored ){
        placeService.setEnabled(historyStored);
      }
      };
      
      com_ainosoft_loginGWT_client_LoginFormPresenter.setEventBus(eventBus);
      com_ainosoft_loginGWT_client_LoginDisplayFormPresenter.setEventBus(eventBus);
      com_ainosoft_loginGWT_client_addCellTableRecord_AddCellTableRecordPresenter.setEventBus(eventBus);
      com_ainosoft_loginGWT_client_editDetails_EditDetailsPresenter.setEventBus(eventBus);
      com_ainosoft_loginGWT_client_eduactionDetails_EducationDetailsPresenter.setEventBus(eventBus);
      com_ainosoft_loginGWT_client_dbCellTable_DBCellTablePresenter.setEventBus(eventBus);
      com_ainosoft_loginGWT_client_cellTable_CellTablePresenter.setEventBus(eventBus);
      placeService.setModule(itself);
      
      this.startPresenter = com_ainosoft_loginGWT_client_LoginFormPresenter;
      this.startView = startPresenter.getView();
      eventBus.getAddressView();
    }
    public Object getStartView(){
      if (startPresenter != null) {
        startPresenter.setActivated(true);
        startPresenter.isActivated(false, null);
      }return startView;
    }
    
    public EventBus getEventBus(){
      return eventBus;
    }
  }
