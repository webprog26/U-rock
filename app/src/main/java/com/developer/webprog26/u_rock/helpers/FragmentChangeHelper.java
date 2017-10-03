package com.developer.webprog26.u_rock.helpers;

import android.preference.PreferenceFragment;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;

import com.developer.webprog26.u_rock.fragments.BaseFragment;

/**
 * Manages every {@link android.support.v4.app.Fragment} transaction started by clicking bottom toolbar item
 */

public class FragmentChangeHelper {

    /**
     * Makes {@link android.support.v4.app.FragmentTransaction}
     * @param fragmentManager {@link FragmentManager}
     * @param containerResId int
     * @param fragment {@link android.support.v4.app.Fragment}a
     * @param fragmentTag {@link String}
     */
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

    /**
     * Makes {@link android.support.v4.app.FragmentTransaction}
     * @param fragmentManager {@link FragmentManager}
     * @param containerResId int
     * @param fragment {@link android.support.v4.app.Fragment}a
     * @param fragmentTag {@link String}
     */
    public static void setSettingsFragment(@NonNull final android.app.FragmentManager fragmentManager,
                                      @IdRes final int containerResId,
                                      @NonNull final PreferenceFragment fragment,
                                      @NonNull final String fragmentTag){

        PreferenceFragment preferenceFragment = (PreferenceFragment) fragmentManager.findFragmentByTag(fragmentTag);

        if(preferenceFragment != null) {
            fragmentManager.beginTransaction().replace(containerResId, fragment, fragmentTag).commit();
            return;
        }

        fragmentManager.beginTransaction().add(containerResId, fragment, fragmentTag).commit();
    }
}
