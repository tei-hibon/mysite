/**
 *
 */
function checkText() {
	var name = document.myForm.name.value;

	if(!name) {
		alert('エラー：顧客名を入力してください');
		return false;
	}
}