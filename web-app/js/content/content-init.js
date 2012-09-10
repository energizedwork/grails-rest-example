$(document).ready(function() {			
	
	var baseUrl = $('base').attr('href') + '/api';	
	var dataSource = new ContentApi(baseUrl);
	
	var tableElement = $('#contentTable');
	var contentTable = new ContentTable(tableElement, dataSource);
	
	contentTable.render();
});