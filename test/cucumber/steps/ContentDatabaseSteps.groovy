package steps

import support.RemoteContentRepository

this.metaClass.mixin(cucumber.runtime.groovy.EN)

RemoteContentRepository repo = new RemoteContentRepository()

Given(~'that there are (\\d+) items of content') { int n ->	
	repo.createRandomContent(n)	
}