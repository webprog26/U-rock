package com.developer.webprog26.u_rock.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;

import com.developer.webprog26.u_rock.R;
import com.developer.webprog26.u_rock.app.URockApplication;
import com.developer.webprog26.u_rock.di.modules.fragments_presenters_modules.SettingsFragmentPresenterModule;
import com.developer.webprog26.u_rock.mvp.interfaces.fragments_presenters.SettingsFragmentPresenter;
import com.developer.webprog26.u_rock.mvp.interfaces.fragments_views.SettingsView;

import javax.inject.Inject;

/**
 * Created by webprog on 03.10.17.
 */

public class SettingsFragment extends PreferenceFragment implements SettingsView{

    @Inject
    SettingsFragmentPresenter settingsFragmentPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        URockApplication.getAppComponent().plus(new SettingsFragmentPresenterModule()).inject(this);
        addPreferencesFromResource(R.xml.preferences);

        getSettingsFragmentPresenter().setSettingsView(this);
        PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext()).registerOnSharedPreferenceChangeListener(this);
    }

    private SettingsFragmentPresenter getSettingsFragmentPresenter() {
        return settingsFragmentPresenter;
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

        final SettingsFragmentPresenter settingsFragmentPresenter = getSettingsFragmentPresenter();

        switch (key) {
            case SettingsFragmentPresenter.REMEMBER_LAST_ACTIVE_CATEGORY_PREFERENCE_KEY:
                settingsFragmentPresenter
                        .handleRememberLastActiveCategoryPreferenceState(sharedPreferences.getBoolean(key, false));

                break;
        }
    }
}
