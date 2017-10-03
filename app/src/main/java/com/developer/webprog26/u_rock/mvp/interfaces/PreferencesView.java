package com.developer.webprog26.u_rock.mvp.interfaces;

import android.app.FragmentManager;
import android.support.annotation.NonNull;

/**
 * Created by webprog on 03.10.17.
 */

public interface PreferencesView extends BaseView {

    @NonNull
    FragmentManager getAppFragmentManager();
}
