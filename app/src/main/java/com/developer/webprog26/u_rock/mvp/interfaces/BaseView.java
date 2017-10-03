package com.developer.webprog26.u_rock.mvp.interfaces;

import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;

/**
 * Created by webprog on 03.10.17.
 */

public interface BaseView {

    /**
     * Returns id of {@link android.support.v4.app.Fragment} container {@link android.view.View}
     * in main layout
     * @return int
     */
    @IdRes
    int getContainerResId();
}
