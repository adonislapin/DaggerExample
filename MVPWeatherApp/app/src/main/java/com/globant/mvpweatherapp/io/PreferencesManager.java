package com.globant.mvpweatherapp.io;


import android.content.Context;
import android.content.SharedPreferences;

import com.globant.mvpweatherapp.constants.AppConstants;

/**
 * Created by adoniram.dominguez on 29/06/2017.
 */

public class PreferencesManager {
    private static SharedPreferences preferences;
    private static PreferencesManager ourInstance = null;

    public static PreferencesManager getInstance(Context context) {
        if(ourInstance == null){
            ourInstance = new PreferencesManager();
            preferences = context.getSharedPreferences(AppConstants.SHARED_PREFENCES_NAME, Context.MODE_PRIVATE);
        }
        return ourInstance;
    }

    private PreferencesManager() {
    }

    public void savePreference(String key, Object value){
        SharedPreferences.Editor editor = preferences.edit();

        if(value instanceof Integer){
            editor.putInt(key, (int)value);
        } else if(value instanceof String){
            editor.putString(key, (String) value);
        } else if(value instanceof Boolean){
            editor.putBoolean(key, (Boolean) value);
        } else if(value instanceof Float){
            editor.putFloat(key, (Float) value);
        }

        editor.commit();
    }

    public Object getPrefence(String key, Object defaultValue){
        Object resultObject = null;

        if(defaultValue instanceof Integer) {
            resultObject = preferences.getInt( key, (Integer) defaultValue);
        } else if(defaultValue instanceof String) {
            resultObject = preferences.getString( key, (String) defaultValue);
        } else if(defaultValue instanceof Boolean) {
            resultObject = preferences.getBoolean( key, (Boolean) defaultValue);
        } else if(defaultValue instanceof Float) {
            resultObject = preferences.getFloat( key, (Float) defaultValue);
        }

        return resultObject;

    }
}
