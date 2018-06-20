package com.sagar.uniqlib.Utils;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

@SuppressWarnings("unchecked")
public class NullToDefaultValueAdapterFactory implements TypeAdapterFactory {
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
        Class<? super T> rawType = type.getRawType();
        if (rawType == String.class) {
            return (TypeAdapter<T>) new StringAdapter();
        } else if (rawType == Integer.class) {
            return (TypeAdapter<T>) new IntegerAdapter();
        } else if (rawType == Double.class) {
            return (TypeAdapter<T>) new DoubleAdapter();
        } else if (rawType == Boolean.class) {
            return (TypeAdapter<T>) new BooleanAdapter();
        } else {
            return null;
        }
    }
}
