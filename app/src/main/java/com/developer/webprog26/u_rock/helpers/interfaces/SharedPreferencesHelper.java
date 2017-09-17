package com.developer.webprog26.u_rock.helpers.interfaces;

/**
 * Created by webprog on 17.09.17.
 */

public interface SharedPreferencesHelper {

    String U_ROCK_SHARED_PREFERENCES_NAME = "u_rock_shared_preferences";

    void put(final String key, final String value);
    void put(final String key, final int value);
    void put(final String key, final boolean value);

    String get(final String key, final String defaultValue);
    int get(final String key, final int defaultValue);
    boolean get(final String key, final boolean defaultValue);
}
