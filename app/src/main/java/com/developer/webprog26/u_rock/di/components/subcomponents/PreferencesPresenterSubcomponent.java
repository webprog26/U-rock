package com.developer.webprog26.u_rock.di.components.subcomponents;

import com.developer.webprog26.u_rock.PreferencesActivity;
import com.developer.webprog26.u_rock.di.modules.PreferencesPresenterModule;
import com.developer.webprog26.u_rock.di.scopes.ActivityScope;

import dagger.Subcomponent;

/**
 * Created by webprog on 03.10.17.
 */
@Subcomponent(modules = {PreferencesPresenterModule.class})
@ActivityScope
public interface PreferencesPresenterSubcomponent {

    void inject(PreferencesActivity target);
}
