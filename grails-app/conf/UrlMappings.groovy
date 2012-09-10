class UrlMappings {

	static mappings = {

		"/"(controller: 'UserInterface')
		
		"/$action"(controller: 'UserInterface') {
			constraints {
				action(in: ['content'])
			}
		}

		
		// "/api/content/$id?"(resource: "content")
		
		"/api/$controller/$id" {
			action = [GET: "show"]
		}
		
		"/api/$controller" {
			action = [GET: "list", POST: "create"]
		}
				
		"500"(view:'/error')
	}
}
