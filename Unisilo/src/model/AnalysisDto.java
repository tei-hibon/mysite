package model;

/**----------------------------------------------------------------------*
 *■■AnalysisDtoクラス■■■
 *概要：DTO
 *----------------------------------------------------------------------**/
public class AnalysisDto {

	//----------------------------------------------------------------
	//フィールド
	//----------------------------------------------------------------
	private String   dateStart ;
	private String   dateEnd ;
	private String   name ;
	private String   userGender ;
    private String   userAge ;
    int age1 = 0;
    int age2 = 0;

	//----------------------------------------------------------------
	//getter/setter
	//----------------------------------------------------------------

	//getter/setter（対象フィールド：item_id）
	public String getDateStart() { return dateStart; }
	public void setDateStart(String dateStart) { this.dateStart = dateStart; }

	//getter/setter（対象フィールド：user_id）
	public String getDateEnd() { return dateEnd; }
	public void setDateEnd(String dateEnd) { this.dateEnd =dateEnd ; }

	//getter/setter（対象フィールド：purchased_at）
	public String getName() { return  name; }
	public void setName(String name ) { this.name =  name; }

    //getter/setter（対象フィールド：item_id）
	public String getUserGender() { return userGender; }
	public void setUserGender(String userGender) { this.userGender = userGender; }

	//getter/setter（対象フィールド：item_id）
	public String getUserAge() { return userAge; }
	public void setUserAge(String userAge) { this.userAge = userAge; }

	public void checkAge() {
		 //age1, afe2設定
		 switch(userAge) {
		   case "1":
		 	 age1=10;
		 	 age2=19;
		 	 break;
		   case "2":
		 	 age1=20;
		 	 age2=29;
		 	 break;
		   case "3":
		 	 age1=30;
		 	 age2=39;
		 	 break;
		   case "4":
		 	 age1=40;
		 	 age2=200;
		 	 break;
		 }
	}


}


