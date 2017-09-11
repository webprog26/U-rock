package com.developer.webprog26.u_rock.di.components.subcomponents;

import com.developer.webprog26.u_rock.MainActivity;
import com.developer.webprog26.u_rock.di.modules.MainPresenterModule;
import com.developer.webprog26.u_rock.di.scopes.ActivityScope;

import dagger.Subcomponent;

/**
 * Created by webprog on 11.09.17.
 */
@Subcomponent(modules = {MainPresenterModule.class})
@ActivityScope
public interface MainPresenterSubcomponent {

    void inject(MainActivity target);
}
