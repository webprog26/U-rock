package com.developer.webprog26.u_rock.di.components;

import com.developer.webprog26.u_rock.di.components.subcomponents.MainPresenterSubcomponent;
import com.developer.webprog26.u_rock.di.components.subcomponents.fragments_subcomponents.BookmarksScreenPresenterSubcomponent;
import com.developer.webprog26.u_rock.di.components.subcomponents.fragments_subcomponents.HomeScreenPresenterSubcomponent;
import com.developer.webprog26.u_rock.di.components.subcomponents.fragments_subcomponents.PopularScreenPresenterSubcomponent;
import com.developer.webprog26.u_rock.di.components.subcomponents.fragments_subcomponents.RecommendedScreenPresenterSubcomponent;
import com.developer.webprog26.u_rock.di.modules.AppModule;
import com.developer.webprog26.u_rock.di.modules.MainPresenterModule;
import com.developer.webprog26.u_rock.di.modules.fragments_presenters_modules.BookmarksScreenPresenterModule;
import com.developer.webprog26.u_rock.di.modules.fragments_presenters_modules.HomeScreenPresenterModule;
import com.developer.webprog26.u_rock.di.modules.fragments_presenters_modules.PopularScreenPresenterModule;
import com.developer.webprog26.u_rock.di.modules.fragments_presenters_modules.RecommendedScreenPresenterModule;
import com.developer.webprog26.u_rock.mvp.impls.MainPresenterImpl;

import dagger.Component;

/**
 * Created by webprog on 11.09.17.
 */
@Component(modules = {AppModule.class})
public interface AppComponent {

    MainPresenterSubcomponent plus(MainPresenterModule module);

    HomeScreenPresenterSubcomponent plus(HomeScreenPresenterModule module);
    PopularScreenPresenterSubcomponent plus(PopularScreenPresenterModule module);
    RecommendedScreenPresenterSubcomponent plus(RecommendedScreenPresenterModule module);
    BookmarksScreenPresenterSubcomponent plus(BookmarksScreenPresenterModule module);

    void inject(MainPresenterImpl target);
}
