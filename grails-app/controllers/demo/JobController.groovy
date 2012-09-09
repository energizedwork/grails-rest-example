package demo

import grails.converters.JSON

class JobController {

	JenkinsServer jenkinsServer
	
	def list() {
		render jenkinsServer.getJobs(params.url) as JSON
	}
}
