package agarcia.gwt.hellotest.client;

import java.util.logging.Logger;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.FormPanel.SubmitEvent;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DatePicker;

public class Home implements EntryPoint {
	Logger logger = Logger.getLogger("ConsoleLogger");
	
	///// These Strings should be in a localization file /////
	private static String fullName = "Anthony R. Garcia";
	private static String hobby1 = "Programming";
	private static String hobby1Img = "http://www.lackuna.com/wp-content/uploads/2013/01/programming.jpg";
	private static String hobby1Desc = "My favorite thing is to program. Usually I program in Python.";
	private static String hobby2 = "Custom PCs";
	private static String hobby2Img = "http://chaoscomputing.net/images/custom_bg.png";
	private static String hobby2Desc = "I also enjoy building custom PCs. I recently built my own.";
	private static String formName = "Name:";
	private static String formDate = "Start Date:";
	///// END localization "file" /////

	private TabPanel tp = new TabPanel();
	private FormPanel form = new FormPanel();
	private TextBox tb = new TextBox();
	private DatePicker dp = new DatePicker();

	@Override
	public void onModuleLoad() {
		
		Label nameLabel = new Label(fullName);
		RootPanel.get().add(nameLabel);
		
		HorizontalPanel frame0 = new HorizontalPanel();
		
		frame0.add(constructHobbyPanel(hobby1, hobby1Img, hobby1Desc));
		
		frame0.add(constructHobbyPanel(hobby2, hobby2Img, hobby2Desc));
		
		VerticalPanel frame1 = new VerticalPanel();
		//this widget should be centered vertically and horizontally
		frame1.add(constructHobbyPanel(hobby1, hobby1Img, hobby1Desc));

		
		///// Couldn't get the site to work with this code below. /////
		
		/*form.add(new Label(hobby2));
		VerticalPanel formCols = new VerticalPanel();
		
		HorizontalPanel row1 = new HorizontalPanel();
		row1.add(new Label(formName));
		tb.setName("form-name");
		row1.add(tb);
		formCols.add(row1);
		
		HorizontalPanel row2 = new HorizontalPanel();
		row2.add(new Label(formDate));
		row2.add(dp);
		formCols.add(row2);

		/*formCols.add(new Button("Submit", new ClickHandler() {
			public void onClick(ClickEvent event) {
				form.submit();
			}
		}));
		
		form.addSubmitHandler(new FormPanel.SubmitHandler() {
			public void onSubmit(SubmitEvent event) {
				if (tb.getText().length() == 0) {
					Window.alert("Please enter your name.");
					event.cancel();
				}
				if(dp.getHighlightedDate()==null){
					Window.alert("Please select a date.");
					event.cancel();
				}
				//send to Logger
				logger.log("Name:" + tb.getText() + " - Date:" + dp.getHighlightedDate().toString());
			}
		});
		
		form.add(formCols);*/
		
		tp.add(frame0, "  Home  "); //add the home frame
		tp.add(frame1, "  " + hobby1 + "  "); //add hobby1 frame
		tp.add(form, "  " + hobby2 + "  "); //add hobby2 frame (the form)
		
		tp.selectTab(0);
		RootPanel.get().add(tp);
	}
	
	/*This method creates a VerticalPanel of the hobby and description given.
	 * @arg0	the name of the hobby
	 * @arg1	the description of the hobby
	 * @return	the complete VerticalPanel
	 */
	private Widget constructDescriptionPanel(String hobbyName, String hobbyDescription){
		VerticalPanel description = new VerticalPanel();
		Label title = new Label(hobbyName);
		//Somehow set title as a hyperlink to cause tp.selectTab(1) or tp.selectTab(2)
		description.add(title);
		description.add(new Label(hobbyDescription));
		return description;
	}
	
	/*This method creates a full hobby HorizontalPanel, with an image.
	 * arg0		the name of the hobby
	 * arg1 	the URL of the image of the hobby
	 * arg2 	the description of the hobby
	 * return	the complete HorizontalPanel
	 */
	private Widget constructHobbyPanel(String hobbyName, String hobbyImage, String hobbyDescription){
		HorizontalPanel hobbyPanel = new HorizontalPanel();
		hobbyPanel.setTitle(hobbyName);
		Image image = new Image();
		image.setUrl(hobbyImage);
		image.setHeight("200px");
		image.setWidth("200px");
		hobbyPanel.add(image);
		hobbyPanel.add(constructDescriptionPanel(hobbyName, hobbyDescription));
		return hobbyPanel;
	}
}
