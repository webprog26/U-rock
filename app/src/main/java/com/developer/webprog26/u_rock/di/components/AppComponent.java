package com.developer.webprog26.u_rock.di.components;

import com.developer.webprog26.u_rock.di.components.subcomponents.MainPresenterSubcomponent;
import com.developer.webprog26.u_rock.di.modules.AppModule;
import com.developer.webprog26.u_rock.di.modules.MainPresenterModule;

import dagger.Component;

/**
 * Created by webprog on 11.09.17.
 */
@Component(modules = {AppModule.class})
public interface AppComponent {

    MainPresenterSubcomponent plus(MainPresenterModule module);
}
