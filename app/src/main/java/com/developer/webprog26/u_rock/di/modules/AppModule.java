package com.developer.webprog26.u_rock.di.modules;

import android.content.Context;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by webprog on 11.09.17.
 */
@Module
public class AppModule {

    private Context mAppContext;

    public AppModule(Context context) {
        this.mAppContext = context;
    }

    @Provides
    @NonNull
    @Singleton
    Context provideAppContext(){
        return mAppContext;
    }
}
