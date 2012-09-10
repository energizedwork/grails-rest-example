package demo

class CustomJsonMarshaller {

	static contentMarshaller = { Content content ->
		marshall {
			[id: content.resourceId, title: content.title]
		}
	}
	
	static jobMarshaller = { Job job ->
		
	}
	
	static marshall(def marshaller) {
		try {
			marshaller()
		} catch (Exception e) {
			e.message
		}
	}
	
}
