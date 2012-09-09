package demo

import org.junit.Rule

import betamax.Betamax
import betamax.Recorder
import grails.plugin.spock.UnitSpec


class JenkinsServerSpec extends UnitSpec {

	@Rule Recorder recorder = new Recorder()
	
	@Betamax(tape="jobs")	
	def "Retrieves jobs from remote Jenkins server"() {
		
		given:
			JenkinsServer jenkinsServer = new JenkinsServer()
		
		when:
			List jobs = jenkinsServer.getJobs(
				'http://build.acuminous.meh:8080/api/json')
		
		then:
			jobs.size() == 6
	}
	
}
