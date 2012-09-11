class UrlMappings {

	static mappings = {

		"/"(controller: 'UserInterface')
		
		"/$action"(controller: 'UserInterface') {
			constraints {
				action(in: ['content'])
			}
		}
		
		"/api/$controller" {
			action = [GET: "list", POST: "create"]
		}
		
		"/api/$controller/$id" {
			action = [GET: "show", DELETE: "delete"]
		}
		
		"500"(view:'/error')
	}
}
