import betamax.Recorder
import demo.JenkinsServer

beans = {
	
	jenkinsServer(JenkinsServer)
	
	recorder(Recorder) {
		proxyPort = 5556
	}
}
