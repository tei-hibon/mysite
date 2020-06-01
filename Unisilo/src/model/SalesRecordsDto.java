package model;

/**----------------------------------------------------------------------*
 *■■■Sales_recordsDtoクラス■■■
 *概要：DTO
 *----------------------------------------------------------------------**/
public class SalesRecordsDto {

	//----------------------------------------------------------------
	//フィールド
	//----------------------------------------------------------------
	private int    item_id ;                //商品名
	private int     user_id ;               //購入者名
	private String   purchased_at ;            //購入日


	//----------------------------------------------------------------
	//getter/setter
	//----------------------------------------------------------------

	//getter/setter（対象フィールド：item_id）
	public int getItem_id() { return item_id; }
	public void setItem_id(int item_id) { this.item_id = item_id; }

	//getter/setter（対象フィールド：user_id）
	public int getUser_id() { return user_id; }
	public void setUser_id(int user_id) { this.user_id = user_id; }

	//getter/setter（対象フィールド：purchased_at）
	public String getPurchased_at() { return  purchased_at; }
	public void setPurchased_at(String purchased_at) { this. purchased_at =  purchased_at; }



}
