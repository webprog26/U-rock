package com.developer.webprog26.u_rock.di.components.subcomponents.fragments_subcomponents;

import com.developer.webprog26.u_rock.di.modules.fragments_presenters_modules.PopularScreenPresenterModule;
import com.developer.webprog26.u_rock.di.scopes.FragmentScope;
import com.developer.webprog26.u_rock.fragments.PopularScreenFragment;

import dagger.Subcomponent;

@Subcomponent(modules = {PopularScreenPresenterModule.class})
@FragmentScope
public interface PopularScreenPresenterSubcomponent {

    void inject(PopularScreenFragment target);
}
