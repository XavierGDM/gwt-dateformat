package be.steformations.xb.server;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.steformations.xb.client.http.beans.DateParams;
import be.steformations.xb.client.http.beans.DateResult;

@SuppressWarnings("serial")
@WebServlet(urlPatterns="/json/service") // equivalent a la declaration dans web.xml
public class DateFormatJsonService extends HttpServlet {

	private Calendar calendar = GregorianCalendar.getInstance();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("DateFormatJsonService.doPost()");
		com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
		
		java.io.InputStream ips = req.getInputStream();
		DateParams params = mapper.readerFor(DateParams.class).readValue(ips);
		System.out.println(params);
		
		calendar.set(Calendar.DAY_OF_MONTH, params.getDay());
		calendar.set(Calendar.MONTH, params.getMonth() - 1);
		calendar.set(Calendar.YEAR, params.getYear());
		DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, new Locale(params.getLocale()));
		String formatted = df.format(calendar.getTime());
		DateResult result = new DateResult();
		result.setDate(calendar.getTime());
		result.setFormattedDate(formatted);
		
		String json = mapper.writeValueAsString(result);
		System.out.println(json);
		
		resp.setContentType("application/json");
		resp.getWriter().write(json);
	}

	
	
}
