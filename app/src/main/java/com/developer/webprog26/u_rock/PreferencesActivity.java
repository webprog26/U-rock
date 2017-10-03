package com.developer.webprog26.u_rock;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;

import com.developer.webprog26.u_rock.app.URockApplication;
import com.developer.webprog26.u_rock.di.modules.PreferencesPresenterModule;
import com.developer.webprog26.u_rock.mvp.interfaces.PreferencesPresenter;
import com.developer.webprog26.u_rock.mvp.interfaces.PreferencesView;

import javax.inject.Inject;

public class PreferencesActivity extends BaseActivity implements PreferencesView{

    @Inject
    PreferencesPresenter mPreferencesPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);

        getPreferencesPresenter().setPreferencesView(this);

        if(savedInstanceState == null) {
            getPreferencesPresenter().setPreferencesFragment();
        }

    }

    @Override
    protected void setupActivityComponent() {
        URockApplication.getAppComponent().plus(new PreferencesPresenterModule()).inject(this);
    }

    private PreferencesPresenter getPreferencesPresenter() {
        return mPreferencesPresenter;
    }

    @NonNull
    @Override
    public android.app.FragmentManager getAppFragmentManager() {
        return getFragmentManager();
    }

    @Override
    public int getContainerResId() {
        return R.id.fl_prefs_container;
    }
}
