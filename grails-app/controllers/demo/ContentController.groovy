package demo

import javax.servlet.http.HttpServletResponse

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
		c.save(flush:true)
		render c as JSON
	}
	
	def update() {
		Content c = Content.get(params.id)
		c.properties = params
		c.save(fluah:true)
		render c as JSON
	}
	
	def delete() {
		Content.get(params.id)?.delete()
		render(status: HttpServletResponse.SC_NO_CONTENT)
	}
}
