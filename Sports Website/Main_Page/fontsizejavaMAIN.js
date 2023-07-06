
//This is the java script file for increasing and decreasing the font size.
//I have assigned id to the div tag, so it can change the repective texts inside tag.

function size_font(){
	let optionSize = document.getElementById('option-size');
		
		document.getElementById("menuhead").style.fontSize = optionSize.value + 'px';
		
}
