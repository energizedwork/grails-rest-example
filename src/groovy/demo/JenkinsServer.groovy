package demo

import groovyx.net.http.RESTClient

class JenkinsServer {

	List getJobs(String url) {
		RESTClient client = new RESTClientFactory().client
		def response = client.get(uri: url + '/api/json')
		response.data.jobs.collect {
			new Job(name: it.name, url: it.url)
		}
	}
	
}
