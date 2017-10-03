package com.developer.webprog26.u_rock.holders;

import android.content.Intent;
import android.support.annotation.NonNull;

/**
 * Created by webprog on 03.10.17.
 */

public class MainViewIntentsHolderImpl implements MainViewIntentsHolder {

    private final Intent settingsActivityIntent;
    private final Intent feedbackActivityIntent;

    public MainViewIntentsHolderImpl(Intent settingsActivityIntent, Intent feedbackActivityIntent) {
        this.settingsActivityIntent = settingsActivityIntent;
        this.feedbackActivityIntent = feedbackActivityIntent;
    }

    @NonNull
    @Override
    public Intent getSettingsActivityIntent() {
        return settingsActivityIntent;
    }

    @NonNull
    @Override
    public Intent getFeedbackActivityIntent() {
        return feedbackActivityIntent;
    }
}
