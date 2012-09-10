var ContentApi = function(baseUrl) {
	
	this.baseUrl = baseUrl;
	
	this.list = function(onSuccess) {
		var url = this.baseUrl + '/content';
		
		$.ajax(url, {
			type: 'GET',
			success: onSuccess
		})
	}
	
}