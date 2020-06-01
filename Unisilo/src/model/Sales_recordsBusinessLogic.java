package model;


/**----------------------------------------------------------------------*
 *■■■BusinessLogicクラス■■■
 *概要：ビジネスロジック（データの登録）
 *----------------------------------------------------------------------**/
public class Sales_recordsBusinessLogic {

	/**----------------------------------------------------------------------*
	 *■executeInsertSurveyメソッド
	 *概要　：対象のデータを登録する
	 *引数　：対象のデータ（Dto型）
	 *戻り値：DB操作成功フラグ（true:成功/false:失敗）
	 *----------------------------------------------------------------------**/
	public boolean executeInsertSurvey(Sales_recordsDto dto) {

		boolean   succesInsert = false ;  //DB操作成功フラグ（true:成功/false:失敗）

		//-------------------------------------------
		//データベースへの接続を実施
		//-------------------------------------------

		//DAOクラスをインスタンス化＆対象のユーザーデータを登録するよう依頼
		Sales_recordsDao dao = new Sales_recordsDao();
		succesInsert = dao.doInsert(dto);

		return succesInsert;
	}

}
