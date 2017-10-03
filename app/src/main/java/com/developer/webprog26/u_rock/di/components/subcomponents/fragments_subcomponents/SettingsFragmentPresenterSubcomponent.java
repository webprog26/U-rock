package com.developer.webprog26.u_rock.di.components.subcomponents.fragments_subcomponents;

import com.developer.webprog26.u_rock.di.modules.fragments_presenters_modules.SettingsFragmentPresenterModule;
import com.developer.webprog26.u_rock.di.scopes.FragmentScope;
import com.developer.webprog26.u_rock.fragments.SettingsFragment;
import com.developer.webprog26.u_rock.mvp.interfaces.fragments_presenters.SettingsFragmentPresenter;

import dagger.Subcomponent;

/**
 * Created by webprog on 03.10.17.
 */
@Subcomponent(modules = {SettingsFragmentPresenterModule.class})
@FragmentScope
public interface SettingsFragmentPresenterSubcomponent {

    void inject(SettingsFragment target);
}
