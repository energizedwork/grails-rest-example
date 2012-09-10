package support

import demo.Content

class RemoteContentRepository {

	List createRandomContent(int n) {
		List results = []
		n.times {
			results << new Content(title: "content-$n").save(flush:true)
			results
		}
	}
	
}
