package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**----------------------------------------------------------------------*
 *■■■BusinessLogicクラス■■■
 *概要：ビジネスロジック（データの登録）
 *----------------------------------------------------------------------**/
public class SalesRecordsBusinessLogic {

	//DAOクラス
	private SalesRecordsDao dao = new SalesRecordsDao();

	/**----------------------------------------------------------------------*
	 *■executeInsertSurveyメソッド
	 *概要　：対象のデータを登録する
	 *引数　：対象のデータ（Dto型）
	 *戻り値：DB操作成功フラグ（true:成功/false:失敗）
	 *----------------------------------------------------------------------**/
	public boolean executeInsertSurvey(SalesRecordsDto dto) {

		boolean   succesInsert = false ;  //DB操作成功フラグ（true:成功/false:失敗）

		//-------------------------------------------
		//データベースへの接続を実施
		//-------------------------------------------
		succesInsert = dao.doInsert(dto);

		return succesInsert;
	}


	/**
	 * <p>商品の一覧を返す.</p>
	 * @return 検索結果
	 */
	public List<Map<String,Object>> getItems(){
		List<Map<String,Object>> items =  dao.getItems();

		//★★データベースからデータの取得
		List<Map<String,Object>> resultList = new ArrayList<Map<String,Object>>();

		//★★取得したデータを整形（整形・・ここではgenderの値に合わせてメンズ・レディースをセット）
		for(Map<String,Object> item : items) {
			if((int)item.get("gender") == 1) {
				item.put("gender", "メンズ");
			} else {
				item.put("gender", "レディース");
			}
			resultList.add(item);
		}
		//★★整形した結果を返す
		return resultList;
	}


	/**
	 * <p>購入者の一覧を返す.</p>
	 * @return 検索結果
	 */
	public List<Map<String,Object>> getUsers(){
		//★★処理の作りはgetItemsと同様
		List<Map<String,Object>> users =  dao.getUsers();

		List<Map<String,Object>> resultList = new ArrayList<Map<String,Object>>();

		for(Map<String,Object> user : users) {
			if((int)user.get("gender") == 1) {
				user.put("gender", "男性");
			} else {
				user.put("gender", "女性");
			}
			resultList.add(user);
		}

		return resultList;
	}

}
