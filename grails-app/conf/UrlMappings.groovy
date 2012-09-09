class UrlMappings {

	static mappings = {

		// "/api/content/$id?"(resource: "content")
		
		"/api/$controller/$id" {
			action = [GET: "show"]
		}
		
		"/api/$controller" {
			action = [GET: "list", POST: "create"]
		}
		
		"/"(view:"/index")
		"500"(view:'/error')
	}
}
