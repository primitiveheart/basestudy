package com.zgb.utils;


import com.zgb.entity.User;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;

/**
 * Created by admin on 2018/5/10.
 */
public class Dom4jUtil {
    public static Document getDocument(String path) throws DocumentException {
        SAXReader reader = new SAXReader();
        return reader.read(path);
    }

    public static void writeDocument(Document document, String url) throws Exception{
        OutputFormat outputFormat = OutputFormat.createPrettyPrint();
        XMLWriter writer = new XMLWriter(new FileOutputStream(url));
        writer.write(document);
        writer.close();
    }
}
