package com.developer.webprog26.u_rock.di.components.subcomponents.fragments_subcomponents;

import com.developer.webprog26.u_rock.di.modules.fragments_presenters_modules.HomeScreenPresenterModule;
import com.developer.webprog26.u_rock.di.scopes.FragmentScope;
import com.developer.webprog26.u_rock.fragments.HomeScreenFragment;

import dagger.Subcomponent;

@Subcomponent(modules = {HomeScreenPresenterModule.class})
@FragmentScope
public interface HomeScreenPresenterSubcomponent {

    void inject(HomeScreenFragment target);
}
