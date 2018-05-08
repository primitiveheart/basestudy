package com.utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;

/**
 * Created by admin on 2018/5/8.
 */
public class Dom4jUtils {
    public final static String XMLPATH = "E:\\intellij\\basestudy\\storedatatoxml\\src\\main\\java\\com\\student.xml";

    public static Document getDocument(String url) throws DocumentException {
        SAXReader reader = new SAXReader();
        return reader.read(url);
    }

    public static void writeDocument(String url, Document document)throws Exception{
        OutputFormat outputFormat = OutputFormat.createCompactFormat();
        XMLWriter writer = new XMLWriter(new FileOutputStream(url), outputFormat);
        writer.write(document);
        writer.close();
    }
}
