# 文件的上传和下载
## 文件的上传
    表单的enctype的默认值：applicaiton/x-www-form-urlencoded
    文件上传的enctype的值:multipart/form-data
    1、文件上传原理
    对请求正文进行解析(用流的方式)
    2、第三方的上传组件
    commons-fileupload、commons-io
    ServlerFileUpload、FileItem、DiskFileItemFactory
    3、实际开发中的问题
        a、如何保证服务器的安全
            把保存上传文件的目录放到WEB-INF
        b、避免文件的重名的问题
        c、如何避免同一文件夹的文件过多
            分目录存储
            按日期分目录
            用uuid文件名的hash码分散目录
         d、限制上传的文件的大小
            web不适合上传太大的文件
            上传单个文件不能超过2M
            总的上传文件的大小不超过6M
          e、限制文件类型
            通过扩展名来限制
            通过判断文件的MIME的类型
          f、多文件上传时，有空项的问题
            文件不是null，而是空字符串
          g、中文乱码问题
              普通字段乱码问题
                解决方案：
              上传文件名乱码问题
                解决方案：requext.setCharacterEncoding
## 文件的下载