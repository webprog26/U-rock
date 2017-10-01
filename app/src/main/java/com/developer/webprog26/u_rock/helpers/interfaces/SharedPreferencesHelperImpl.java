package com.developer.webprog26.u_rock.helpers.interfaces;

import android.content.SharedPreferences;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Class-wrapper for {@link SharedPreferences}
 */
@Singleton
public class SharedPreferencesHelperImpl implements SharedPreferencesHelper {

    private final SharedPreferences mSharedPreferences;

    @Inject
    public SharedPreferencesHelperImpl(SharedPreferences sharedPreferences){
        this.mSharedPreferences = sharedPreferences;
    }

    @Override
    public void put(String key, String value) {
        getSharedPreferences().edit().putString(key, value).apply();
    }

    @Override
    public void put(String key, int value) {
        getSharedPreferences().edit().putInt(key, value).apply();
    }

    @Override
    public void put(String key, boolean value) {
        getSharedPreferences().edit().putBoolean(key, value).apply();
    }

    @Override
    public String get(String key, String defaultValue) {
        return getSharedPreferences().getString(key, defaultValue);
    }

    @Override
    public int get(String key, int defaultValue) {
        return getSharedPreferences().getInt(key, defaultValue);
    }

    @Override
    public boolean get(String key, boolean defaultValue) {
        return getSharedPreferences().getBoolean(key, defaultValue);
    }

    private SharedPreferences getSharedPreferences() {
        return mSharedPreferences;
    }
}
