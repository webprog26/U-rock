package com.developer.webprog26.u_rock.di.modules.fragments_presenters_modules;

import android.support.annotation.NonNull;

import com.developer.webprog26.u_rock.di.scopes.FragmentScope;
import com.developer.webprog26.u_rock.mvp.impls.fragments_presenters_impls.SettingsFragmentPresenterImpl;
import com.developer.webprog26.u_rock.mvp.interfaces.fragments_presenters.SettingsFragmentPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by webprog on 03.10.17.
 */
@Module
public class SettingsFragmentPresenterModule {

    @Provides
    @NonNull
    @FragmentScope
    SettingsFragmentPresenter provideSettingsFragmentPresenter(){
        return new SettingsFragmentPresenterImpl();
    }
}
