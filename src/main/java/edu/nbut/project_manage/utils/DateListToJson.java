package edu.nbut.project_manage.utils;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

import java.util.Date;
import java.util.List;

public class DateListToJson {

	public static JSONArray dateToJson(List list){
		
		JSONArray array=new JSONArray();
		JsonConfig config = new JsonConfig();
        JsonDateValueProcessor jsonValueProcessor = new JsonDateValueProcessor();  
        config.registerJsonValueProcessor(Date.class, jsonValueProcessor);
        array = JSONArray.fromObject(list,config);
        return array;
	}
	
	public static JSONArray dateLisToJson(List list){
		 JsonConfig jsonConfig = new JsonConfig();
		 JSONArray array=new JSONArray();
        PropertyFilter filter = new PropertyFilter() {
                @Override
				public boolean apply(Object object, String fieldName, Object fieldValue) {
                if(fieldValue instanceof List){
                    List<Object> list = (List<Object>) fieldValue;
                    if (list.size()==0) {
                        return true;
                    }
                }
                return null == fieldValue || "".equals(fieldValue);
                }
        };
        jsonConfig.setJsonPropertyFilter(filter);
        array = JSONArray.fromObject(list,jsonConfig);
        return array;
	}
}
