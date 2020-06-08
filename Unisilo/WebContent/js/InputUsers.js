/**
 *
 */
function checkText() {
	var name = document.myForm.name.value;

	if(!name) {
		alert('エラー：顧客名を入力してください');
		return false;
	}

	if(age>200){
		alert('エラー：正しい年齢を入力してください');
		return false;
	  }
}