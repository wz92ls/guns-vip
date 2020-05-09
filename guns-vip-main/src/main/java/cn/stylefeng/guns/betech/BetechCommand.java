package cn.stylefeng.guns.betech;
import cn.stylefeng.guns.betech.HttpsUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.DigestUtils;

import java.text.SimpleDateFormat;

import static com.baomidou.mybatisplus.core.toolkit.Constants.MD5;

public class BetechCommand {
    static String testuri="http://hotel-api.betech-security.com";
    static String workuri="https://hotel-api.betech-security.com";
    static String appid="test1";
    static String secret="c6890a80d92548efaec8ee246cf12736";
    static String access_token="";
    static String refresh_token="";
    public static byte[] access_token() throws Exception {
        String grant_type="client_credentials";
        String uri = testuri+"/oauth2/access_token?appid="+appid+"&secret="+secret;
        byte[] bytes = HttpsUtil.doGet(uri);
        System.out.println(new String(bytes));
        JSONObject obj = JSON.parseObject(new String(bytes));
        access_token = obj.getString("access_token");
        refresh_token = obj.getString("refresh_token");
        return bytes;
    }
    public static byte[] refresh_token() throws Exception {
        String grant_type="refresh_token";
        String uri = testuri+"/oauth2/refresh_token?appid="+appid+"&refresh_token="+refresh_token;
        byte[] bytes = HttpsUtil.doGet(uri);
        System.out.println(new String(bytes));
        JSONObject obj = JSON.parseObject(new String(bytes));
        access_token = obj.getString("access_token");
        refresh_token = obj.getString("refresh_token");
        return bytes;
    }
    private static String get_sign(String strsystime,String stringA)
    {
        String stringSignTemp=stringA+"&timestamp="+strsystime+"&secret="+secret;
        String md5 = DigestUtils.md5DigestAsHex(stringSignTemp.getBytes());
        return md5.toUpperCase();
    }
    private static byte[]v2_mkey_command(String uri,String data)throws Exception
    {
        if(refresh_token=="")
        {
            access_token();
        }
        else
        {
            refresh_token();
        }
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String BD_Timestamp = sf.format(System.currentTimeMillis());
        String BD_Sign=get_sign(BD_Timestamp,data);
        byte[] bytes = HttpsUtil.doPost_V2(uri,data,access_token,BD_Timestamp,BD_Sign);
        return bytes;
    }
    public static byte[] v2_mkey_send(String room,String mobile,String checkin_time,String checkout_time)throws Exception{
        String uri = testuri+"/v2/mkey/send";
        String data="checkin_time="+checkin_time+"&checkout_time="+checkout_time+"&mobile="+mobile+"&room="+room;
        return v2_mkey_command(uri,data);
    }
    public static byte[] v2_mkey_cancel(String room,String mobile)throws Exception{
        String uri = testuri+"/v2/mkey/cancel";
        String data="mobile="+mobile+"&room="+room;
        return v2_mkey_command(uri,data);
    }
    public static byte[] v2_mkey_update(String room,String mobile,String expire_time)throws Exception{
        String uri = testuri+"/v2/mkey/cancel";
        String data="expire_time="+expire_time+"&mobile="+mobile+"&room="+room;
        return v2_mkey_command(uri,data);
    }
    public static byte[] v2_cmd_door_operate(String room,String mobile,String action)throws Exception{
        String uri = testuri+"/v2/cmd/door/operate";
        String data="action="+action+"&mobile="+mobile+"&room="+room;
        return v2_mkey_command(uri,data);
    }
    public static byte[] v2_cmd_switch_operate(String room,String mobile,String action)throws Exception{
        String uri = testuri+"/v2/cmd/switch/operate";
        String data="action="+action+"&mobile="+mobile+"&room="+room;
        return v2_mkey_command(uri,data);
    }
    public static byte[] v2_cmd_task_get(String taskid)throws Exception{
        String uri = testuri+"/v2/cmd/task/get";
        String data="taskid="+taskid;
        return v2_mkey_command(uri,data);
    }
    public static byte[] v2_ble_getkey(String room,String mobile,String blueBrdInfo)throws Exception{
        String uri = testuri+"/v2/ble/getkey";
        String data="blueBrdInfo="+blueBrdInfo+"&mobile="+mobile+"&room="+room;
        return v2_mkey_command(uri,data);
    }
    public static byte[] v2_ble_synctime(String room,String mobile,String blueBrdInfo)throws Exception{
        String uri = testuri+"/v2/ble/synctime";
        String data="blueBrdInfo="+blueBrdInfo+"&mobile="+mobile+"&room="+room;
        return v2_mkey_command(uri,data);
    }
}
