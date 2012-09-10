package support

import demo.Content
import demo.Job
import grails.plugin.remotecontrol.RemoteControl


class RemoteControlUtil {
		
	static void nuke() {
		exec {
			Content.list()*.delete(flush:true)
			Job.list()*.delete(flush:true)
		}
	}
	
	static exec(Closure closure) {
		remoteControl.exec(closure)
	}
	
	static RemoteControl getRemoteControl() {
		new RemoteControl(useNullIfResultWasUnserializable: true)		
	}
}
