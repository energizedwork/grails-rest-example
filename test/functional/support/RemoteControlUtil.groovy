package support


import demo.Content
import grails.plugin.remotecontrol.RemoteControl;
import groovy.lang.Closure;

class RemoteControlUtil {
		
	static void nuke() {
		exec {
			Content.list()*.delete(flush:true)
		}
	}
	
	static exec(Closure closure) {
		remoteControl.exec(closure)
	}
	
	static RemoteControl getRemoteControl() {
		new RemoteControl(useNullIfResultWasUnserializable: true)		
	}
}
