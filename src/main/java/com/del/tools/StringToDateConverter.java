	package com.del.tools;
	import java.text.SimpleDateFormat;
	import java.util.Date;
	import java.text.ParseException;
	import org.springframework.core.convert.converter.Converter;
	
	public class StringToDateConverter implements Converter<String, Date> {
	
		//声明一个时间格式
		private String dataPattern;
		
		//添加有参构造，才能注入datePattern属性
		public StringToDateConverter(String dataPattern){
			this.dataPattern = dataPattern;
		}
		
		//重写方法，完成格式转换
		@Override
		public Date convert(String s) {
			Date  date = null;
			
			try {
				date =  new SimpleDateFormat(dataPattern).parse(s);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// TODO Auto-generated method stub
			return date;
		}
	
	}
