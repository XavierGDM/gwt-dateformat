package be.steformations.xb.client.ui;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasValue;

public interface DateFormatterUI {

	HasValue<String> getDayInput();
	HasValue<String> getMonthInput();
	HasValue<Integer> getYearInput();
	HasValue<String> getLocaleInput();
	HasClickHandlers getFormatEventSource();
	HasText getOutput();
	void setLocales(String[] locales);
}
