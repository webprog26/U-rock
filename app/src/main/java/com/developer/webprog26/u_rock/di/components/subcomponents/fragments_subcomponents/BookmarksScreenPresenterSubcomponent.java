package com.developer.webprog26.u_rock.di.components.subcomponents.fragments_subcomponents;

import com.developer.webprog26.u_rock.di.modules.fragments_presenters_modules.BookmarksScreenPresenterModule;
import com.developer.webprog26.u_rock.fragments.BookmarksScreenFragment;

import dagger.Subcomponent;

@Subcomponent(modules = {BookmarksScreenPresenterModule.class})
public interface BookmarksScreenPresenterSubcomponent {

    void inject(BookmarksScreenFragment target);
}
