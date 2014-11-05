package jp.co.kr.service;

import org.apache.velocity.app.Velocity;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;

import java.io.File;
import java.io.FileWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
public class CSVFeedGeneration {
 
  static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
 
/*  static DataFeed dataFeed;
 static {
  // prepare some static data
  dataFeed = new DataFeed();
  List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
  Map<String, Object> data = new HashMap<String, Object>();
  data.put("TransactionId", 1);
  data.put("Amount", new Integer(2312));
  data.put("Currency", "SGD");
  data.put("ExecutionDate", dateFormat.format(new Date()));
  dataList.add(data);
  data = new HashMap<String, Object>();
  data.put("TransactionId", 2);
  data.put("Amount", new Integer(1212));
  data.put("Currency", "INR");
  data.put("ExecutionDate", dateFormat.format(new Date()));
  data.put("Status", "Active");
  dataList.add(data);
 
  dataFeed.feedData =dataList;
  }*/
 
  public static void main(String[] args) throws Exception {
  VelocityContext context = new VelocityContext();
//  FileWriter writer = new FileWriter(new File("feed.csv"));
  StringWriter writer = new StringWriter();
   
  // inject the objects to be used in template
  DataFeed dataFeed;
  // prepare some static data
  dataFeed = new DataFeed();
  List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
  Map<String, Object> data = new HashMap<String, Object>();
  data.put("TransactionId", 1);
  data.put("Amount", new Integer(2312));
  data.put("Currency", "SGD");
  data.put("ExecutionDate", dateFormat.format(new Date()));
  dataList.add(data);
  data = new HashMap<String, Object>();
  data.put("TransactionId", 2);
  data.put("Amount", new Integer(1212));
  data.put("Currency", "INR");
  data.put("ExecutionDate", dateFormat.format(new Date()));
  data.put("Status", "Active");
  dataList.add(data);
  dataFeed.setFeedData(dataList);
  //dataFeed.getFeedData();
  
  //System.out.println(dataFeed.getfeedData());
  context.put("feed", dataFeed);
  context.put("DELIMETER", ",");
  context.put("NEWLINE", "\n");
 
  Velocity.init();
  Template template = Velocity.getTemplate("csvfeed.vm");
  template.merge(context, writer);
  System.out.println(writer.toString());
  //writer.flush();
  //writer.close();
 
  }

}
