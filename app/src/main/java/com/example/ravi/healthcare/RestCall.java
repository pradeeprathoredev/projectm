package com.example.ravi.healthcare;

import android.content.Context;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.io.UnsupportedEncodingException;

import cz.msebera.android.httpclient.entity.StringEntity;

public class RestCall extends AsyncHttpClient{
    private static final String BASE_URL = "http://192.168.0.114:8081/patient-web/";
    ;
    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void get(String url, RequestParams params, JsonHttpResponseHandler responseHandler) {

        client.get(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void post(Context context, String url, String data, JsonHttpResponseHandler responseHandler) {
        StringEntity entity= null;
        try {
            entity = new StringEntity(data);
            client.post(context,getAbsoluteUrl(url),entity,"application/json", responseHandler);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    private static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }
}
