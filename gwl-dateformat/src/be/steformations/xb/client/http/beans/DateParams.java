package be.steformations.xb.client.http.beans;

import java.io.Serializable;
@SuppressWarnings("serial")
public class DateParams implements Serializable {
	/* Serializable nécessaire pour RPC */
	
	private int day;
	private int month;
	private int year;
	private String locale;
	
	// necessaire pour RPC et JSON
	public DateParams() {
		super();
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	@Override
	public String toString() {
		return "DateParams [day=" + day + ", month=" + month + ", year=" + year + ", locale=" + locale + "]";
	}
	
	
}
