import grails.converters.JSON
import demo.Content
import demo.CustomJsonMarshaller

class BootStrap {

    def init = { servletContext ->
		JSON.registerObjectMarshaller(Content, CustomJsonMarshaller.contentMarshaller)
		
    }
	
    def destroy = {
    }
}
