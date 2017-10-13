package be.steformations.xb.client;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.user.client.Window;

import be.steformations.xb.client.http.beans.DateParams;
import be.steformations.xb.client.http.beans.DateResult;
import be.steformations.xb.client.http.json.DateFormatJsonDateResultCallback;
import be.steformations.xb.client.http.json.DateParamsObjectMapper;
import be.steformations.xb.client.http.rpc.DateFormatRpcDateResultCallback;
import be.steformations.xb.client.http.rpc.DateFormatRpcService;
import be.steformations.xb.client.http.rpc.DateFormatRpcServiceAsync;
import be.steformations.xb.client.http.rpc.DateFormatRpcStringCallback;
import be.steformations.xb.client.http.standard.LocalesRequestCallback;
import be.steformations.xb.client.ui.DateFormatterUI;

public class DateFormatterController implements ClickHandler{

	private DateFormatterUI ui;
	
	public DateFormatterController(DateFormatterUI ui) {
		super();
		this.ui = ui;
		this.ui.getFormatEventSource().addClickHandler(this);
		this.getAvailableLocales();
	}
	
	@Override
	public void onClick(ClickEvent event) {
		GWT.log("DateFormatterController.onClick()");
		DateParams params = new DateParams();
		params.setDay(Integer.parseInt(this.ui.getDayInput().getValue()));
		params.setMonth(Integer.parseInt(this.ui.getMonthInput().getValue()));
		params.setYear(this.ui.getYearInput().getValue());
		params.setLocale(this.ui.getLocaleInput().getValue());
		GWT.log(params.toString());
		
		//this.formatDateRpc(params);
//		this.formatDateToObjectRpc(params);
		this.formatDatetoObjectJson(params);
		
	}
	
	private void formatDatetoObjectJson(DateParams params){
		GWT.log("DateFormatterController.formatDatetoObjectJson()");
		DateParamsObjectMapper mapper = GWT.create(DateParamsObjectMapper.class);
		String json = mapper.write(params);
		GWT.log(json);
		RequestBuilder builder = new RequestBuilder(RequestBuilder.POST, "http://127.0.0.1:8888/json/service");
		RequestCallback callback = new DateFormatJsonDateResultCallback(this);
		builder.setCallback(callback);
		builder.setRequestData(json);
		
		try {
			builder.send();
		} catch (Exception e) {
		Window.alert(e.getMessage());
		}
	}
	
	public void setFormattedDate(String s){
		GWT.log("DateFormatterController.setFormattedDate() => " + s);
		this.ui.getOutput().setText(s);
	}
	
	public void setDateResult(DateResult result){
		GWT.log("DateFormatterController.setDateResult() =>" + result.toString());
		this.ui.getOutput().setText(result.getFormattedDate());
	}
	
	private void formatDateToObjectRpc(DateParams params){
		GWT.log("DateFormatterController.formatDateToObjectRpc()");
		DateFormatRpcServiceAsync service = GWT.create(DateFormatRpcService.class);
		DateFormatRpcDateResultCallback callback = new DateFormatRpcDateResultCallback(this);
		service.formatToObject(params, callback);
	}
	
	@SuppressWarnings("unused")
	private void formatDateRpc(DateParams params){
		GWT.log("DateFormatterController.formatDateRpc()");
		DateFormatRpcServiceAsync service = GWT.create(DateFormatRpcService.class);
		DateFormatRpcStringCallback callback = new DateFormatRpcStringCallback(this);
		service.format(params, callback);//appel http
	}
	
	private void getAvailableLocales(){
		GWT.log("DateFormatterController.getAvailableLocales()");
		String url = "http://127.0.0.1:8888/available/locales";
		RequestBuilder rb = new RequestBuilder(RequestBuilder.GET, url);
		LocalesRequestCallback callback = new LocalesRequestCallback(this);
		rb.setCallback(callback);
		try {
			rb.send(); //get http
		} catch (Exception e) {
			Window.alert(e.getMessage());
		}
	}

	public void setAvailableLocales(String[] locales) {
		GWT.log("DateFormatterController.setAvailableLocales()");
		this.ui.setLocales(locales);
		
	}

}
