package com.developer.webprog26.u_rock.mvp.interfaces;

import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;

/**
 * Manages app main {@link android.app.Activity} behaviour
 */

public interface MainView {

    /**
     * Returns id of {@link android.support.v4.app.Fragment} container {@link android.view.View}
     * in main layout
     * @return int
     */
    @IdRes
    int getContainerResId();

    @NonNull
    FragmentManager getScreenFragmentManager();

    @NonNull
    BottomNavigationView getBottomNavigationView();

    @NonNull
    DrawerLayout getDrawerLayout();
}
