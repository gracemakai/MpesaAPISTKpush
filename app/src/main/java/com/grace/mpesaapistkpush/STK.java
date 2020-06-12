package com.grace.mpesaapistkpush;

import android.util.Log;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class STK {

    public String Send(String Phone, String Amount) throws IOException, JSONException {
        Auth auth = new Auth();
        Constants constants = new Constants();
        Password password = new Password();

        JSONArray jsonArray=new JSONArray();
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("BusinessShortCode", constants.getShortCode());
        jsonObject.put("Password", "MTc0Mzc5YmZiMjc5ZjlhYTliZGJjZjE1OGU5N2RkNzFhNDY3Y2QyZTBjODkzMDU5YjEwZjc4ZTZiNzJhZGExZWQyYzkxOTIwMTYwMjE2MTY1NjI3");
        jsonObject.put("Timestamp", "20160216165627");
        jsonObject.put("TransactionType", "CustomerPayBillOnline");
        jsonObject.put("Amount",Amount);
        jsonObject.put("PhoneNumber", Phone);
        jsonObject.put("PartyA", Phone);
        jsonObject.put("PartyB", constants.getShortCode());
        jsonObject.put("CallBackURL", "https://webhook.site/a6def29c-89fa-41bc-b750-85c0468479f6");
        jsonObject.put("AccountReference", Phone);
        jsonObject.put("TransactionDesc", "Pay");

        jsonArray.put(jsonObject);

        String jsonText = jsonArray.toString().replaceAll("[\\[\\]]","");

        OkHttpClient okHttpClient = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, jsonText);
        Request request = new Request.Builder()
                .url("https://sandbox.safaricom.co.ke/mpesa/stkpush/v1/processrequest")
                .post(body)
                .addHeader("authorization", "Bearer "+auth.genToken())
                .addHeader("content-type", "application/json")
                .addHeader("cache-control", "no-cache")
                .build();
        Response response = okHttpClient.newCall(request).execute();
        Log.w("Response Body", response.body().string());
        return response.body().toString();
    }
}
