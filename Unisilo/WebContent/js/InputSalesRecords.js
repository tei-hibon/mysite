/**
 *
 */
function checkNull() {


	if(InputSalesRecords.purchasedAt.value == "")  {
		alert ("エラー：購入日を入力してください")
		return false;
    } else {
        return true;
        }
}