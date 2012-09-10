package demo

import grails.converters.JSON

class ContentController {

	def list() {
		render Content.list() as JSON
	}
	
	def show() {
		render Content.get(params.id) as JSON 
	}
	
	def create() {
		Content c = new Content(params)
		c.save(flush: true)
		render c as JSON
	}
}
