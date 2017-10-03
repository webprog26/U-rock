package com.developer.webprog26.u_rock;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by webprog on 11.09.17.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        PreferenceManager.setDefaultValues(this,R.xml.preferences, false);

        setupActivityComponent();
    }

    /**
     * Sets up dagger component with lifecycle similar to current activity
     */
    protected abstract void setupActivityComponent();
}
