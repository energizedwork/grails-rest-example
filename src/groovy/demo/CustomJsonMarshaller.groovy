package demo

class CustomJsonMarshaller {

	static contentMarshaller = { Content content ->
		marshall {
			[id: content.resourceId, title: content.title]
		}
	}
	
	static jobMarshaller = { Job job ->
		marshall {
			[id: job.resourceId, name: job.name, url: job.url]
		}
	}
	
	static marshall(def marshaller) {
		try {
			marshaller()
		} catch (Exception e) {
			e.message
		}
	}
	
}
