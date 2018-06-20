package com.sagar.uniqlib_example.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.sagar.uniqlib.Functions.Calculator;
import com.sagar.uniqlib.Interface.onResponse;
import com.sagar.uniqlib.Utils.MySingleton;
import com.sagar.uniqlib_example.R;

public class MainActivity extends AppCompatActivity implements onResponse {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calculator.getmInstance().sendRequest(this, this);

        try {
            double resultDiv = Calculator.getmInstance().divNumber(2.5, 4.8);
            Log.v("Result", "" + resultDiv);
        } catch (Exception e) {
            Log.v("Exception", e.getMessage());
        }

        double resultAdd = Calculator.getmInstance().addNumber(2.5, 4.8);
        Log.v("ResultAdd", "" + resultAdd);
        double resultMul = Calculator.getmInstance().mulNumber(2.5, 4.8);
        Log.v("ResultMul", "" + resultMul);
        double resultSub = Calculator.getmInstance().subNumber(2.5, 4.8);
        Log.v("ResultSub", "" + resultSub);
    }

    @Override
    public void onSuccess(String serverResponse) {
        Log.v("Server_response::->", serverResponse);
    }

    @Override
    public void onError(String message) {
        Log.v("Server_response::->", "");
    }
}
