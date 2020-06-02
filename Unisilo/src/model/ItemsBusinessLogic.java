package model;

/**----------------------------------------------------------------------*
 *■■■BusinessLogicクラス■■■
 *概要：ビジネスロジック（データの登録）
 *----------------------------------------------------------------------**/
public class ItemsBusinessLogic {

	private ItemsDao dao = new ItemsDao();

	public boolean executeItems(ItemsDto dto) {

		boolean   succesInsert = false ;  //DB操作成功フラグ（true:成功/false:失敗）

		succesInsert = dao.doInsert(dto);

		return succesInsert;
	}

}