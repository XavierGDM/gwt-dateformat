package be.steformations.xb.server;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;


import be.steformations.xb.client.http.beans.DateParams;
import be.steformations.xb.client.http.beans.DateResult;
import be.steformations.xb.client.http.rpc.DateFormatRpcService;

@SuppressWarnings("serial")
public class DateFormatRpcServiceImpl extends RemoteServiceServlet //extension de HTTPServlet
									implements DateFormatRpcService {
	
	private Calendar calendar = java.util.GregorianCalendar.getInstance();
	
	@Override
	public String format(DateParams params) {
		System.out.println("DateFormatRpcServiceImpl.format()");
		calendar.set(Calendar.DAY_OF_MONTH, params.getDay());
		calendar.set(Calendar.MONTH, params.getMonth() - 1);
		calendar.set(Calendar.YEAR, params.getYear());
		DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, new Locale(params.getLocale()));
		String formatted = df.format(calendar.getTime());
		System.out.println(formatted);
		return formatted;
	}

	@Override
	public DateResult formatToObject(DateParams params) {
		System.out.println("DateFormatRpcServiceImpl.formatToObject()");
		calendar.set(Calendar.DAY_OF_MONTH, params.getDay());
		calendar.set(Calendar.MONTH, params.getMonth() - 1);
		calendar.set(Calendar.YEAR, params.getYear());
		DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, new Locale(params.getLocale()));
		String formatted = df.format(calendar.getTime());
		DateResult result = new DateResult();
		result.setDate(calendar.getTime());
		result.setFormattedDate(formatted);
		return result;
	}
	
	

}
