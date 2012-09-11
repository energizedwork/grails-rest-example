package demo

import groovyx.net.http.RESTClient
import spock.lang.Specification
import support.TestUtil

class ContentApiSpec extends Specification {
	
	RESTClient client = new RESTClientFactory().client	
	
	def setup() {
		TestUtil.nuke()	
	}

	def "Retrieves the given content"() {
		
		given:
			Content c = new Content(title: 'Batman').save(flush:true)
		
		when:
			def response = client.get(uri: "http://localhost:8080/api/content/$c.id")
		
		then:
			response.status == 200
			response.data.title == 'Batman'		
			response.data.id == "content/$c.id"	
	}
	
	def "Creates content"() {
		
		given:
			Map params = [title: 'Robin']
		
		when:
			def response = client.post(uri: 'http://localhost:8080/api/content', body: params)
		
		then:
			response.status == 200
			response.data.title == 'Robin'		
			response.data.id =~ 'content/\\d+'	
	}
	
	def "Deletes content"() {
		
		given:
			Content c = new Content(title: 'Joker').save(flush:true)		
		
		when:
			def response = client.delete(uri: "http://localhost:8080/api/content/$c.id")
		
		then:
			response.status == 204
			Content.count() == 0
	}
	
}
