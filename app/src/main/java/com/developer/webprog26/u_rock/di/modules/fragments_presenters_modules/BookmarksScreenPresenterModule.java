package com.developer.webprog26.u_rock.di.modules.fragments_presenters_modules;

import android.support.annotation.NonNull;

import com.developer.webprog26.u_rock.di.scopes.FragmentScope;
import com.developer.webprog26.u_rock.mvp.impls.fragments_presenters_impls.BookmarksScreenPresenterImpl;
import com.developer.webprog26.u_rock.mvp.interfaces.fragments_presenters.BookmarksScreenPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by webprog on 15.09.17.
 */
@Module
public class BookmarksScreenPresenterModule {

    @Provides
    @NonNull
    @FragmentScope
    BookmarksScreenPresenter provideBookmarksScreenPresenter(){
        return new BookmarksScreenPresenterImpl();
    }

}
