package com.ainosoft.loginGWT.client.eduactionDetails;

import com.ainosoft.loginGWT.client.GwtEventBus;
import com.ainosoft.loginGWT.client.MyDialog;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

@Presenter(view=EducationDetailsView.class)
public class EducationDetailsPresenter extends BasePresenter<EducationDetailsView,GwtEventBus> {

	public void onGetEducationDetailsView() {
		Window.alert("in get education deatils method ");
	  view.createUi();
	  eventBus.addEducationDetails(view);
	}

	 
	  
	  @Override
	  public void bind() {
		  view.initialize();
		  view.createUi();  
	  
	  
	  view.getEnglishTbx().addBlurHandler(new BlurHandler() {
			@Override
			public void onBlur(BlurEvent event) {
				String EngMarks=view.getEnglishTbx().getText();
				if(EngMarks.isEmpty())
				{
					view.getErrorEngLbl().setVisible(true);
			}
				else {
					view.getErrorEngLbl().setVisible(false);
				}	
		}
	  });
	  
	  view.getMathTbx().addBlurHandler(new BlurHandler() {
			@Override
			public void onBlur(BlurEvent event) {
				String MathMarks=view.getMathTbx().getText();
				if(MathMarks.isEmpty())
				{
					view.getErrorMathLbl().setVisible(true);
			}
				else {
					view.getErrorMathLbl().setVisible(false);
				}	
		}
	  });
	  
	  view.getScienceTbx().addBlurHandler(new BlurHandler() {
			@Override
			public void onBlur(BlurEvent event) {
				String ScienceMarks=view.getScienceTbx().getText();
				if(ScienceMarks.isEmpty())
				{
					view.getErrorScienceLbl().setVisible(true);
			}
				else {
					view.getErrorScienceLbl().setVisible(false);
				}	
		}
	  });
	  
	  view.getPercentageTbx().addBlurHandler(new BlurHandler() {
			@Override
			public void onBlur(BlurEvent event) {
				String Percent=view.getPercentageTbx().getText();
				if(Percent.isEmpty())
				{
					view.getErrorPercentageLbl().setVisible(true);
			}
				else {
					view.getErrorPercentageLbl().setVisible(false);
				}	
		}
	  });
	  
	  
	  
	  view.getSaveBtn().addClickHandler(new ClickHandler() {
	         @Override
	         public void onClick(ClickEvent event) {
	        	 String EngMarks=view.getEnglishTbx().getText();
	        	 String MathMarks=view.getMathTbx().getText();
	        	 String ScienceMarks=view.getScienceTbx().getText();
	        	 String Percent=view.getPercentageTbx().getText();
	        	 if(EngMarks.isEmpty() || MathMarks.isEmpty() || ScienceMarks.isEmpty()|| Percent.isEmpty()) {
	        		 view.getErrorEngLbl().setVisible(true);
	        		 view.getErrorMathLbl().setVisible(true);
	        		 view.getErrorScienceLbl().setVisible(true);
	        		 view.getErrorPercentageLbl().setVisible(true);
	        	 }
	        	 else {
	            // Instantiate the dialog box and show it.
	            MyDialog myDialog = new MyDialog();

	            int left = Window.getClientWidth()/2;
	            int top = Window.getClientHeight()/2;
	            myDialog.setPopupPosition(left, top);
	            myDialog.show();	
	        	 }
	         }
	      });
	  
	  
	  }
}
