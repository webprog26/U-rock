package com.developer.webprog26.u_rock.mvp.impls;

import com.developer.webprog26.u_rock.fragments.SettingsFragment;
import com.developer.webprog26.u_rock.helpers.FragmentChangeHelper;
import com.developer.webprog26.u_rock.mvp.interfaces.PreferencesPresenter;
import com.developer.webprog26.u_rock.mvp.interfaces.PreferencesView;

/**
 * Created by webprog on 03.10.17.
 */

public class PreferencesPresenterImpl implements PreferencesPresenter {

    private PreferencesView preferencesView;

    @Override
    public void setPreferencesView(PreferencesView preferencesView) {
        this.preferencesView = preferencesView;
    }

    @Override
    public void setPreferencesFragment() {
        FragmentChangeHelper.setSettingsFragment(getPreferencesView().getAppFragmentManager(),
                getPreferencesView().getContainerResId(), new SettingsFragment(), SETTINGS_FRAGMENT_TAG);
    }

    private PreferencesView getPreferencesView() {
        return preferencesView;
    }
}
