package steps

import pages.ContentPage

this.metaClass.mixin(cucumber.runtime.groovy.EN)

When(~'(?:\\w+) opens the content page') { ->
	to ContentPage
	at ContentPage
}

Then(~'display all items of content') { ->
	page.items.size() == allContent.size()
}