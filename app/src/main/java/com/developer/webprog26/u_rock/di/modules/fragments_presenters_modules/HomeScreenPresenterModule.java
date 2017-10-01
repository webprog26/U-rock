package com.developer.webprog26.u_rock.di.modules.fragments_presenters_modules;

import android.support.annotation.NonNull;

import com.developer.webprog26.u_rock.di.scopes.FragmentScope;
import com.developer.webprog26.u_rock.mvp.impls.fragments_presenters_impls.HomeScreenPresenterImpl;
import com.developer.webprog26.u_rock.mvp.interfaces.fragments_presenters.HomeScreenPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class HomeScreenPresenterModule {

    @Provides
    @NonNull
    @FragmentScope
    HomeScreenPresenter provideHomeScreenPresenter(){
        return new HomeScreenPresenterImpl();
    }
}
