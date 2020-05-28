/**
 *
 */
function checkText() {
	var name = document.myForm.name.value;

	if(!name) {
		alert('名前が空白です');
		return false;
	}
}