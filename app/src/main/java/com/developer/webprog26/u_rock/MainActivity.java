package com.developer.webprog26.u_rock;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.developer.webprog26.u_rock.app.URockApplication;
import com.developer.webprog26.u_rock.di.modules.MainPresenterModule;
import com.developer.webprog26.u_rock.factories.IntentFactory;
import com.developer.webprog26.u_rock.holders.MainViewIntentsHolder;
import com.developer.webprog26.u_rock.holders.MainViewIntentsHolderImpl;
import com.developer.webprog26.u_rock.listeners.BottomToolbarActionsListener;
import com.developer.webprog26.u_rock.listeners.SlidingNavigationActionsListener;
import com.developer.webprog26.u_rock.mvp.interfaces.MainPresenter;
import com.developer.webprog26.u_rock.mvp.interfaces.MainView;
import com.developer.webprog26.u_rock.mvp.interfaces.OnArticlesListShouldBeUpdatedCallback;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainView, OnArticlesListShouldBeUpdatedCallback{

    private static final String TAG = "MainView";

    @IdRes
    private static final int CONTAINER_RES_ID = R.id.fl_container;

    @Inject
    MainPresenter mainPresenter;

    @Inject
    IntentFactory mainViewIntentFactory;

    private MainViewIntentsHolder mainViewIntentsHolder;

    private FragmentManager mExistingFragmentManager;
    private ActionBarDrawerToggle toggle;

    @BindView(R.id.bottom_navigation)
    BottomNavigationView mBottomNavigationToolbar;

    @BindView(R.id.dl_sliding_navigation)
    DrawerLayout mDlSlidingNavigation;

    @BindView(R.id.nav_view)
    NavigationView mNavigationView;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        final IntentFactory mainViewIntentFactory = getMainViewIntentFactory();

        //Todo replace second argument with feeadbackActivityIntent
        mainViewIntentsHolder = new MainViewIntentsHolderImpl(mainViewIntentFactory.createIntent(getApplicationContext(), PreferencesActivity.class), null);

        mExistingFragmentManager = getSupportFragmentManager();

        final MainPresenter mainPresenter = getMainPresenter();

        mainPresenter.setMainView(this);

        if(savedInstanceState == null) {
            mainPresenter.setStartFragment();
        }

        getSlidingNavigationView().setNavigationItemSelectedListener(new SlidingNavigationActionsListener(getMainPresenter(), getMainViewIntentsHolder()));

        getBottomNavigationToolbar()
                .setOnNavigationItemSelectedListener(new BottomToolbarActionsListener(getMainPresenter()));

        initToolbar();
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        getToggle().syncState();
    }

    @Override
    protected void onPause() {
        super.onPause();
            getMainPresenter().onPause();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = getDlSlidingNavigation();
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);

        MenuItem actionMenuItem = menu.findItem(R.id.action_search);

        if(actionMenuItem != null) {
            final SearchView searchView = (SearchView) actionMenuItem.getActionView();
            if(searchView != null) {
                searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        return false;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {
                        if (TextUtils.isEmpty(newText)) {

                        } else {

                        }
                        return true;
                    }
                });
            } else {
                Log.i(TAG, "SearchView is null");
            }
        }

        return true;
    }

    @Override
    protected void setupActivityComponent() {
        URockApplication.getAppComponent().plus(new MainPresenterModule()).inject(this);
    }

    private void initToolbar(){
        final Toolbar toolbar = getToolbar();

        if(toolbar != null) {
            setSupportActionBar(toolbar);

            toggle = new ActionBarDrawerToggle(this, getDlSlidingNavigation(), toolbar, R.string.open, R.string.close);
            getDlSlidingNavigation().addDrawerListener(toggle);

            final ActionBar actionBar = getSupportActionBar();

            if(actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(true);
                actionBar.setDisplayShowTitleEnabled(false);
            }
        }
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

    @Override
    public void openActivity(Intent intent) {
        if(intent != null) {
            startActivity(intent);
        }
    }

    @Override
    public void onArticlesListShouldBeUpdated() {
        getMainPresenter().loadArticlesDataWithDataRepository();
    }

    @NonNull
    @Override
    public DrawerLayout getDrawerLayout() {
        return getDlSlidingNavigation();
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

    private DrawerLayout getDlSlidingNavigation() {
        return mDlSlidingNavigation;
    }

    private ActionBarDrawerToggle getToggle() {
        return toggle;
    }

    private NavigationView getSlidingNavigationView() {
        return mNavigationView;
    }

    private Toolbar getToolbar() {
        return mToolbar;
    }

    private IntentFactory getMainViewIntentFactory() {
        return mainViewIntentFactory;
    }

    private MainViewIntentsHolder getMainViewIntentsHolder() {
        return mainViewIntentsHolder;
    }
}
