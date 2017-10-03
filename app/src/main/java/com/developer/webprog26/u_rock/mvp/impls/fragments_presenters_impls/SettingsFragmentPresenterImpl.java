package com.developer.webprog26.u_rock.mvp.impls.fragments_presenters_impls;

import com.developer.webprog26.u_rock.app.URockApplication;
import com.developer.webprog26.u_rock.helpers.interfaces.SharedPreferencesHelper;
import com.developer.webprog26.u_rock.mvp.interfaces.fragments_presenters.SettingsFragmentPresenter;
import com.developer.webprog26.u_rock.mvp.interfaces.fragments_views.SettingsView;

import javax.inject.Inject;

/**
 * Created by webprog on 03.10.17.
 */

public class SettingsFragmentPresenterImpl implements SettingsFragmentPresenter {

    @Inject
    SharedPreferencesHelper mSharedPreferencesHelper;

    private SettingsView settingsView;

    public SettingsFragmentPresenterImpl() {
        URockApplication.getAppComponent().inject(this);
    }

    @Override
    public void setSettingsView(SettingsView settingsView) {
        this.settingsView = settingsView;
    }

    @Override
    public void handleRememberLastActiveCategoryPreferenceState(boolean preferenceState) {
        getSharedPreferencesHelper().put(REMEMBER_LAST_ACTIVE_CATEGORY_PREFERENCE_KEY, preferenceState);
    }

    private SettingsView getSettingsView() {
        return settingsView;
    }

    private SharedPreferencesHelper getSharedPreferencesHelper() {
        return mSharedPreferencesHelper;
    }
}
