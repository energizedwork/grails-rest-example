package support

import demo.Content
import demo.Job
import grails.plugin.remotecontrol.RemoteControl


class RemoteControlUtil {
		
	static exec(Closure closure) {
		remoteControl.exec(closure)
	}
	
	static RemoteControl getRemoteControl() {
		new RemoteControl(useNullIfResultWasUnserializable: true)		
	}
}
