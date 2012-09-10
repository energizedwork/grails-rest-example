package pages

import geb.Page

class ContentPage extends Page {

	static url = "/content"
	
	static at = {
		title ==~ /Content/
	}
	
	static content = {
		items(required: false) { $('#contentTable tbody').not('.prototype').find('tr') }
	}
	
}
