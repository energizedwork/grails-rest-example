var ContentApi = function(baseUrl) {
	
	this.baseUrl = baseUrl;
		
	this.list = function(onSuccess) {
		
		var url = this.baseUrl + '/content';
		
		$.ajax(url, {
			type: 'GET',
			success: onSuccess
		})		
	}
	
	this.get = function(resourceId, onSuccess) {
		
		var url = this.baseUrl + '/' + resourceId;
		
		$.ajax(url, {
			type: 'GET',
			success: onSuccess
		})
	}
	
	this.create = function(content, onSuccess) {
		
		var url = this.baseUrl + '/content';
						
		$.ajax(url, {
			type: 'POST',
			data: { 
				title: content.title
			},
			success: onSuccess
		});			
	}
	
	this.update = function(content, onSuccess) {
		
		var url = this.baseUrl + '/' + content.resourceId;
				
		$.ajax(url, {
			type: 'PUT',
			data: { 
				title: content.title
			},
			success: onSuccess
		});	
	}
	
	this.erase = function(resourceId) {
		
		var url = this.baseUrl + '/' + resourceId;
		
		$.ajax(url, { 
			type: 'DELETE' 
		})
	}
}