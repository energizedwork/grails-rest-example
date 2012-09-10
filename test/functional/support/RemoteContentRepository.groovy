package support

import demo.Content

class RemoteContentRepository {

	List createRandomContent(int n) {
		n.times.collect {
			new Content(title: "content-$it").save(flush:true)
		}
	}
	
}
