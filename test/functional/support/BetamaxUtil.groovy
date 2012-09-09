package support

import groovy.lang.Closure;

import java.util.Map;

import betamax.Recorder

class BetamaxUtil {

	static withRemoteTape(String tape, Map args = [:], Closure doStuff) {
		
		startProxy(tape, args)
				
		try {
			return doStuff()
		} finally {
			stopProxy()
		}
	}
	
	static startProxy = { String tape, Map args ->
		RemoteControlUtil.exec {
			Recorder recorder = ctx.getBean('recorder')
			recorder.startProxy(tape, args)
		}
	}
	
	static stopProxy = {
		RemoteControlUtil.exec {
			Recorder recorder = ctx.getBean('recorder')
			recorder.stopProxy()
		}
	}
	
}
