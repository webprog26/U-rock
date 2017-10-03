package com.developer.webprog26.u_rock.factories;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by webprog on 03.10.17.
 */

public interface IntentFactory {

    @Nullable
    Intent createIntent(Context packageContext, Class<?> cls);
}
