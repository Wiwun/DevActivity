$(document).ready(function() {

	g_disableClientSideValidation = false;

	errorParagraph = $('#inputErrors');
	errorParagraph.hide();
	//("change",postResult);
	getInputArray()
	refreshResult();

});

function getInputArray() {
	$.ajax({
		url : "/rest/inputArray.json"
	}).then(function(data) {
		$('#inputArray').val(data);
	});
}

function postInputArray(pInputValue) {
	console.log("postInputArray()");

	var isValid = validateArray();
	if (isValid == false) {
		return;
	}

	inputStr = ""+ $('#inputArray').val();
	var integerArray = inputStr.split(',');

	console.log(integerArray);
	$.ajax({
		dataType : "json",
		url : "/rest/inputArray.json",
		headers : {
			'Accept' : 'application/json',
			'Content-Type' : 'application/json'
		},
		data : JSON.stringify(integerArray),
		type : 'POST',
		success : function() {
			changeErrorText("Save Successfull", false);
			refreshResult();
		},
		error : function(jqXHR, textStatus, errorThrown) {
			console.log(errorThrown);
			var vndError = jqXHR.responseJSON;
			console.log( vndError[0].message);
			changeErrorText("Server validation failed: " + vndError[0].logref + "\n See javascript console for details", true);
		}
	});

}

function toogleDisableClientSideValidation() {
	if (this.g_disableClientSideValidation == false) {
		this.g_disableClientSideValidation = true;
	} else {
		this.g_disableClientSideValidation = false;
	}
}

function validateArray() {
	console.log("validateArray(" + inputArray + ")");
	
	inputArray = $('#inputArray').val();
	var validateRegEx = /^[-\d]+(,[-\d]*)*$/;
	var isValid = validateRegEx.test(inputArray);


	if (isValid == false) {
		if (g_disableClientSideValidation == true) {
			changeErrorText("Warning: client side validation disabled", true);
			return true;
		}
		changeErrorText("please enter a valid input.", true);
		return false;
	}

	changeErrorText("Thank you", false);
	return true;
}

function changeErrorText(errorText, showError) {
	errorParagraph = $('#inputErrors');

	errorParagraph.text(errorText);

	if (showError == true) {
		errorParagraph.show('slow');
	} else {
		errorParagraph.hide('slow');
	}
}

function refreshResult() {
	console.log("refreshResult()");

	$.ajax({
		dataType : "json",
		url : "/rest/result.json",
		headers : {
			'Accept' : 'application/json',
			'Content-Type' : 'application/json'
		},
		type : 'GET',
		success : function(data) {
			console.log("data");
			$('#result-value').text(data);

		},
		error : function(jqXHR, textStatus, errorThrown) {
			console.log(errorThrown);
			var vndError = jqXHR.responseJSON;
			$('#result-value').text(vndError[0].message);
		}
	});

}