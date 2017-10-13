package be.steformations.xb.client.http.beans;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DateResult implements Serializable{
	
	private java.util.Date date;
	private String formattedDate;
	
	public DateResult() {
		super();
	}

	public java.util.Date getDate() {
		return date;
	}

	public void setDate(java.util.Date date) {
		this.date = date;
	}

	public String getFormattedDate() {
		return formattedDate;
	}

	public void setFormattedDate(String formattedDate) {
		this.formattedDate = formattedDate;
	}

	@Override
	public String toString() {
		return "DateResult [date=" + date + ", formattedDate=" + formattedDate + "]";
	}
	
	
	
	
}
