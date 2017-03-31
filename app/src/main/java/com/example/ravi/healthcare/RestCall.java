package com.example.ravi.healthcare;

import android.app.ProgressDialog;
import android.content.Context;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.io.UnsupportedEncodingException;

import cz.msebera.android.httpclient.entity.StringEntity;

public class RestCall extends AsyncHttpClient{
    private static final String BASE_URL = "http://192.168.0.114:8081/patient-web/";
Context context;
    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void get(String url,Context context, RequestParams params, JsonHttpResponseHandler responseHandler) {

        startLoder(context);
        client.get(getAbsoluteUrl(url), params, responseHandler);
        stopLoder(startLoder(context));
    }

    public static void post(Context context, String url, String data, JsonHttpResponseHandler responseHandler) {
        StringEntity entity= null;
        try {
            startLoder(context);
            entity = new StringEntity(data);
            client.post(context,getAbsoluteUrl(url),entity,"application/json", responseHandler);
            stopLoder(startLoder(context));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        finally {
            stopLoder(startLoder(context));
        }

    }

    private static  ProgressDialog startLoder(Context context){
        ProgressDialog pdLoading=new ProgressDialog(context);
        pdLoading.setMessage("\tLoading...");
        pdLoading.setCancelable(false);
        pdLoading.show();
        return pdLoading;
    }
    private static  void stopLoder(ProgressDialog pdLoading){
        pdLoading.dismiss();
    }
    private static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }
}
