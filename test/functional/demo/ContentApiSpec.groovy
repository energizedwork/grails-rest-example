package demo

import groovyx.net.http.RESTClient
import spock.lang.Specification
import support.RemoteControlUtil

class ContentApiSpec extends Specification {
	
	List allContent
	RESTClient client = new RESTClientFactory().createClient()
		
	def setup () {
				
		RemoteControlUtil.nuke()
		allContent = RemoteControlUtil.exec {
			3.times { 
				Content c = new Content(title: "content-$it")
				c.save(flush:true, failOnError: true)
			}
			Content.list()
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
			response.data.title == c.title
	}
	
	def "Creates content"() {
	
		given:
			Map params = [title: 'Foo']
			
		when:
			def response = client.post(uri: 'http://localhost:8080/api/content', body: params)
			
		then:
			response.status == 200
			response.data.id =~ /content\/\d+/
			response.data.title == 'Foo'
			
	}

	
}
