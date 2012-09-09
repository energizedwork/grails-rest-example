package support

import geb.binding.BindingUpdater
import geb.Browser

this.metaClass.mixin (cucumber.runtime.groovy.Hooks)

def bindingUpdater

Before () {
	RemoteControlUtil.nuke()
	
	bindingUpdater = new BindingUpdater (binding, new Browser())
	bindingUpdater.initialize()
	
	BetamaxUtil.startProxy('cucumber', [:])
}

After () {
	bindingUpdater.remove()
	BetamaxUtil.stopProxy('cucumber', [:])
}