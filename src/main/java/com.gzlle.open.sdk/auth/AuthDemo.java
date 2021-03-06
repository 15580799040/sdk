package com.gzlle.open.sdk.auth;

import com.google.gson.Gson;
import com.gzlle.open.sdk.vo.token.AccessTokenVO;
import com.gzlle.open.sdk.utils.baseUrlUtil;
import com.gzlle.open.sdk.utils.HttpUtil;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 获取accessToken接口
 */
public class AuthDemo {
    public static AccessTokenVO getAccessToken(String appKey, String appSecret) {
        String url = baseUrlUtil.API_BASE_URL + "/token";
        String charset = "UTF-8";
        Map<String, Object> map = new HashMap<String,Object>();
        map.put("grantType", "client_credentials");
        //appKey、appSecret在saas平台的开发者配置获取
        map.put("appKey", appKey);
        map.put("appSecret", appSecret);
        LinkedHashMap<String, String> headers = new LinkedHashMap<String, String>();
        headers.put("Content-Type", "application/json; charset=UTF-8");
        String result = HttpUtil.doPost(url, map, charset, headers);
        return new Gson().fromJson(result, AccessTokenVO.class);
    }

    public static void main(String[] args) {
        AccessTokenVO accessTokenVO=getAccessToken("309005825454637056","B5DA273A8DB648BF14A7FAFD5AD874CF");
        String token=accessTokenVO.getAccessToken();
        String expiresIn=accessTokenVO.getExpiresIn();
        String error=accessTokenVO.getError();
        String message=accessTokenVO.getMessage();
        System.out.println(token);
        System.out.println(expiresIn);
        System.out.println(error);
        System.out.println(message);

    }
}
