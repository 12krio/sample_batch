package jp.co.kr.velocity;

import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.event.EventCartridge;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.kr.service.DataFeed;
 
public class CompanyCSVOut {
 
  static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

  public void writeCSV(List<Object> obj){
	  VelocityContext context = new VelocityContext();
	  EventCartridge eventCartridge = new EventCartridge();
		context.attachEventCartridge( eventCartridge );
		eventCartridge.addReferenceInsertionEventHandler( new MyRefrenceInsertionEventHandler() );
/*	  FileWriter writer = null;
	try {
		writer = new FileWriter(new File("feed.csv"));
	} catch (IOException e) {
		// TODO 自動生成された catch ブロック
		e.printStackTrace();
	}*/
	  StringWriter writer = new StringWriter();
	  CSVData dataFeed = new CSVData();
	  dataFeed.feedData = obj;
	  context.put("feed", dataFeed);
	  context.put("DELIMETER", ",");
	  context.put("NEWLINE", "\n");
	 
	  Velocity.init();
	  Template template = Velocity.getTemplate("csvcompany.vm","UTF-8");
	  template.merge(context, writer);
	  System.out.println(writer.toString());
	  //writer.flush();
	  //writer.close();

  }
 
  private  HashMap<String, Object> setMap(List<Object> obj){
	  HashMap<String, Object> data = new HashMap<String, Object>();
	  return data;
  }

}
