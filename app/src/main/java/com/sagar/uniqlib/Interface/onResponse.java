package com.sagar.uniqlib.Interface;

import com.sagar.uniqlib.ResModels.ServerResponse;

public interface onResponse {
    void onSuccess(ServerResponse serverResponse);
    void onError(String message);
}
