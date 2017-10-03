package com.developer.webprog26.u_rock.mvp.interfaces.fragments_presenters;

import com.developer.webprog26.u_rock.mvp.interfaces.fragments_views.SettingsView;

/**
 * Created by webprog on 03.10.17.
 */

public interface SettingsFragmentPresenter {

    String REMEMBER_LAST_ACTIVE_CATEGORY_PREFERENCE_KEY = "pref_remember_last_active_category";

    void setSettingsView(SettingsView settingsView);

    void handleRememberLastActiveCategoryPreferenceState(final boolean preferenceState);
}
