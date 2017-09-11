package com.developer.webprog26.u_rock.di.modules;

import android.support.annotation.NonNull;

import com.developer.webprog26.u_rock.di.scopes.ActivityScope;
import com.developer.webprog26.u_rock.mvp.impls.MainPresenterImpl;
import com.developer.webprog26.u_rock.mvp.interfaces.MainPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by webprog on 11.09.17.
 */
@Module
public class MainPresenterModule {

    @Provides
    @NonNull
    @ActivityScope
    MainPresenter provideMainPresenter(){
        return new MainPresenterImpl();
    }
}
