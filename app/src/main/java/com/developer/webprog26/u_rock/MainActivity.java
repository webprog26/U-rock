package com.developer.webprog26.u_rock;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;

import com.developer.webprog26.u_rock.app.URockApplication;
import com.developer.webprog26.u_rock.di.modules.MainPresenterModule;
import com.developer.webprog26.u_rock.listeners.BottomToolbarActionsListener;
import com.developer.webprog26.u_rock.mvp.interfaces.MainPresenter;
import com.developer.webprog26.u_rock.mvp.interfaces.MainView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainView{

    @IdRes
    private static final int CONTAINER_RES_ID = R.id.fl_container;

    @Inject
    MainPresenter mainPresenter;

    private FragmentManager mExistingFragmentManager;

    @BindView(R.id.bottom_navigation)
    BottomNavigationView mBottomNavigationToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mExistingFragmentManager = getSupportFragmentManager();

        final MainPresenter mainPresenter = getMainPresenter();

        mainPresenter.setMainView(this);

        if(savedInstanceState == null) {
            mainPresenter.setStartFragment();
        }

        getBottomNavigationToolbar()
                .setOnNavigationItemSelectedListener(new BottomToolbarActionsListener(getMainPresenter()));
    }

    @Override
    protected void onPause() {
        super.onPause();
            getMainPresenter().onPause();
    }

    @Override
    protected void setupActivityComponent() {
        URockApplication.getAppComponent().plus(new MainPresenterModule()).inject(this);
    }

    @Override
    public int getContainerResId() {
        return CONTAINER_RES_ID;
    }


    @NonNull
    @Override
    public FragmentManager getScreenFragmentManager() {
        return getExistingFragmentManager();
    }

    @NonNull
    @Override
    public BottomNavigationView getBottomNavigationView() {
        return getBottomNavigationToolbar();
    }

    private MainPresenter getMainPresenter() {
        return mainPresenter;
    }

    private FragmentManager getExistingFragmentManager() {
        return mExistingFragmentManager;
    }

    private BottomNavigationView getBottomNavigationToolbar() {
        return mBottomNavigationToolbar;
    }
}
