/**
 *
 */
function checkText() {
	var name = document.myForm.name.value;

	if(!name) {
		alert('エラー：顧客名を入力してください');
		return false;
	}

	var age= document.myForm.age.value;

	if(age>200){
		alert('エラー：正しい年齢を入力してください');
		return false;
	  }
}