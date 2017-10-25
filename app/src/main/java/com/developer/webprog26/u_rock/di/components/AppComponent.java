package com.developer.webprog26.u_rock.di.components;

import com.developer.webprog26.u_rock.data_loading.DataRepositoryImpl;
import com.developer.webprog26.u_rock.di.components.subcomponents.MainPresenterSubcomponent;
import com.developer.webprog26.u_rock.di.components.subcomponents.PreferencesPresenterSubcomponent;
import com.developer.webprog26.u_rock.di.components.subcomponents.fragments_subcomponents.BookmarksScreenPresenterSubcomponent;
import com.developer.webprog26.u_rock.di.components.subcomponents.fragments_subcomponents.HomeScreenPresenterSubcomponent;
import com.developer.webprog26.u_rock.di.components.subcomponents.fragments_subcomponents.PopularScreenPresenterSubcomponent;
import com.developer.webprog26.u_rock.di.components.subcomponents.fragments_subcomponents.RecommendedScreenPresenterSubcomponent;
import com.developer.webprog26.u_rock.di.components.subcomponents.fragments_subcomponents.SettingsFragmentPresenterSubcomponent;
import com.developer.webprog26.u_rock.di.modules.AppModule;
import com.developer.webprog26.u_rock.di.modules.MainPresenterModule;
import com.developer.webprog26.u_rock.di.modules.PreferencesPresenterModule;
import com.developer.webprog26.u_rock.di.modules.fragments_presenters_modules.BookmarksScreenPresenterModule;
import com.developer.webprog26.u_rock.di.modules.fragments_presenters_modules.HomeScreenPresenterModule;
import com.developer.webprog26.u_rock.di.modules.fragments_presenters_modules.PopularScreenPresenterModule;
import com.developer.webprog26.u_rock.di.modules.fragments_presenters_modules.RecommendedScreenPresenterModule;
import com.developer.webprog26.u_rock.di.modules.fragments_presenters_modules.SettingsFragmentPresenterModule;
import com.developer.webprog26.u_rock.fragments.SettingsFragment;
import com.developer.webprog26.u_rock.mvp.impls.MainPresenterImpl;
import com.developer.webprog26.u_rock.mvp.impls.fragments_presenters_impls.SettingsFragmentPresenterImpl;
import com.developer.webprog26.u_rock.mvp.interfaces.fragments_presenters.SettingsFragmentPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * This interface declares methods for dependencies injections
 */
@Component(modules = {AppModule.class})
@Singleton
public interface AppComponent {

    MainPresenterSubcomponent plus(MainPresenterModule module);
    PreferencesPresenterSubcomponent plus(PreferencesPresenterModule module);

    HomeScreenPresenterSubcomponent plus(HomeScreenPresenterModule module);
    PopularScreenPresenterSubcomponent plus(PopularScreenPresenterModule module);
    RecommendedScreenPresenterSubcomponent plus(RecommendedScreenPresenterModule module);
    BookmarksScreenPresenterSubcomponent plus(BookmarksScreenPresenterModule module);
    SettingsFragmentPresenterSubcomponent plus(SettingsFragmentPresenterModule module);

    void inject(MainPresenterImpl target);
    void inject(SettingsFragmentPresenterImpl target);
    void inject(DataRepositoryImpl target);
}
