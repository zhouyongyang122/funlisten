package com.funlisten.service.net;

import android.os.Build;

import com.funlisten.BuildConfig;
import com.funlisten.ZYApplication;
import com.funlisten.ui.login.model.ZYUserManager;
import com.funlisten.utils.ZYChannelUtil;
import com.funlisten.utils.ZYDeviceIDUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ZY on 17/3/16.
 */

public class ZYNetConfig {

    public static final String API_URL = BuildConfig.API_URL;

    public Map<String, String> getHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("App-Version", BuildConfig.VERSION_NAME);
        headers.put("Client-OS", headerFormat(Build.VERSION.RELEASE));
        headers.put("Device-Model", headerFormat(Build.MODEL));
        headers.put("Umeng-Channel", ZYChannelUtil.getChannel(ZYApplication.getInstance()));
        headers.put("User-Agent", "android");
        headers.put("versionCode", BuildConfig.VERSION_CODE + "");
        headers.put("idfa", ZYDeviceIDUtil.getInstance().getDeviceID(ZYApplication.getInstance()));
        return headers;
    }

    public HashMap<String, String> getDefParams() {
        HashMap<String, String> params = new HashMap<>();
        if(ZYUserManager.getInstance().getUser().uid != null){
            params.put("uid", ZYUserManager.getInstance().getUser().uid);
        }
        if(ZYUserManager.getInstance().getUser().auth_token != null){
            params.put("auth_token", ZYUserManager.getInstance().getUser().auth_token);
        }
        return params;
    }

    public static String headerFormat(String value) {
        if (value == null) {
            return "null";
        }
        String newValue = value.replace("\n", "");
        StringBuilder sb = new StringBuilder();
        for (int i = 0, length = newValue.length(); i < length; i++) {
            char c = newValue.charAt(i);
            if (c <= '\u001f' || c >= '\u007f') {
                sb.append(String.format("\\u%04x", (int) c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
