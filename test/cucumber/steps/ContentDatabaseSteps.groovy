package steps

import demo.Content

this.metaClass.mixin(cucumber.runtime.groovy.EN)

allContent = []

Given(~'that there are (\\d+) items of content') { int n ->
	n.times {
		allContent << new Content(title: "content-$it").save(flush:true)
	}
}