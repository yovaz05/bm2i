/**
 * 
 */
function noEnter(event) {
	// alert("el codigo es "+event.keyCode);
	var keyCode = event.keyCode ? event.keyCode : event.which ? event.which
			: event.charCode;
	if (keyCode == 13) {
		return false;
	} else {
		return true;
	}
}