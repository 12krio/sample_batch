package jp.co.kr.velocity;

import java.util.List;
import java.util.Map;

public class CSVData {
    
	public CSVData() {
		super();
		//this.feedData = null;
	}

	public List<Object> feedData = null;
	
	public  List<Object>  getfeedData(){
		return feedData;
	}
	
	public void setFeedData(List<Object> obj) {
		// TODO 自動生成されたメソッド・スタブ
		feedData = obj;
	}
}
