package be.steformations.xb.client.http.standard;

import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Window;

import be.steformations.xb.client.DateFormatterController;

public class LocalesRequestCallback implements RequestCallback{

	private DateFormatterController controller;
	
	public LocalesRequestCallback(DateFormatterController controller) {
		super();
		this.controller = controller;
	}
	
	@Override
	public void onResponseReceived(Request request, Response response) {
		GWT.log("LocalesRequestCallback.onResponseReceived() => " + response.getText());
		String[] locales = response.getText().split(",");
		this.controller.setAvailableLocales(locales);
	}

	@Override
	public void onError(Request request, Throwable exception) {
		Window.alert(exception.getMessage());
	}

	
}
