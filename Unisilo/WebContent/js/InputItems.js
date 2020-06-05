/**
 *
 */
function checkNull() {
	if (InsertItems.name.value == "") { // 「商品名」の入力をチェック
		alert ("エラー：商品名を入力してください")
		return false; // 送信を中止
    } else {
        return true; // 送信を実行
    }
}

