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
	private int   itemID ;
	private String[]   userGender ;
    private String   userAge ;
    int age1 = 0;
    int age2 = 0;
    private String calculationResult;

	//----------------------------------------------------------------
	//getter/setter
	//----------------------------------------------------------------


	public String getDateStart() { return dateStart; }
	public void setDateStart(String dateStart) { this.dateStart = dateStart; }

	public String getDateEnd() { return dateEnd; }
	public void setDateEnd(String dateEnd) { this.dateEnd =dateEnd ; }


	public int getItemID() { return  itemID; }
	public void setItemID(int itemID ) { this.itemID =  itemID; }


	public String[] getUserGender() { return userGender; }
	public void setUserGender(String[] userGender) {
		this.userGender = new String[userGender.length];
		for(int i=0 ; i<userGender.length ; i++) {
		this.userGender[i] = userGender[i];
		}
	}


	public String getUserAge() { return userAge; }
	public void setUserAge(String userAge) { this.userAge = userAge; }

	public void checkAge() {
		 //age1, afe2設定
		 switch(this.userAge) {
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

	public String getCalculationResult() { return calculationResult; }
	public void setCalculationResult(String calculationResult ) { this.calculationResult =  calculationResult; }

}


