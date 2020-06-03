package model;

import java.util.Map;

/**----------------------------------------------------------------------*
 *■■■BusinessLogicクラス■■■
 *概要：ビジネスロジック（データの登録）
 *----------------------------------------------------------------------**/
public class AnalysisBusinessLogic {

	//DAOクラス
//	private AnalysisDao dao = new AnalysisDao();
	private AnalysisDao dao = new AnalysisDao();


	/**
	 * <p>商品の一覧を返す.</p>
	 * @return 検索結果
	 */
/*	public List<Map<String,Object>> getItem_name(){
		List<Map<String,Object>> item_name=  dao.getItem_name();

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
	}/
*/

	public Map<String,Integer> getCalculationResult() {
		return dao.getCalculationResult();
	}



}
