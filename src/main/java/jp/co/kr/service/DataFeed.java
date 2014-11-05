package jp.co.kr.service;

import java.util.List;
import java.util.Map;

public class DataFeed {
    
	public DataFeed() {
		super();
		//this.feedData = null;
	}

	public List<Map<String, Object>> feedData = null;
	
	public  List<Map<String, Object>>  getfeedData(){
		return feedData;
	}
	
	public void setFeedData(List<Map<String, Object>> obj) {
		// TODO 自動生成されたメソッド・スタブ
		feedData = obj;
	}
}
