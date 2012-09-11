package demo

import grails.converters.JSON

class JobController {
	
	JenkinsServer jenkinsServer
	
	def list() {
		
		List jobs = jenkinsServer.getJobs(params.url)
		render jobs as JSON
		
	}
	
}
