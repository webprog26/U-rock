package com.developer.webprog26.u_rock.helpers.interfaces;

/**
 * Interface, which should be implemented for class-wrapper for {@link android.content.SharedPreferences}
 */

public interface SharedPreferencesHelper {

    void put(final String key, final String value);
    void put(final String key, final int value);
    void put(final String key, final boolean value);

    String get(final String key, final String defaultValue);
    int get(final String key, final int defaultValue);
    boolean get(final String key, final boolean defaultValue);
}
