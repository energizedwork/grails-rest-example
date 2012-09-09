import demo.Content
import demo.Job
import demo.CustomJsonMarshaller
import grails.converters.JSON

class BootStrap {

    def init = { servletContext ->
		
		JSON.registerObjectMarshaller(Content, CustomJsonMarshaller.contentMarshaller)
		JSON.registerObjectMarshaller(Job, CustomJsonMarshaller.jobMarshaller)
		
    }
	
    def destroy = {
    }
}
