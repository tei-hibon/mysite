package model;

/**----------------------------------------------------------------------*
 *■■AnalysisDtoクラス■■■
 *概要：DTO
 *----------------------------------------------------------------------**/
public class AnalysisDto {

	//----------------------------------------------------------------
	//フィールド
	//----------------------------------------------------------------
	private String   date1 ;
	private String   date2 ;
	private String   item_name ;
	private String   userGender ;
    private String   userAge ;



	//----------------------------------------------------------------
	//getter/setter
	//----------------------------------------------------------------

	//getter/setter（対象フィールド：item_id）
	public String getDate1() { return date1; }
	public void setDate1(String date1) { this.date1 = date1; }

	//getter/setter（対象フィールド：user_id）
	public String getDate2() { return date2; }
	public void setDate2(String Date) { this.date2 =Date ; }

	//getter/setter（対象フィールド：purchased_at）
	public String getItem_name() { return  item_name; }
	public void setItem_namet(String item_name ) { this.item_name =  item_name; }

    //getter/setter（対象フィールド：item_id）
	public String getUserGender() { return userGender; }
	public void setUserGender(String userGender) { this.userGender = userGender; }

	//getter/setter（対象フィールド：item_id）
	public String getUserAge() { return userAge; }
	public void setUserAge(String userAge) { this.userAge = userAge; }


}
