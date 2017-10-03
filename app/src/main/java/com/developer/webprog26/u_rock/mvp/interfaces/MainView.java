package com.developer.webprog26.u_rock.mvp.interfaces;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;

/**
 * Manages app main {@link android.app.Activity} behaviour
 */

public interface MainView extends BaseView{

    @NonNull
    FragmentManager getScreenFragmentManager();

    @NonNull
    BottomNavigationView getBottomNavigationView();

    @NonNull
    DrawerLayout getDrawerLayout();

    void openActivity(final Intent intent);
}
