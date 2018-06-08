package cn.com.webxml;

/**
 * Created by admin on 2018/6/4.
 */
public class APP {
    public static void main(String[] args){
        MobileCodeWS mobileCodeWS = new MobileCodeWS();
        MobileCodeWSSoap soap = mobileCodeWS.getMobileCodeWSSoap();
        String info = soap.getMobileCodeInfo("13767222255", null);
        System.out.println(info);
    }
}
