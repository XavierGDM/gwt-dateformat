package be.steformations.xb.client.http.rpc;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

import be.steformations.xb.client.DateFormatterController;
import be.steformations.xb.client.http.beans.DateResult;

public class DateFormatRpcDateResultCallback implements AsyncCallback<DateResult>{

	private DateFormatterController controller;
	
	public DateFormatRpcDateResultCallback(DateFormatterController controller) {
		super();
		this.controller = controller;
	}
	
	@Override
	public void onFailure(Throwable caught) {
		Window.alert(caught.getMessage());
		
	}

	@Override
	public void onSuccess(DateResult result) {
		GWT.log("DateFormatRpcDateResultCallback.onSuccess()");
		this.controller.setDateResult(result);
	}

	
}
