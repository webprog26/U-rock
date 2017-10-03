package com.developer.webprog26.u_rock.holders;

import android.content.Intent;
import android.support.annotation.NonNull;

/**
 * Created by webprog on 03.10.17.
 */

public interface MainViewIntentsHolder {

    @NonNull
    Intent getSettingsActivityIntent();

    @NonNull
    Intent getFeedbackActivityIntent();

}
