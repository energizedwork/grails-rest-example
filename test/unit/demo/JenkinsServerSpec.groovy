package demo

import betamax.Betamax

import betamax.Recorder
import grails.plugin.spock.UnitSpec
import org.junit.Rule


class JenkinsServerSpec extends UnitSpec {
	
	@Rule Recorder recorder = new Recorder()
	
	@Betamax(tape="jobs")
	def "Retreives jobs from remote Jenkins server"() {
		
		given:
			JenkinsServer jenkinsServer = new JenkinsServer()
		
		when:
			List jobs = jenkinsServer.getJobs('http://build.acuminous.meh:8080')
		
		then:
			jobs.size() == 6
	}
	
}
