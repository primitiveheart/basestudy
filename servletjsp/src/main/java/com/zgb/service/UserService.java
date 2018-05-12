package com.zgb.service;

import com.zgb.entity.User;
import com.zgb.utils.Constans;
import com.zgb.utils.Dom4jUtil;
import org.dom4j.Document;
import org.dom4j.Element;

import java.util.List;

/**
 * Created by admin on 2018/5/10.
 */
public class UserService {
    public int regUser(User user) throws Exception {
        Document document = Dom4jUtil.getDocument(Constans.XMLPATH);

        Element root = document.getRootElement();

        List<Element> elements = root.elements("user");
        for(Element element : elements){
            String name = element.element("username").getText();
            if( name != "" && name.equals(user.getUsername())){
                return Constans.NAMEEXIST;
            }
            String email = element.element("email").getText();
            if(email != "" && email.equals(user.getEmail())){
                return Constans.EMAILEXIST;
            }
        }

        Element u = root.addElement("user");
        u.addElement("username").setText(user.getUsername());
        u.addElement("password").setText(user.getPassword());
        u.addElement("nickname").setText(user.getNickname());
        u.addElement("email").setText(user.getEmail());
        Dom4jUtil.writeDocument(document , Constans.XMLPATH);
        return Constans.SUCCESSS;
    }
}
