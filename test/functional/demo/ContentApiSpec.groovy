package demo

import groovyx.net.http.RESTClient
import spock.lang.Specification
import support.TestUtil

class ContentApiSpec extends Specification {
	
	List allContent = []
	RESTClient client
	
	def setup() {
		client = new RESTClientFactory().client
		
		TestUtil.nuke()
				
		3.times {
			Content c = new Content(title: "content-$it")
			allContent << c.save(flush:true)
		}			
		
	}

	def "Retrieves a list of content"() {
		
		when:
			def response = client.get(uri: 'http://localhost:8080/api/content')
		
		then:
			response.status == 200
			response.data.size() == 3		
	}
	
	def "Retrieves the given content"() {
		
		given:
			Content c = allContent[1]
		
		when:
			def response = client.get(uri: "http://localhost:8080/api/content/$c.id")
		
		then:
			response.status == 200
			response.data.title == 'content-1'
	}
	
	def "Creates content"() {
		
		given:
			Map params = [title: 'Batman']
			
		when:
			def response = client.post(uri: 'http://localhost:8080/api/content', body: params)
			
		then:
			response.status == 200
			response.data.title == 'Batman'
			response.data.id =~ /content\/\d+/		
	}
	
}
