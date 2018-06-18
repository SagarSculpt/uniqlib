package com.sagar.uniqlib.Functions;

import android.content.Context;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.sagar.uniqlib.Utils.MySingleton;

import org.json.JSONObject;

import static com.android.volley.Request.Method.GET;

/**
 * Created by sc-147 on 13-Jun-18.
 */

public class Calculator {
    private static Calculator mInstance;
    private String URL = "http://services.groupkt.com/country/get/all";

    public static synchronized Calculator getmInstance() {
        if (mInstance == null) {
            mInstance = new Calculator();
        }
        return mInstance;
    }

    public double addNumber(double number1, double number2) {
        return number1 + number2;
    }

    public double subNumber(double number1, double number2) {
        return number1 - number2;
    }

    public double mulNumber(double number1, double number2) {
        return number1 * number2;
    }

    public double divNumber(double number1, double number2) {
        if(number2==0){
            throw new IllegalArgumentException("Cannot device by zero");
        }
        return number1 / number2;
    }

    public void sendRequest(Context context) {
        JsonObjectRequest mJsonObjectRequest = new JsonObjectRequest(GET, URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.v("Server_Response::->", response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("Server_Response::->", error.getMessage());
            }
        });
        MySingleton.getInstance(context).addToRequestQueue(mJsonObjectRequest);
    }
}
