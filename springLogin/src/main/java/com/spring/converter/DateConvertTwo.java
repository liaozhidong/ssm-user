package com.spring.converter;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

//时间转换器
public class DateConvertTwo implements Formatter<Date> {
    @Override
    public Date parse(String s, Locale locale) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd HH:mm");
        Date date = null;
        try{
            date= simpleDateFormat.parse(s);
        }catch (ParseException e){
            e.printStackTrace();
        }
        return date;
    }

    @Override
    public String print(Date date, Locale locale) {
        return null;
    }
}
