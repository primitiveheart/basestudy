package com.download;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FilenameUtils;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by admin on 2018/5/20.
 */
public class DownloadAction extends ActionSupport {
    private InputStream inputStream;

    private int fileLength;

    private String filename;

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public int getFileLength() {
        return fileLength;
    }

    public void setFileLength(int fileLength) {
        this.fileLength = fileLength;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Override
    public String execute() throws Exception {
//        HttpServletRequest request = ServletActionContext.getRequest();
        String filepath = ServletActionContext.getServletContext().getRealPath("WEB-INF/files/55.png");

        inputStream = new FileInputStream(filepath);
        fileLength = inputStream.available();

        filename = FilenameUtils.getName(filepath);
        HttpServletRequest request = ServletActionContext.getRequest();
        String userAgent = request.getHeader("User-Agent");
        if(userAgent.contains("FireFox")){
            filename = new String(filename.getBytes("iso-8859-1"), "utf-8");
        }else {
            filename = URLEncoder.encode(filename, "utf-8");
        }
        return SUCCESS;
    }
}
