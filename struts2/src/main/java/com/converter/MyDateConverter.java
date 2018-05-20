package com.converter;

import com.opensymphony.xwork2.conversion.impl.DefaultTypeConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by admin on 2018/5/19.
 */
public class MyDateConverter extends DefaultTypeConverter {
    @Override
    public Object convertValue(Object value, Class toType) {
        if(value == null){
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        if(toType == String.class){
            Date date = (Date) value;
            return sdf.format(date);
        }else{
            String[] str = (String[])value;
            try {
                return sdf.parse(str[0]);
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
