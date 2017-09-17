package com.developer.webprog26.u_rock.di.modules;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import com.developer.webprog26.u_rock.helpers.interfaces.SharedPreferencesHelper;
import com.developer.webprog26.u_rock.helpers.interfaces.SharedPreferencesHelperImpl;

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

    @Provides
    @NonNull
    SharedPreferencesHelper provideSharedPreferencesHelper(SharedPreferences sharedPreferences){
        return new SharedPreferencesHelperImpl(sharedPreferences);
    }

    @Provides
    @NonNull
    SharedPreferences provideSharedPreferences(){
        return provideAppContext().getSharedPreferences(SharedPreferencesHelper.U_ROCK_SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
    }
}
