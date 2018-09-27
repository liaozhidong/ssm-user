package com.spring.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期转换器
 * lzd
 */
public class DateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String source) {
        Date date = null;
     SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try{
          date=simpleDateFormat.parse(source);
        }catch (ParseException e){
            e.printStackTrace();
        }
        return date;
    }
}
