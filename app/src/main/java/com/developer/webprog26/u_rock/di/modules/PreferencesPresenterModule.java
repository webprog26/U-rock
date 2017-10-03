package com.developer.webprog26.u_rock.di.modules;

import android.support.annotation.NonNull;

import com.developer.webprog26.u_rock.di.scopes.ActivityScope;
import com.developer.webprog26.u_rock.mvp.impls.PreferencesPresenterImpl;
import com.developer.webprog26.u_rock.mvp.interfaces.PreferencesPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by webprog on 03.10.17.
 */
@Module
public class PreferencesPresenterModule {

    @Provides
    @NonNull
    @ActivityScope
    PreferencesPresenter providePreferencesPresenter(){
        return new PreferencesPresenterImpl();
    }
}
