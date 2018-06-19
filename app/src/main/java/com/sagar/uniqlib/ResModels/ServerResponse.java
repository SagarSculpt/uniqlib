package com.sagar.uniqlib.ResModels;

import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ServerResponse implements Serializable {
    @SerializedName("RestResponse")
    @Expose
    private RestResponse restResponse;

    public ServerResponse() {
        this.restResponse = new RestResponse();
    }

    public RestResponse getRestResponse() {
        return (restResponse == null ? new RestResponse() : restResponse);
    }

    public void setRestResponse(RestResponse restResponse) {
        this.restResponse = (restResponse == null ? new RestResponse() : restResponse);
    }

    public class RestResponse implements Serializable {
        @SerializedName("result")
        @Expose
        private List<Result> result;

        public RestResponse() {
            this.result = new ArrayList<>();
        }

        public List<Result> getResult() {
            return (result == null ? new ArrayList<Result>() : result);
        }

        public void setResult(List<Result> result) {
            this.result = (result == null ? new ArrayList<Result>() : result);
        }

        @Override
        public String toString() {
            return result.toString();
        }
    }

    public class Result implements Serializable {
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("alpha2_code")
        @Expose
        private String alpha2Code;
        @SerializedName("alpha3_code")
        @Expose
        private String alpha3Code;
        @SerializedName("code")
        @Expose
        private Integer code;

        public Result() {
            this.name = "";
            this.alpha2Code = "";
            this.alpha3Code = "";
            this.code = 0;
        }

        public String getName() {
            return (name == null ? "" : name);
        }

        public void setName(String name) {
            this.name = (name == null ? "" : name);
        }

        public String getAlpha2Code() {
            return (alpha2Code == null ? "" : alpha2Code);
        }

        public void setAlpha2Code(String alpha2Code) {
            this.alpha2Code = (alpha2Code == null ? "" : alpha2Code);
        }

        public String getAlpha3Code() {
            return (alpha3Code == null ? "" : alpha3Code);
        }

        public void setAlpha3Code(String alpha3Code) {
            this.alpha3Code = (alpha3Code == null ? "" : alpha3Code);
        }

        public Integer getCode() {
            return (code == null ? 0 : code);
        }

        public void setCode(Integer code) {
            this.code = (code == null ? 0 : code);
        }
    }
}