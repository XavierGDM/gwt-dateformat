package be.steformations.xb.client.http.rpc;

import com.google.gwt.user.client.rpc.AsyncCallback;

import be.steformations.xb.client.http.beans.DateParams;
import be.steformations.xb.client.http.beans.DateResult;

public interface DateFormatRpcServiceAsync {

	void format(DateParams params, AsyncCallback<String> callback);
	void formatToObject(DateParams params, AsyncCallback<DateResult> callback);

}
