package demo

import groovyx.net.http.RESTClient
import spock.lang.Specification
import support.BetamaxUtil

class JobApiSpec extends Specification {
		
	RESTClient client = new RESTClientFactory().client
	
	def "Retrieves a list of jobs"() {
		
		given:
			Map params = [url: 'http://build.acuminous.meh:8080']
		
		when:
			def response = BetamaxUtil.withRemoteTape('jobs', [:]) {
				client.get(uri: 'http://localhost:8080/api/job', query: params)
			}
		
		then:
			response.status == 200
			response.data.size() == 6
	}
	
}
