package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**----------------------------------------------------------------------*
 *■■■BusinessLogicクラス■■■
 *概要：ビジネスロジック（データの登録）
 *----------------------------------------------------------------------**/
public class AnalysisBusinessLogic {

	//DAOクラス
	private AnalysisDao dao = new AnalysisDao();



	/**
	 * <p>商品の一覧を返す.</p>
	 * @return 検索結果
	 */
	public List<Map<String,Object>> getItems(){
		List<Map<String,Object>> items=  dao.getItems();

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
	 * <p>売上と利益を返す</p>
	 */
	public Map<String,Integer> getCalculationResult() {
		return dao.getCalculationResult();
	}



}
