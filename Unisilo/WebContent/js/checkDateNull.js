/**
 *
 */
function checkDateNull() {
	if (document.getElementsByName('purchased_at').value == "" ) { // 「商品名」の入力をチェック
		alert ("エラー：日付を入力してください")
		return false; // 送信を中止
    } else {
        return true; // 送信を実行
    }
}

