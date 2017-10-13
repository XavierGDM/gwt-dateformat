package be.steformations.xb.client.http.rpc;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

import be.steformations.xb.client.DateFormatterController;

public class DateFormatRpcStringCallback implements AsyncCallback<String> {

	private DateFormatterController controller;
	
	public DateFormatRpcStringCallback(DateFormatterController controller) {
		super();
		this.controller = controller;
	}
	
	@Override
	public void onFailure(Throwable caught) {
		Window.alert(caught.getMessage());
		
	}

	@Override
	public void onSuccess(String result) {
		GWT.log("DateFormatRpcStringCallback.onSuccess() =>" + result);
		this.controller.setFormattedDate(result);
	}

}
