package com.service;

import com.utils.Dom4jUtils;
import com.vo.Student;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;

/**
 * Created by admin on 2018/5/8.
 */
public class StudentService {
    public void addStudent(Student stu) throws Exception {
        Document document = Dom4jUtils.getDocument(Dom4jUtils.XMLPATH);
        Element root = document.getRootElement();
        Element student = root.addElement("student");
        student.addElement("num").setText(stu.getNum());
        student.addElement("name").setText(stu.getName());
        student.addElement("description").setText(stu.getDescription());

        Dom4jUtils.writeDocument(Dom4jUtils.XMLPATH, document);

    }

    public Student selectStudent(String num){
        Student student = new Student();

        return student;
    }


    public void delStudent(String num){

    }
}
