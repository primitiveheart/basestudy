package com;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by admin on 2018/5/18.
 */
public class Demo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean isMultipart = ServletFileUpload.isMultipartContent(req);
        if(!isMultipart){
            resp.getWriter().write("if you want upload file, your form enctype attribute mush multipart/form-data");
        }

        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
        //设置单个上传文件的大小
//        servletFileUpload.setFileSizeMax(1024*1024*2);
        //设置总的上传文件的大小
//        servletFileUpload.setSizeMax(6*1024*1024);
        List<FileItem> fileItemList = new ArrayList<>();

        try {
            fileItemList = servletFileUpload.parseRequest(req);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }

        for(FileItem fileItem : fileItemList){
            if(fileItem.isFormField()){
                //普通字段
                processFormFile(fileItem);
            }else{
                //上传文件
                processUploadFile(fileItem);
            }
        }


    }

    private void processUploadFile(FileItem fileItem) {
        try{
//            InputStream in = fileItem.getInputStream();
            String storeDirectory = getServletContext().getRealPath("files");
            String filename = fileItem.getName();
            //处理文件有空项的
            if("".equals(filename)){
                return;
            }
            //针对不同的浏览器而言的
            if(filename != null){
                filename = FilenameUtils.getName(filename);
            }
            String uuidFilename = UUID.randomUUID().toString();
            //解决文件名重名的问题
            filename = uuidFilename + "_" + filename;
//            String childDirectory = makeChildDirectory(storeDirectory);
            String childDirectory = makeChildDirectory(storeDirectory, uuidFilename);
//            FileOutputStream fos = new FileOutputStream(new File(childDirectory + "/" + filename));
//            byte[] bytes = new byte[1024];
//            int len = 0;
//            while ((len = in.read(bytes)) != -1){
//                fos.write(bytes, 0, len);
//            }
//            in.close();
//            fos.close();
            fileItem.write(new File(childDirectory + "/" + filename));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private String makeChildDirectory(String storeDirectory, String uuidFilename) {
        int hashcode = uuidFilename.hashCode();
        int dir1 = hashcode&0xf;
        int dir2 = (hashcode&0xf0)>>4;
        File f = new File(storeDirectory + File.separator + dir1 + File.separator + dir2);
        if(!f.exists()){
            f.mkdirs();
        }
        return f.getPath();
    }

    /**
     * 按日期进行分目录
     * @param storeDirectory
     * @return
     */
    private String makeChildDirectory(String storeDirectory) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String child = sdf.format(date);
        File f = new File(storeDirectory + "/" + child);
        if(!f.exists()){
            f.mkdirs();
        }

        return f.getPath();
    }



    private void processFormFile(FileItem fileItem) {
        String value = null;
        try {
            value = fileItem.getString("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String fieldName = fileItem.getFieldName();
        System.out.println(fieldName + "=" + value);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
