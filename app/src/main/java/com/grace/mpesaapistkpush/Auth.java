package com.grace.mpesaapistkpush;

import android.util.Base64;
import android.util.Log;
import android.widget.Toast;


import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Logger;

public class Auth {
    Constants constants = new Constants();

    private String Encoded() throws UnsupportedEncodingException {
        String appKeySecret = constants.getConsumerKey() + ":" + constants.getConsumerSecret();
        byte[] bytes = appKeySecret.getBytes("ISO-8859-1");
        return Base64.encodeToString(bytes, Base64.DEFAULT);
    }

    public String genToken() throws IOException, JSONException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://sandbox.safaricom.co.ke/oauth/v1/generate?grant_type=client_credentials")
                .get()
                .addHeader("authorization", "Basic "+ Encoded().trim())
                .addHeader("cache-control", "no-cache")
                .build();

        Response response = client.newCall(request).execute();
        JSONObject jsonObject = new JSONObject(response.body().string());
        Log.i("Access Token bbbbbbbb", jsonObject.getString("access_token"));
        return jsonObject.getString("access_token");
    }
}
