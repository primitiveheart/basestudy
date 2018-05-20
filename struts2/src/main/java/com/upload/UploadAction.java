package com.upload;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import java.io.File;

/**
 * Created by admin on 2018/5/20.
 */
public class UploadAction extends ActionSupport {
    private String name;
    private File photo;
    private String photoFileName;
    private String photoContentType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public File getPhoto() {
        return photo;
    }

    public void setPhoto(File photo) {
        this.photo = photo;
    }

    public String getPhotoFileName() {
        return photoFileName;
    }

    public void setPhotoFileName(String photoFileName) {
        this.photoFileName = photoFileName;
    }

    public String getPhotoContentType() {
        return photoContentType;
    }

    public void setPhotoContentType(String photoContentType) {
        this.photoContentType = photoContentType;
    }

    @Override
    public String execute() throws Exception {
        ServletContext sc = ServletActionContext.getServletContext();
        String storeDiretory = sc.getRealPath("WEB-INF/files");
//        FileUtils.copyFile(photo, new File(storeDiretory, photoFileName));
        //清除缓存文件
        photo.renameTo(new File(storeDiretory, photoFileName));
        return SUCCESS;
    }
}
