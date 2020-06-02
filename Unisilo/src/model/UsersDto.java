package model;

/**----------------------------------------------------------------------*
 *■■■UsersDtoクラス■■■
 *概要：DTO
 *----------------------------------------------------------------------**/
public class UsersDto {

	//----------------------------------------------------------------
	//フィールド
	//----------------------------------------------------------------
	private String    name ;                //購入者名
	private int     gender ;               //性別
	private int   age ;            //年齢


	//----------------------------------------------------------------
	//getter/setter
	//----------------------------------------------------------------

	//getter/setter（対象フィールド：name）
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	//getter/setter（対象フィールド：gender）
	public int getGender() { return gender; }
	public void setGender(int gender) { this.gender = gender; }

	//getter/setter（対象フィールド：age）
	public int getAge() { return  age; }
	public void setAge(int age) { this. age =  age; }



}

