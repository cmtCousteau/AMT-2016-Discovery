$(function() {
	function loadLocations(){
		$.getJSON("/api/locations/", function(locations){
			(locations);
			var message = "nobody is here";
			if( locations.length > 0 ) {
				message = locations[0].country;
				console.log(message);
			}
			$(".locations").text(message);
		});
	};
	
	loadLocations();
	setInterval(loadLocations, 2000);
	
});