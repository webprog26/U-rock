package com.developer.webprog26.u_rock.helpers;

import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;

import com.developer.webprog26.u_rock.fragments.BaseFragment;

/**
 * Created by webprog on 16.09.17.
 */

public class FragmentChangeHelper {

    public static void changeFragment(@NonNull final FragmentManager fragmentManager,
                                      @IdRes final int containerResId,
                                      @NonNull final BaseFragment fragment,
                                      @NonNull final String fragmentTag){

        BaseFragment upcomingFragment = (BaseFragment) fragmentManager.findFragmentByTag(fragmentTag);

        if(upcomingFragment != null) {
            fragmentManager.beginTransaction().replace(containerResId, fragment, fragmentTag).commit();
            return;
        }

        fragmentManager.beginTransaction().add(containerResId, fragment, fragmentTag).commit();
    }
}
