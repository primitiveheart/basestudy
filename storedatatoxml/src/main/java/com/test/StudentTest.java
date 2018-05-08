package com.test;

import com.service.StudentService;
import com.vo.Student;

/**
 * Created by admin on 2018/5/8.
 */
public class StudentTest {
    public static void main(String[] args){
        StudentService studentService = new StudentService();
        Student student = new Student("002", "丫丫", "very nice");
        try {
            studentService.addStudent(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
