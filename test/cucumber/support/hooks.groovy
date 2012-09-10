package support

import geb.binding.BindingUpdater
import geb.Browser

this.metaClass.mixin (cucumber.runtime.groovy.Hooks)

def bindingUpdater

Before () {
	TestUtil.nuke()
	
	BetamaxUtil.startProxy('cucumber', [:])
	
	bindingUpdater = new BindingUpdater (binding, new Browser())
	bindingUpdater.initialize()
}

After () {
	bindingUpdater.remove()
	
	BetamaxUtil.stopProxy()
}