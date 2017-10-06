	package com.del.tools;
	import java.text.SimpleDateFormat;
	import java.util.Date;
	import java.text.ParseException;
	import org.springframework.core.convert.converter.Converter;
	
	public class StringToDateConverter implements Converter<String, Date> {
	
		//����һ��ʱ���ʽ
		private String dataPattern;
		
		//����вι��죬����ע��datePattern����
		public StringToDateConverter(String dataPattern){
			this.dataPattern = dataPattern;
		}
		
		//��д��������ɸ�ʽת��
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
