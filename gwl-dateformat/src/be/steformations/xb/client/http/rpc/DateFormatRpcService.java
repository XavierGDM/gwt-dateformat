package be.steformations.xb.client.http.rpc;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import be.steformations.xb.client.http.beans.DateParams;
import be.steformations.xb.client.http.beans.DateResult;

// http://127.0.0.1:8888/dateformatter/service  dateformatter = nom du module
@RemoteServiceRelativePath("service")
public interface DateFormatRpcService extends RemoteService{
	
	String format(DateParams params);
	DateResult formatToObject(DateParams params);
}
