package com.developer.webprog26.u_rock.di.components.subcomponents.fragments_subcomponents;

import com.developer.webprog26.u_rock.di.modules.fragments_presenters_modules.HomeScreenPresenterModule;
import com.developer.webprog26.u_rock.di.scopes.FragmentScope;
import com.developer.webprog26.u_rock.fragments.HomeScreenFragment;

import dagger.Subcomponent;

/**
 * Created by webprog on 15.09.17.
 */
@Subcomponent(modules = {HomeScreenPresenterModule.class})
@FragmentScope
public interface HomeScreenPresenterSubcomponent {

    void inject(HomeScreenFragment target);
}
