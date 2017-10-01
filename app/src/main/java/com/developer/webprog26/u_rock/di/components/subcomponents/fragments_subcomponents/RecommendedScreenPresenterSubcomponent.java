package com.developer.webprog26.u_rock.di.components.subcomponents.fragments_subcomponents;

import com.developer.webprog26.u_rock.di.modules.fragments_presenters_modules.RecommendedScreenPresenterModule;
import com.developer.webprog26.u_rock.di.scopes.FragmentScope;
import com.developer.webprog26.u_rock.fragments.RecommendedScreenFragment;

import dagger.Subcomponent;

@Subcomponent(modules = {RecommendedScreenPresenterModule.class})
@FragmentScope
public interface RecommendedScreenPresenterSubcomponent {

    void inject(RecommendedScreenFragment target);
}
