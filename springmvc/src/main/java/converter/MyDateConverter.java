package converter;

import org.springframework.core.convert.converter.Converter;

import java.util.Date;

/**
 * Created by admin on 2018/5/21.
 */
public class MyDateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
        return null;
    }
}
