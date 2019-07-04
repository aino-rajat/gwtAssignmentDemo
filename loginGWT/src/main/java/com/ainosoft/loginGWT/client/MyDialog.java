package com.ainosoft.loginGWT.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MyDialog  extends DialogBox {

    public MyDialog() {
       // Set the dialog box's caption.
       setText("Eduaction Details!");

       // Enable animation.
       setAnimationEnabled(true);

       // Enable glass background.
       setGlassEnabled(true);

       // DialogBox is a SimplePanel, so you have to set its widget 
       // property to whatever you want its contents to be.
       Button ok = new Button("OK");
       ok.addClickHandler(new ClickHandler() {
          public void onClick(ClickEvent event) {
             MyDialog.this.hide();
          }
       });

       Label label = new Label("Details saved Successfully.");

       VerticalPanel panel = new VerticalPanel();
       panel.setHeight("100");
       panel.setWidth("300");
       panel.setSpacing(10);
       panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
       panel.add(label);
       panel.add(ok);

       setWidget(panel);
    }
 }
