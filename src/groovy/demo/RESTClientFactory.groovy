package demo

import groovyx.net.http.ContentType
import groovyx.net.http.HTTPBuilder;
import groovyx.net.http.RESTClient
import org.apache.http.conn.routing.HttpRoutePlanner
import org.apache.http.impl.conn.ProxySelectorRoutePlanner

class RESTClientFactory {

	RESTClient client
	
	RESTClient createClient() {
		client = new RESTClient()
		defaultToUrlEncoding()
		enableProxyConfiguration()
		client
	}
	
	void defaultToUrlEncoding() {
		client.defaultRequestContentType = ContentType.URLENC		
	}
	
	void enableProxyConfiguration() {
		HttpRoutePlanner routePlanner = new ProxySelectorRoutePlanner(
			client.client.connectionManager.schemeRegistry,
			ProxySelector.default
		)
		client.client.routePlanner = routePlanner		
	}
}
