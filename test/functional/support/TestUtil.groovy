package support

import demo.Content
import demo.Job

class TestUtil {

	static void nuke() {
		Content.list()*.delete(flush:true)
		Job.list()*.delete(flush:true)
	}
	
}
