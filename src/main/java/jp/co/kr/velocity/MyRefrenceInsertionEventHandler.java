package jp.co.kr.velocity;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.velocity.app.event.ReferenceInsertionEventHandler;

public class MyRefrenceInsertionEventHandler implements ReferenceInsertionEventHandler {
    public Object referenceInsert(String reference, Object value) {
//        LOGGER.trace("reference: {}, value {}", reference, value);
        if (value == null) {
            return '"' + "" +'"';
        } else if(value.toString().equals("")){
            return '"'+'"';        	
        } else {
        	System.out.println(value.toString());
            return '"' + value.toString().replaceAll("aaa","") + '"';
        }
    }
}