function getXhr(){
    var xmlHttp;
    try{
        xmlHttp = new XMLHttpRequest();
    }catch (e){
        try{
            xmlHttp = new ActiveXObject("msxml2.XMLHTTP");
        }catch (e){
           try{
               xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
           }catch(e){
               alert("对不起你的浏览器不支持AJAX");
               return false
           }
        }
    }
    return xmlHttp;
}