package com.developer.webprog26.u_rock.mvp.interfaces;

/**
 * Created by webprog on 03.10.17.
 */

public interface PreferencesPresenter {

    String SETTINGS_FRAGMENT_TAG = "settings_fragment_tag";

    void setPreferencesView(final PreferencesView preferencesView);
    void setPreferencesFragment();
    void detach();
}
