package demo

import grails.converters.JSON

class JobController {

	JenkinsServer jenkinsServer
	
	def list() {
		List results = jenkinsServer.getJobs(params.url)
		render results as JSON
	}
	
}
