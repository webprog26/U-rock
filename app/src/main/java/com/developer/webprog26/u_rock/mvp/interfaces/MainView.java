package com.developer.webprog26.u_rock.mvp.interfaces;

import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;

/**
 * Manages app main {@link android.app.Activity} behaviour
 */

public interface MainView {

    @IdRes
    int getContainerResId();

    @NonNull
    FragmentManager getScreenFragmentManager();
}
