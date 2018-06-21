package com.sagar.uniqlib.Functions;

import android.content.Context;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sagar.uniqlib.Interface.onResponse;
import com.sagar.uniqlib.ResModels.ServerResponse;
import com.sagar.uniqlib.Utils.MySingleton;
import com.sagar.uniqlib.Utils.NullToDefaultValueAdapterFactory;

import org.json.JSONObject;

import static com.android.volley.Request.Method.GET;

/**
 * Created by sc-147 on 13-Jun-18.
 */

public class Calculator {
    private static Calculator mInstance;
    private Gson gson;
    private onResponse mOnResponse;
    private GsonBuilder gsonBuilder;

//    private String URL = "http://services.groupkt.com/country/get/all";

    private String URL = "https://saagars.000webhostapp.com/MyUpload/demoJson.json";
    private ServerResponse serverResponse;

    private Calculator() {

    }

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
        if (number2 == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return number1 / number2;
    }

    public void sendRequest(Context context, onResponse mResponse) {
        gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(new NullToDefaultValueAdapterFactory());
        gson = gsonBuilder.create();
        mOnResponse = mResponse;
        JsonObjectRequest mJsonObjectRequest = new JsonObjectRequest(GET, URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                String _response = response.toString();
                serverResponse = gson.fromJson(_response, ServerResponse.class);

                String jsonString = gson.toJson(serverResponse, ServerResponse.class);

                mOnResponse.onSuccess(jsonString);

                Log.v("Server_Response::->", jsonString);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("Server_Response::->", error.getCause().getMessage());
                mOnResponse.onError(error.getMessage());
            }
        });
        MySingleton.getInstance(context).addToRequestQueue(mJsonObjectRequest);
    }
}
